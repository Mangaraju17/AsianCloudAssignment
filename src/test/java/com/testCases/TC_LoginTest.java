package com.testCases;

import com.pageObjects.BaseClass;
import com.pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;


public class TC_LoginTest extends BaseClass {


	//valid login creds entered properly and clearly
	@Test
	public void loginTest() {
		LoginPage	loginPage = new LoginPage();
		HomePage homePage= new HomePage();

		loginPage.setEmail(userName);
		loginPage.setPassword(password);
		loginPage.clickOnSignin();
		Assert.assertTrue(homePage.verifyDashboardDisplayed(),"dashboard is not displayed");
	}

	//incorrect login credentials entered
	@Test
	public void incorrectCredsLoginTest() {
		LoginPage	loginPage = new LoginPage();
		HomePage homePage= new HomePage();

		loginPage.setEmail(userName);
		loginPage.setPassword("test");
		loginPage.clickOnSignin();
		Assert.assertTrue(loginPage.verifyInvalidUsernameErrorDisplayed(),"error not displayed");
	}

	//invalid email login creds entered
	@Test
	public void invalidEmailLoginTest() {
		LoginPage	loginPage = new LoginPage();

		//invalid data
		loginPage.setEmail("invalid");
		loginPage.setPassword(readConfig.getPassword());
		loginPage.clickOnSignin();
		Assert.assertTrue(loginPage.verifyInvalidUsernameErrorDisplayed(),"error not displayed");
	}

	//empty login creds entered
	@Test
	public void emptyloginTest() {
		LoginPage	loginPage = new LoginPage();

		//Empty username and password
		loginPage.clickOnSignin();
		Assert.assertTrue(loginPage.verifyInvalidUsernameErrorDisplayed(),"error not displayed");
	}


}
