package com.epam.autothon.webtest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.epam.autothon.Constants;
import com.epam.autothon.Utilities.Utils;
import com.epam.autothon.pages.HomePage;
import com.epam.autothon.pages.LoginPage;

public class LoginTest extends BaseTest {
	


	@BeforeTest(description = "Start browser")
	public void openStartURL() {
		driver.get(TestData.START_URL);	
	}
	

	@Test
	public void verifySuccessfulLogin(){
		//homePage = new HomePage(driver);
		Utils.pauseExecution(2000); 
		//Assert.assertTrue(HomePage.using(driver).isCurrentPage(), "home page is not the current Page");
		HomePage.using(driver).PageHeader().clickLogin();
		
		logger.error("Test log");
		Utils.pauseExecution(2000); 
		//Assert.assertTrue(LoginPage.using(driver).isCurrentPage(), "login page is not the current Page");
		LoginPage.using(driver).setEmail("email@gmail.com").setPassword("password").clickLogin();
	}
	
	
}
