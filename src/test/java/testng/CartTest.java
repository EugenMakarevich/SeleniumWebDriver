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
    private static Cart cart;
    private static RealItem car;
    private static VirtualItem disk;

    @BeforeClass
    static void setUp() {
        cart = new Cart("TestCart");
        car = new RealItem();
        disk = new VirtualItem();
    }

    @Test
    void testCartName() {
        Assert.assertEquals("TestCart", cart.getCartName());
    }

    @Test
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

    @AfterClass
    static void cleanUp() {
        cart = null;
    }
}
