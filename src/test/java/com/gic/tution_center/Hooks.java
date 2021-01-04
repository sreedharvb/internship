package com.gic.tution_center;

import com.gic.tution_center.utils.CommonFunctions;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    CommonFunctions commonFunctions = new CommonFunctions();

    @Before
    public void beforeTest() {

        commonFunctions.openBrowser();
    }

    @After
    public void afterTest() {
        commonFunctions.closeBrowser();

    }
}
