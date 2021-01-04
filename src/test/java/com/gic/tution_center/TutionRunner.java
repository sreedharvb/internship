package com.gic.tution_center;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Projects\\tution-center\\src\\test\\java\\com\\gic\\tution_center\\features",
        tags = {},
        dryRun = false

        )
// @PasswordRecoveryPage @RecoverAdminPassword @RecoverPasswordBlankUserName @RecoverPasswordUnRegEmail
//plugin = {"pretty", "html:target/cucumber"}
//features = "C:\\Projects\\tution-center\\src\\test\\java\\com\\gic\\tution_center\\features\\forgotPassword.feature",

public class TutionRunner {

}
