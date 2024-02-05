package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import com.coherentsolutions.aqa.web.makarevich.services.ProductService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_EMAIL;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_PASSWORD;

public class AddProductToCartTest extends TestBase {
    int prodNum = 3; //Number of products to add to cart

    @Test(groups = "Online Store")
    public void TestAddProductToCartTest() {
        loginPage.login(MAGENTO_EMAIL, MAGENTO_PASSWORD);
        Assert.assertEquals(driver().getTitle(), "My Account", "Title of the page is different from expected");

        myAccountPage.getHeader().goToCart();
        int currentPrdQuantityAdded = cartPage.getPrdQuantityFromAllPages();

        myAccountPage.openWomenTopJacketsPage();
        List<Product> productsAdded = productItemPage.addProductToCard(prodNum);

        productPage.getHeader().goToCart();
        int actualProdQuantity = cartPage.getPrdQuantityFromAllPages();
        int expectedProdQuantity = prodNum + currentPrdQuantityAdded;
        List<Product> productsInCart = cartPage.getProductsFromAllPages();
        Assert.assertEquals(actualProdQuantity, expectedProdQuantity, "Number of products in the cart does not match");
        Assert.assertTrue(new ProductService(driver()).isProductAddedToCart(productsAdded, productsInCart), "Product is not added to the cart");
        Assert.assertTrue(cartPage.isCartSubtotalValid(), "Subtotal of products does not much with cart subtotal");
    }
}
