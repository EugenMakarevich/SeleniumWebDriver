package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.model.Address;
import com.coherentsolutions.aqa.web.makarevich.services.AddressService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_EMAIL;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_PASSWORD;

public class AddNewAddressTest extends TestBase {
    @DataProvider(name = "addNewAddress")
    public static Object[][] addNewAddress() {
        String timestamp = new SimpleDateFormat("mmssSSS").format(new Date());

        return new Object[][]{
                {"FirstName" + timestamp, "LastName" + timestamp, timestamp, "Street " + timestamp, "City " + timestamp, "Texas", "12345", "United States"}
        };
    }

    @Test(dataProvider = "addNewAddress")
    public void testAddNewAddress(String firstName, String lastName, String phone, String street, String city, String state, String zip, String country) {
        mainPage
                .open()
                .getHeader().clickSignInLink()
                .fillInRequiredFieldsAndSubmit(MAGENTO_EMAIL, MAGENTO_PASSWORD);
        Assert.assertEquals(driver().getTitle(), "Home Page", "Title of the page is different from expected");

        myAccountPage
                .openAddNewAddressPage()
                .fillInRequiredFieldsAndSave(firstName, lastName, phone, street, city, state, zip, country);
        Assert.assertEquals(driver().getTitle(), "Address Book", "Title of the page is different from expected");

        List<Address> addresses = new AddressService(driver()).getAddressDataFromAllPages();
        Assert.assertFalse(addresses.isEmpty(), "Address list is empty");

        Address address = new Address();
        address.setFirstName(firstName);
        address.setLastName(lastName);
        address.setPhone(phone);
        address.setStreetAddress(street);
        address.setCity(city);
        address.setState(state);
        address.setZipCode(zip);
        address.setCountry(country);
        Assert.assertTrue(addresses.contains(address), "Address is not added");
    }
}
