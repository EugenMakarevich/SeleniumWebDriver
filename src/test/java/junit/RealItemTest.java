package junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertAll;

public class RealItemTest {
    private static RealItem realItem;
    @BeforeAll
    static void setUp() {
        realItem = new RealItem();
    }

    @Test
    void testRealItem() {
        double weight = 70.5;
        realItem.setWeight(weight);

        assertAll(
                () -> Assertions.assertEquals(70.5, realItem.getWeight()),
                () -> Assertions.assertEquals("Class: class shop.RealItem; Name: null; Price: 0.0; Weight: 70.5", realItem.toString())
        );
    }

    @AfterAll
    static void cleanUp() {
        realItem = null;
    }
}
