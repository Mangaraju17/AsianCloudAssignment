package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{

    public HomePage() {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[text()=' Domain ']")
    @CacheLookup
    WebElement domainLink;

    @FindBy(xpath = "//div[@class='vue-avatar--wrapper']")
    @CacheLookup
    WebElement userAvatarIcon;

    @FindBy(xpath = "//button[text()='Logout']")
    @CacheLookup
    WebElement logoutButton;

    public boolean verifyDashboardDisplayed(){
        waitforElement(domainLink);
        return domainLink.isDisplayed();
    }

    public void logout(){
        userAvatarIcon.click();
        logoutButton.click();
    }

}
