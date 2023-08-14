package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertAll;

public class RealItemTest {

    @Test
    void testRealItem() {
        RealItem realItem = new RealItem();
        double weight = 70.5;
        realItem.setWeight(weight);

        assertAll(
                () -> Assertions.assertEquals(70.5, realItem.getWeight()),
                () -> Assertions.assertEquals("Class: class shop.RealItem; Name: null; Price: 0.0; Weight: 70.5", realItem.toString())
        );
    }
}
