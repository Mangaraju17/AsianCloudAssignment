package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{


	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='username' and @name ='username']")
	@CacheLookup
	WebElement emailInput;

	@FindBy(xpath = "//input[@id='password' and @name ='password']")
	@CacheLookup
	WebElement passwordInput;

	@FindBy(xpath = "//input[@id='kc-login' and @name ='login']")
	@CacheLookup
	WebElement loginButton;

	@FindBy(id = "input-error")
	@CacheLookup
	WebElement invalidUsernameError;





	public void setEmail(String email) {
		emailInput.click();
		emailInput.clear();
		emailInput.sendKeys(email);
	}

	public void setPassword(String password) {
		passwordInput.click();
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void clickOnSignin() {
		loginButton.click();
	}
	public boolean verifyLoginButtonDisplayed() {
		waitforElement(loginButton);
		return loginButton.isDisplayed();
	}

	public boolean verifyInvalidUsernameErrorDisplayed() {
		waitforElement(invalidUsernameError);
		return invalidUsernameError.isDisplayed();
	}

	public void login(String email,String password){
		setEmail(email);
		setPassword(password);
		clickOnSignin();
	}

}
