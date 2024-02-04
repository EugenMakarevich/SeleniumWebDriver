package com.coherentsolutions.aqa.java.web.makarevich;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_EMAIL;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_PASSWORD;

public class AddProductToCartTest extends TestBase {
    int prodNum = 3; //Number of products to add to cart

    @Test
    public void TestAddProductToCartTest() {
        mainPage
                .open()
                .getHeader().clickSignInLink()
                .fillInRequiredFieldsAndSubmit(MAGENTO_EMAIL, MAGENTO_PASSWORD);
        Assert.assertEquals(driver().getTitle(), "Home Page", "Title of the page is different from expected");

        myAccountPage
                .getHeader().goToCart();
        int currentPrdQuantityAdded = cartPage.getPrdQuantityFromAllPages();

        myAccountPage
                .openWomenTopJacketsPage()
                .addProductToCard(prodNum)
                .getHeader().goToCart();
        int actualProdQuantity = cartPage.getPrdQuantityFromAllPages();
        int expectedProdQuantity = prodNum + currentPrdQuantityAdded;
        Assert.assertEquals(actualProdQuantity, expectedProdQuantity, "Number of products in the cart does not match");
        Assert.assertTrue(cartPage.isCartSubtotalValid(), "Subtotal of products does not much with cart total");
    }
}
