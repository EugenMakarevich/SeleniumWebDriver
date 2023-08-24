package testng;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;

import static constants.TestConstants.RESOURCE_PATH;

public class JsonParserTest {
    private static Cart expectedCart;
    private JsonParser parser = new JsonParser();
    private static File json;

    @BeforeAll
    static void setUp() {
        //Create new cart
        expectedCart = new Cart("TestCart");

        RealItem car = new RealItem();
        car.setName("Audi");
        car.setPrice(32026.9);
        car.setWeight(1560);

        VirtualItem disk = new VirtualItem();
        disk.setName("Windows");
        disk.setPrice(11);
        disk.setSizeOnDisk(20000);

        expectedCart.addRealItem(car);
        expectedCart.addVirtualItem(disk);
    }

    @Test
    void testJsonParser() {
        //Write cart to the json file
        parser.writeToFile(expectedCart);

        //Newly created JSON file
        json = new File(String.format("%s%s.json", RESOURCE_PATH, expectedCart.getCartName()));

        //Read the cart from file
        Cart actualCart = parser.readFromFile(json);

        //Assert
        Assertions.assertNotNull(actualCart);
        Assertions.assertEquals(expectedCart.getCartName(), actualCart.getCartName());
    }

    @ParameterizedTest
    @ValueSource(strings = {RESOURCE_PATH + "test1.json", RESOURCE_PATH + "test2.json", RESOURCE_PATH + "test3.json",
            RESOURCE_PATH + "test4.json", RESOURCE_PATH + "test5.json"})
    @Disabled
    void testReadFromFileWithMissingFile(String uri) {
        File json = new File(uri);

        //Assert
        Assertions.assertThrows(NoSuchFileException.class, () -> parser.readFromFile(json));
    }

    @AfterAll
    static void cleanUp() {
        if (json.exists()) {
            boolean deleted = json.delete();
            if (!deleted) {
                System.out.println("Failed to delete the JSON file.");
            }
        }
    }
}