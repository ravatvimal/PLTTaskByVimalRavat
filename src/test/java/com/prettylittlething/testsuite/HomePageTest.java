package com.prettylittlething.testsuite;

import com.prettylittlething.customlisteners.CustomListeners;
import com.prettylittlething.pages.*;
import com.prettylittlething.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class HomePageTest extends BaseTest {
    HomePage homePage;
    HomeShoppingPage homeShoppingPage;
    ShoppingBagPage shoppingBagPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        homeShoppingPage = new HomeShoppingPage();
        shoppingBagPage = new ShoppingBagPage();
        checkoutPage = new CheckoutPage();
        paymentPage = new PaymentPage();
    }
    @Test
    public void verifyUserCanPurchaseAnItem() throws InterruptedException {
        //Navigate to https://www.prettylittlething.com
        homePage.clickToAcceptCookies();
        Thread.sleep(1000);
        //Choose random Category from the nav menu
        homePage.clickOnHOmeShoppingOnHomePage();
        //Choose random item from PDP page
        homeShoppingPage.clickBambinoLittleStarBabyMilestoneCardsProductTab();
        //Select add to bag
        homeShoppingPage.clickOnShoppingBagTab();
        //Assert your product name against the product name in your bag page
        Assert.assertEquals(homeShoppingPage.mouseHoverAndGetTextFromTheShoppingBag(), "Bambino Little Star Baby Milestone Cards", "Not such text displayed");
        //Select the bag icon on the top right
        homeShoppingPage.clickOnShoppingBagIcon();
        //Store the subtotal value in a string
        String value = shoppingBagPage.getStringValueFromSubTotal();
        //Select Proceed to checkout
        shoppingBagPage.clickOnProceedToCheckoutTab();
        Thread.sleep(60000);
        //Enter username and select continue
        checkoutPage.enterCustomerEmailAddress("ravat13_vimal@yahoo.com");
        //Enter password and select continue
        checkoutPage.enterPassword("Test@2023");
        //Assert your bag subtotal against the checkout subtotal
        Assert.assertEquals(value, checkoutPage.getStringValueFromSubTotalOnCheckoutPage(), "Sub Total value does not match");
        //Scroll to the payment method
        paymentPage.scrollDownToPaymentPage();
        Thread.sleep(20000);
        //Select a payment method
        paymentPage.clickOnPayWithCard();
        //Close browser
    }
}
