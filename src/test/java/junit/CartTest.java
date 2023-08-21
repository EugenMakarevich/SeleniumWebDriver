package junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static constants.TestConstants.TAX;

public class CartTest {
    private static Cart cart;
    private static RealItem car;
    private static VirtualItem disk;

    @BeforeAll
    static void setUp() {
        cart = new Cart("TestCart");
        car = new RealItem();
        disk = new VirtualItem();
    }

    @Test
    void testCartName() {
        Assertions.assertEquals("TestCart", cart.getCartName());
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
        Assertions.assertEquals(expectedTotalPrice, cart.getTotalPrice());
    }

    @AfterAll
    static void cleanUp() {
        //Delete items from the cart
        cart.deleteRealItem(car);
        cart.deleteVirtualItem(disk);
        cart = null;
    }
}
