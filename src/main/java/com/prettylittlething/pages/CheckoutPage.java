package com.prettylittlething.pages;

import com.aventstack.extentreports.Status;
import com.prettylittlething.customlisteners.CustomListeners;
import com.prettylittlething.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckoutPage extends Utility {
    @FindBy(id = "customer-email")
    WebElement customerEmailAddressField;
    @FindBy(id = "customer-password")
    WebElement passwordField;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[2]/div[1]/aside[1]/div[1]/div[3]/ul[1]/li[1]/span[2]")
    WebElement subTotalOnCheckoutPage;

    public void enterCustomerEmailAddress(String email) {
        Reporter.log("");
        sendTextToElement(customerEmailAddressField, email);
        customerEmailAddressField.submit();
        CustomListeners.test.log(Status.PASS, "Enter EmailId " + email);
    }
    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        passwordField.submit();
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }
    public String getStringValueFromSubTotalOnCheckoutPage() {
        String subTotal = getTextFromElement(subTotalOnCheckoutPage);
        CustomListeners.test.log(Status.PASS, "Sub total value total on checkout page ");
        return subTotal;
    }

}
