package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import shop.VirtualItem;


public class VirtualItemTest {
    private static VirtualItem virtualItem;

    @BeforeClass
    static void setUp() {
        virtualItem = new VirtualItem();
    }

    @Test
    void testVirtualItem() {
        double sizeOnDisk = 500.25;
        virtualItem.setSizeOnDisk(sizeOnDisk);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(500.25, virtualItem.getSizeOnDisk());
        softAssert.assertEquals("Class: class shop.VirtualItem; Name: null; Price: 0.0; Size on disk: 500.25", virtualItem.toString());
        softAssert.assertAll();
    }

    @AfterClass
    static void cleanUp() {
        virtualItem = null;
    }
}
