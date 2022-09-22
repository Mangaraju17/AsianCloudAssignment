package com.testCases;

import com.pageObjects.BaseClass;
import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.Registration;

import java.time.Duration;
import java.util.Random;

public class TC_RegisterTest extends BaseClass {


	// new user register into application
	@Test
	public void registerTest() {
		Registration register = new Registration();
		HomePage homePage = new HomePage();
		LoginPage loginPage = new LoginPage();

	Random random= new Random();
	String email = "test"+random.nextInt(999)+"@gmail.com";
	register.enterEmail(email);
	register.enterPassword(password);
	register.confirmPassword(password);
	register.finalRegister();
	Assert.assertTrue(homePage.verifyDashboardDisplayed(),"dashboard is not displayed");
	homePage.logout();
	Assert.assertTrue(loginPage.verifyLoginButtonDisplayed());
	loginPage.login(email,password);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		HomePage homePage1 = new HomePage();
	Assert.assertTrue(homePage1.verifyDashboardDisplayed(),"dashboard is not displayed");

	}

	// Existing user register into application
	@Test
	public void existingUserRegisterTest() {
		Registration register = new Registration();

		register.enterEmail(userName);
		register.enterPassword(password);
		register.confirmPassword(password);
		register.finalRegister();
		Assert.assertTrue(register.getErrorMessage().contains("Email already exists."),"error message is not displayed");
	}

	//Mismatch passwords entered in register form
	@Test
	public void passwordMisMatchTest() {
		Registration register = new Registration();

		register.enterEmail("invalid@gmail.com");
		register.enterPassword("password");
		register.confirmPassword("pass");
		register.finalRegister();
		Assert.assertTrue(register.getErrorMessage().contains("Password confirmation doesn't match."),"error message is not displayed");

	}


	// invalid email entered in register form
	@Test
	public void invalidEmailTest() {
		Registration register = new Registration();

		register.enterEmail("invalid");
		register.finalRegister();
		Assert.assertTrue(register.getErrorMessage().contains("Invalid email address."),"error message is not displayed");

	}

	//all fields are left blank and click on register
	@Test
	public void emptyDetailsTest() {
		Registration register = new Registration();
		register.clickRegister();
		register.finalRegister();
		Assert.assertTrue(register.getErrorMessage().contains("Please specify username."),"error message is not displayed");

	}
	

}
