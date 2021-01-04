package com.gic.tution_center.stepDefinitions;

import com.gic.tution_center.pageFactory.LoginPage;
import com.gic.tution_center.utils.CommonFunctions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminLogin extends CommonFunctions {

    public LoginPage loginPage;

    @When("^i enter valid value to username field as \"(.*?)\"$")
    public void i_enter_valid_value_to_username_field_as(String username) {
        loginPage.setUserName(username);
    }

    @When("^i enter valid value to password field as \"(.*?)\"$")
    public void i_enter_valid_value_to_password_field_as(String password) {
        loginPage.setPassword(password);
    }

    @Then("^i should be in application dashboard page$")
    public void i_should_be_in_application_dashboard_page() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertTrue(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]")).isDisplayed());
    }


    @Given("^i am in login page \"(.*?)\"$")
    public void i_am_in_login_page(String baseURL)   {
        loginPage = new LoginPage(driver);
        driver.get(baseURL);
    }


    @When("^i leave username and password fields blank and click Login button$")
    public void i_leave_username_and_password_fields_blank_and_click_Login_button() {
        loginPage.setUserName("");
        loginPage.setPassword("");
        loginPage.submitLoginDetails();
    }

    @When("^i enter valid username and leave the Password field blank as \"(.*?)\"$")
    public void i_enter_valid_username_and_leave_the_Password_field_blank_as(String username)   {
        loginPage.setUserName(username);

    }

    @When("^i enter un-registered username and password as \"(.*?)\" and \"(.*?)\"$")
    public void i_enter_un_registered_username_and_password_as_and(String username, String password)   {
        loginPage.setUserName(username);
        loginPage.setPassword(password);

    }


    @When("^i enter valid admin username and incorrect admin password as \"(.*?)\" and \"(.*?)\"$")
    public void i_enter_valid_admin_username_and_incorrect_admin_password_as_and(String username, String invalidPassword)   {
        loginPage.setUserName(username);
        loginPage.setPassword(invalidPassword);

    }

    @When("^i click login button$")
    public void i_click_Login_button()   {
        loginPage.submitLoginDetails();

    }

    @When("^i enter admin username as \"(.*?)\"$")
    public void i_enter_admin_username_as(String username) {
        loginPage.setUserName(username);
    }

    @When("^i enter username and password as \"(.*?)\" and \"(.*?)\"$")
    public void i_enter_username_and_password_as_and(String userName, String password)  {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
   }

    @Then("^login should fail with messages \"(.*?)\" and \"(.*?)\"$")
    public void login_should_fail_with_messages_and(String userNameReqMsg, String passwordReqMsg)  {
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'The Email/Username field is required.')]")).getText(), userNameReqMsg);
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'The Password field is required.')]")).getText(), passwordReqMsg);

    }
    @When("^i leave username field blank and enter valid password into Password field as \"(.*?)\"$")
    public void i_leave_username_field_blank_and_enter_valid_password_into_Password_field_as(String password)  {
        loginPage.setUserName("");
        loginPage.setPassword(password);

    }

    @Then("^login should fail with message \"(.*?)\"$")
    public void login_should_fail_with_message(String errorMsg) {
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'"+errorMsg+"')]")).getText(), errorMsg);
    }

    @When("^i enter admin password as \"(.*?)\"$")
    public void i_enter_admin_password_as(String password)  {
        loginPage.setPassword(password);

    }
}

