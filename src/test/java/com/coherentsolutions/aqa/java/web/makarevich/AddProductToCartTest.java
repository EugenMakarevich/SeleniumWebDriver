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
                .openWomenTopJacketsPage()
                .addProductToCard(prodNum)
                .getHeader().goToCart();
        Assert.assertEquals(cartPage.getProductList().size(), prodNum, "Product in the cart does not equal to " + prodNum);
    }
}
