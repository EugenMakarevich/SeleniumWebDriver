package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import com.coherentsolutions.aqa.web.makarevich.services.ProductService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_EMAIL;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_PASSWORD;

public class AddToWishlistTest extends TestBase {
    @Test(groups = "Online Store")
    public void testAddToWishlist() {
        loginPage.login(MAGENTO_EMAIL, MAGENTO_PASSWORD);
        Assert.assertEquals(driver().getTitle(), "My Account", "Title of the page is different from expected");

        myAccountPage
                .openWomenTopJacketsPage()
                .goToRandomProductPage();
        Product product = productPage.getProductDataFromPage();
        Assert.assertNotNull(product, "The Product object is empty");

        productPage.clickOnAddProductToWishListLink();
        Assert.assertFalse(myWhishListPage.isWhishlistEmpty(), "Wish list is empty");

        List<Product> wishListItems = new ProductService(driver()).getProductDataFromAllPages();
        Assert.assertTrue(wishListItems.contains(product), "Wish List does not contain the product");
    }
}
