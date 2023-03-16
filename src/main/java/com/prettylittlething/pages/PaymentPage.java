package com.prettylittlething.pages;

import com.aventstack.extentreports.Status;
import com.prettylittlething.customlisteners.CustomListeners;
import com.prettylittlething.utility.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='afterpay_container']")
    WebElement payWithCard;
    public void scrollDownToPaymentPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void clickOnPayWithCard() {
        // driver.switchTo().frame(2);
        clickOnElement(payWithCard);
        //  driver.switchTo().defaultContent();
        CustomListeners.test.log(Status.PASS, "Click on pay with card");
    }
}
