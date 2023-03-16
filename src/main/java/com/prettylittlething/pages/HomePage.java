package com.prettylittlething.pages;

import com.aventstack.extentreports.Status;
import com.prettylittlething.customlisteners.CustomListeners;
import com.prettylittlething.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Accept All')]")
    WebElement acceptCookies;
    @CacheLookup
    @FindBy(linkText = "HOME")
    WebElement homeShoppingTabOnHomePage;
    public void clickToAcceptCookies() {  clickOnElement(acceptCookies);
        CustomListeners.test.log(Status.PASS,"Click on accept cookies");}
    public void clickOnHOmeShoppingOnHomePage() {
        clickOnElement(homeShoppingTabOnHomePage);
        CustomListeners.test.log(Status.PASS,"Click on home shopping on home page");}



}
