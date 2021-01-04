package com.gic.tution_center.stepDefinitions;

import com.gic.tution_center.pageFactory.LoginPage;
import com.gic.tution_center.utils.Constants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public WebDriver driver;
    public LoginPage loginPage;

	@Given("^i am on the login page url \"(.*?)\"$")
	public void i_am_on_the_login_page_url(String url)  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		driver.get(url);
		driver.manage().window().maximize();

	}

	@When("^i enter username as \"(.*?)\"$")
	public void i_enter_username_as(String username) {
		loginPage.setUserName(username);
	}

	@When("^i enter the password as \"(.*?)\"$")
	public void i_eneter_the_password_as(String password)  {
		loginPage.setPassword(password);

	}

	@When("^i click the login button$")
	public void i_click_the_login_button()  {
		loginPage.submitLoginDetails();

	}

	@Then("^i should be on the dashboard page$")
	public void i_should_be_on_the_dashboard_page() throws InterruptedException {
		//driver.getCurrentUrl();
		Thread.sleep(1000);
		Assert.assertEquals(Constants.DASHBOARD_URL, driver.getCurrentUrl());
		driver.quit();

	}

}
