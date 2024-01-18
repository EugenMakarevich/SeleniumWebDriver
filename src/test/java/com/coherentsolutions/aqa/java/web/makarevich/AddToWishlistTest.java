package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.services.ProductService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_EMAIL;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_PASSWORD;

public class AddToWishlistTest extends TestBase {
    @Test
    public void testAddToWishlist() {
        mainPage
                .open()
                .getHeader().clickSignInLink()
                .fillInRequiredFieldsAndSubmit(MAGENTO_EMAIL, MAGENTO_PASSWORD);
        Assert.assertEquals(driver().getTitle(), "Home Page", "Title of the page is different from expected");

        myAccountPage
                .openWomenTopJacketsPage();

        ProductService productService = new ProductService(driver());
        productService.goToRandomProductPage();

        //Navigate to wishlist: https://magento.softwaretestingboard.com/wishlist/
        //Check if it's empty or not
        //If it is not empty Clear all the items so wishlist is empty:
        //Hover on the element
        //Verify the remove link is displayed
        //Click on the remove link
        //Navigate to the category Women -> Tops -> Jackets
        //Collect all the items on the page
        //Click on the random one
    }
}
