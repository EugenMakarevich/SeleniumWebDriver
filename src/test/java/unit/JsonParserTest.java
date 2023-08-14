package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;

public class JsonParserTest {
    private static Cart expectedCart;
    private JsonParser parser = new JsonParser();

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
        File json = new File("src/main/resources/" + expectedCart.getCartName() + ".json");

        //Read the cart from file
        Cart actualCart = parser.readFromFile(json);

        //Assert
        Assertions.assertNotNull(actualCart);
        Assertions.assertEquals(expectedCart.getCartName(), actualCart.getCartName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"src/main/resources/test1.json", "src/main/resources/test2.json", "src/main/resources/test3.json",
            "src/main/resources/test4.json","src/main/resources/test5.json"})
    @Disabled
    void testReadFromFileWithMissingFile(String uri) {
        File json = new File(uri);

        //Assert
        Assertions.assertThrows(NoSuchFileException.class, () -> parser.readFromFile(json));
    }
}
