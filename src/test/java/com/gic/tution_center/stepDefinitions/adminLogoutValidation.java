package com.gic.tution_center.stepDefinitions;

import com.gic.tution_center.pageFactory.LoginPage;
import com.gic.tution_center.utils.CommonFunctions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class adminLogoutValidation extends CommonFunctions {

    public LoginPage loginPage;

    @Given("^i am on the login page \"(.*?)\"$")
    public void i_am_on_the_login_page(String baseUrl)   {
      loginPage = new LoginPage(driver);
      driver.get(baseUrl);

    }

   @When("^i should see admin login page$")
    public void i_should_be_see_admin_login_page()   {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[4]/div/div/div/div/div[2]/div[2]")).isDisplayed());
      
    }

    @When("^i click avatar$")
    public void i_click_avatar()   {
        driver.findElement(By.xpath("//div[@class='nav-avatar']")).click();
            }

    @When("^i click Logout from drop down$")
    public void i_click_Logout_from_drop_down() throws InterruptedException {
        Thread.sleep(10000);

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[3]")).click();
    }

    @Then("^i should be logged out from admin and login page should be loaded$")
    public void i_should_be_logged_out_from_admin_and_login_page_should_be_loaded()   {
        String loginPageText = "Please login with your email/username and password below.";
        Assert.assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h4[1]/span[1]")).getText(), loginPageText);
        }

    @When("^i enter admin username and password <\"(.*?)\"> <\"(.*?)\">$")
    public void i_enter_admin_username_and_password(String username, String password)   {
        loginPage.setUserName(username);
        loginPage.setPassword(password);

    }

    @When("^i should see admin login page and i click avatar$")
    public void i_should_see_admin_login_page_and_i_click_avatar()  {
        implicitWait(20);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[4]/div/div/div/div/div[2]/div[2]")).isDisplayed());
        driver.findElement(By.xpath("//div[@class='nav-avatar']")).click();
        implicitWait(10);

    }

    @When("^i press tab to reach Logout from drop down$")
    public void i_press_tab_to_reach_Logout_from_drop_down() throws InterruptedException {
        Thread.sleep(20000);
        driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).sendKeys(Keys.TAB);
        driver.findElement(By.xpath("//a[contains(text(),'Settings')]")).sendKeys(Keys.TAB);
    }

    @When("^i press enter key$")
    public void i_press_enter_key()  {
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).sendKeys(Keys.ENTER);
    }

    @Then("^i should be logged out from admin and back to login page$")
    public void i_should_be_logged_out_from_admin_and_back_to_login_page()   {
        String loginPageText = "Please login with your email/username and password below.";
        Assert.assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h4[1]/span[1]")).getText(), loginPageText);
    }
}

