package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class CartTest {
    private static Cart cart;
    private static final double TAX = 0.2;

    @BeforeAll
    static void setUp() {
        cart = new Cart("TestCart");
    }

    @Test
    void testCartName() {
        Assertions.assertEquals("TestCart", cart.getCartName());
    }

    @Test
    void testTotalPriceCart() {
        //Set RealItem price
        RealItem car = new RealItem();
        car.setPrice(10000);

        //Set VirtualItem price
        VirtualItem disk = new VirtualItem();
        disk.setPrice(10);

        //Add items to the cart
        cart.addRealItem(car);
        cart.addVirtualItem(disk);

        double expectedTotalPrice = car.getPrice() + car.getPrice()*TAX + disk.getPrice() + disk.getPrice()*TAX;

        //Assert
        Assertions.assertEquals(expectedTotalPrice, cart.getTotalPrice());
    }
}
