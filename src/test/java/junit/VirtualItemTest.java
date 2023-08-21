package junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertAll;

public class VirtualItemTest {
    private static VirtualItem virtualItem;
    @BeforeAll
    static void setUp() {
        virtualItem = new VirtualItem();
    }

    @Test
    void testVirtualItem() {
        double sizeOnDisk = 500.25;
        virtualItem.setSizeOnDisk(sizeOnDisk);

        assertAll(
                () -> Assertions.assertEquals(500.25, virtualItem.getSizeOnDisk()),
                () -> Assertions.assertEquals("Class: class shop.VirtualItem; Name: null; Price: 0.0; Size on disk: 500.25", virtualItem.toString())
        );
    }

    @AfterAll
    static void cleanUp() {
        virtualItem = null;
    }
}
