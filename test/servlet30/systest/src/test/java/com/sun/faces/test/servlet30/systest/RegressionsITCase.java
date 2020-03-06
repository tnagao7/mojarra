/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.faces.test.servlet30.systest;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RegressionsITCase extends HtmlUnitFacesITCase {

    public RegressionsITCase(String name) {
        super(name);
    }

    public static Test suite() {
        return (new TestSuite(RegressionsITCase.class));
    }

    public void test04() throws Exception {
        HtmlPage page = getPage("/faces/regression/InjectUserDefJS.jsp");
        assertTrue(page.asXml().matches("(?s).*\\s*<body>\\s*<form.*<input\\s*type=\"hidden\".*<input\\s*type=\"hidden\"\\s*name=\"jakarta.faces.ViewState\".*<script.*jsf.js.*<a\\s*href.*Are you sure.*>\\s*Link\\s*</a>\\s*<input\\s*type=\"submit\".*value=\"Button\"\\s*onclick=\"alert.*Are you sure.*</form>\\s*</body>.*"));
    }
}
