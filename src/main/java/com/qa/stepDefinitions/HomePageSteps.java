package com.qa.stepDefinitions;

import com.qa.util.TestBase;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import com.qa.pages.LoginPage;
import com.qa.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class HomePageSteps extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	

	@Given("user opens browser")
	public void user_opens_browser() {
	    TestBase.initialization();
	    
	}
	@Then("user is on login page")
	public void user_is_on_login_page() {
		loginpage=new LoginPage();
	    String title=loginpage.validateLoginPageTitle();
	    assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.", title);
	}
	@Then("user logs in to app")
	public void user_logs_in_to_app() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    
	}
	
	
	@Then("validate home page title")
	public void validate_home_page_title() {
		String hometitle=homepage.verifyHomePageTitle();
		assertEquals("CRMPRO", hometitle);
	}
	@Then("validate logged in username")
	public void validate_logged_in_username() {
		TestBase.switchframe();
		boolean flag=homepage.verifyCorrectUserName();
		Assert.assertTrue(flag);
		driver.quit();
	    
	}




}
