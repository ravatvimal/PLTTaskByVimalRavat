package com.prettylittlething.pages;

import com.aventstack.extentreports.Status;
import com.prettylittlething.customlisteners.CustomListeners;
import com.prettylittlething.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingBagPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//body/main[1]/div[1]/div[1]/div[2]/div[5]/p[1]/span[1]")
    WebElement subTotalValueString;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button btn-proceed track-cart-proceed analytics-tracking btn-proceed--checkout']//span[1]//span[@data-event-label='Bottom Button']")
    WebElement proceedToCheckoutTab;

    public String getStringValueFromSubTotal() {
        String valueFromSubTotal = getTextFromElement(subTotalValueString);
        return valueFromSubTotal;
    }

    public void clickOnProceedToCheckoutTab() {
        clickOnElement(proceedToCheckoutTab);
        CustomListeners.test.log(Status.PASS, "Click on proceed to checkout");
    }
}
