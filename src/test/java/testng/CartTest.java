package testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static constants.TestConstants.TAX;

public class CartTest {
    private Cart cart;
    private RealItem car;
    private VirtualItem disk;

    @BeforeClass(alwaysRun = true)
    void setUp() {
        cart = new Cart("TestCart");
        car = new RealItem();
        disk = new VirtualItem();
    }

    @Test(groups = "Smoke")
    void testCartName() {
        Assert.assertEquals("TestCart", cart.getCartName());
    }

    @Test(groups = "Regression")
    void testTotalPriceCart() {
        //Set prices for the items
        car.setPrice(10000);
        disk.setPrice(10);

        //Add items to the cart
        cart.addRealItem(car);
        cart.addVirtualItem(disk);

        //Calculate expected total price
        double expectedTotalPrice = car.getPrice() + car.getPrice()*TAX + disk.getPrice() + disk.getPrice()*TAX;

        //Assert
        Assert.assertEquals(expectedTotalPrice, cart.getTotalPrice());
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        cart = null;
    }
}
