package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration extends BaseClass{


	public Registration() {
		PageFactory.initElements(driver, this);
	}
	
	//Register button
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	@CacheLookup
	WebElement registerButton;

	//enter email login id
	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement enterEmail;

	//enter password
	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	WebElement enterPassword;

	//config password
	@FindBy(xpath = "//input[@id='password-confirm']")
	@CacheLookup
	WebElement confirmPassword;

	//click on register button
	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	WebElement finalRegister;

	@FindBy(xpath = "//*[@class='pf-c-alert__title kc-feedback-text']")
	@CacheLookup
	WebElement errorMessage;


	
	public void clickRegister() {
		registerButton.click();
	}
	
	public void enterEmail(String email) {
		enterEmail.click();
		enterEmail.clear();
		enterEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		enterPassword.click();
		enterPassword.clear();
		enterPassword.sendKeys(password);
	}

	public void confirmPassword(String password) {
		confirmPassword.click();
		confirmPassword.clear();
		confirmPassword.sendKeys(password);
	}

	public void finalRegister() {
		finalRegister.click();
	}

	public String  getErrorMessage(){
		return errorMessage.getText();
	}


}
