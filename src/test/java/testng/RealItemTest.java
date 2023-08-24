package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import shop.RealItem;

public class RealItemTest {
    private static RealItem realItem;
    @BeforeClass
    static void setUp() {
        realItem = new RealItem();
    }

    @Test
    void testRealItem() {
        double weight = 70.5;
        realItem.setWeight(weight);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(70.5, realItem.getWeight());
        softAssert.assertEquals("Class: class shop.RealItem; Name: null; Price: 0.0; Weight: 70.5", realItem.toString());
        softAssert.assertAll();
    }

    @AfterClass
    static void cleanUp() {
        realItem = null;
    }
}
