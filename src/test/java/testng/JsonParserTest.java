package testng;

import org.testng.Assert;
import org.testng.annotations.*;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;

import static constants.TestConstants.RESOURCE_PATH;

public class JsonParserTest {
    private Cart expectedCart;
    private JsonParser parser;
    private File json;

    @BeforeClass(alwaysRun = true)
    void setUp() {
        parser = new JsonParser();
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

    @Test(groups = {"Smoke", "Regression"})
    void testJsonParser() {
        //Write cart to the json file
        parser.writeToFile(expectedCart);

        //Newly created JSON file
        json = new File(String.format("%s%s.json", RESOURCE_PATH, expectedCart.getCartName()));

        //Read the cart from file
        Cart actualCart = parser.readFromFile(json);

        //Assert
        Assert.assertNotNull(actualCart);
        Assert.assertEquals(expectedCart.getCartName(), actualCart.getCartName());
    }

    @DataProvider(name = "missingFiles")
    public Object[][] missingFiles() {
        return new Object[][]{
                {RESOURCE_PATH + "test1.json"},
                {RESOURCE_PATH + "test2.json"},
                {RESOURCE_PATH + "test3.json"},
                {RESOURCE_PATH + "test4.json"},
                {RESOURCE_PATH + "test5.json"}
        };
    }

    @Test(dataProvider = "missingFiles", groups = "Regression")
    @Ignore
    void testReadFromFileWithMissingFile(String uri) {
        json = new File(uri);

        //Assert
        Assert.assertThrows(NoSuchFileException.class, () -> parser.readFromFile(json));
    }

    @AfterClass(alwaysRun = true)
    void cleanUp() {
        if (json.exists()) {
            boolean deleted = json.delete();
            if (!deleted) {
                System.out.println("Failed to delete the JSON file.");
            }
        }
    }
}