package com.gic.tution_center.stepDefinitions;

import com.gic.tution_center.pageFactory.LoginPage;
import com.gic.tution_center.utils.CommonFunctions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class forgotPassword extends CommonFunctions{

    public LoginPage loginPage;

    @When("^i click Forgot your password link$")
    public void i_click_Forgot_your_password_link()  {
      loginPage = new LoginPage(driver);
      loginPage.forgotPasswordLink();
      }

    @Then("^i should be in Recover your Password page$")
    public void i_should_be_in_Recover_your_Password_page()  {

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='d-block']")).isDisplayed());
    }

    @When("^i enter valid admin emailID into Username field \"([^\"]*)\"$")
    public void i_enter_valid_admin_emailID_into_Username_field(String adminEmailID) throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed());
        Thread.sleep(20000);
        System.out.println("email id ...." + adminEmailID);
        loginPage.setUserName(adminEmailID);
    }

    @When("^i click Send Recovery Link button$")
    public void i_click_Send_Recovery_Link_button() throws InterruptedException {
       Thread.sleep(10000);
       driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("^recovery mail should be sent and login page should be loaded with message \"([^\"]*)\"$")
    public void recovery_mail_should_be_sent_and_login_page_should_be_loaded_with_message(String passResetEmailMsg) throws InterruptedException {
        Thread.sleep(30000);
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Password Reset Email Sent')]")).getText(),passResetEmailMsg);
    }

    @When("^i enter unregistered email ID into Username field \"([^\"]*)\"$")
    public void i_enter_unregistered_email_ID_into_Username_field(String unRegEmail) throws InterruptedException {
        System.out.println("un reg email " + unRegEmail);
        Thread.sleep(10000);
        loginPage.setUserName(unRegEmail);
    }

    @Then("^i should see the no record of that error message \"([^\"]*)\"$")
    public void i_should_see_the_no_record_of_that_error_message(String unRegUsrErrMsg) throws InterruptedException {
        Thread.sleep(20000);
        System.out.println("unRegErrMsg is =" + unRegUsrErrMsg);
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'No record of that email address.')]")).getText(), unRegUsrErrMsg);

    }

    @When("^i leave Username field blank$")
    public void i_leave_Username_field_blank()  {
        loginPage.setUserName("");
    }

    @Then("^i should see the email address required error message \"([^\"]*)\"$")
    public void i_should_see_the_email_address_required_error_message(String emailAddReqMsg) throws InterruptedException {
        //Thread.sleep(20000);
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'The Email Address field is required.')]")).getText(), emailAddReqMsg);
    }
}
 