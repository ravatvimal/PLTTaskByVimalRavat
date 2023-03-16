package com.prettylittlething.pages;

import com.aventstack.extentreports.Status;
import com.prettylittlething.customlisteners.CustomListeners;
import com.prettylittlething.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomeShoppingPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Bambino Little Star Baby Milestone Cards')]")
    WebElement bambinoLittleStarBabyMilestoneCardsProductTab;
    @CacheLookup
    @FindBy(id = "add-to-bag")
    WebElement addToShoppingBagTab;
    @CacheLookup
    @FindBy(id = "shopping-bag-text")
    WebElement shoppingBagIconOnTheTopRight;
    @CacheLookup
    @FindBy(xpath = "//p[contains(text(),'Bambino Little Star Baby Milestone Cards')]")
    WebElement textFromShoppingBag;
    public void clickBambinoLittleStarBabyMilestoneCardsProductTab() {
        clickOnElement(bambinoLittleStarBabyMilestoneCardsProductTab);
        CustomListeners.test.log(Status.PASS, "Click on Bambino Little Star Baby Milestone Cards Product");
    }
    public void clickOnShoppingBagTab() {
        clickOnElement(addToShoppingBagTab);
        CustomListeners.test.log(Status.PASS, "Click on Shopping Bag Tab");
    }
    public String mouseHoverAndGetTextFromTheShoppingBag() {
        mouseHoverToElement(shoppingBagIconOnTheTopRight);
        String shoppingBagText = getTextFromElement(textFromShoppingBag);
        CustomListeners.test.log(Status.PASS, "Sub total value ");
        return shoppingBagText;
    }

    public void clickOnShoppingBagIcon() {
        clickOnElement(shoppingBagIconOnTheTopRight);
        CustomListeners.test.log(Status.PASS, "Click on Shopping Bag icon");
    }
}
