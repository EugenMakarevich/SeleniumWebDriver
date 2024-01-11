package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.services.AddressService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_EMAIL;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_PASSWORD;

public class AddNewAddressTest extends TestBase {
    @DataProvider(name = "addNewAddress")
    public static Object[][] addNewAddress() {
        String timestamp = new SimpleDateFormat("mmssSSS").format(new Date());

        return new Object[][]{
                {timestamp, "Address " + timestamp, "City " + timestamp, "12345"}
        };
    }

    @Test(dataProvider = "addNewAddress")
    public void testAddNewAddress(String phone, String address, String city, String zip) {
        mainPage
                .open()
                .getHeader().clickSignInLink()
                .fillInRequiredFieldsAndSubmit(MAGENTO_EMAIL, MAGENTO_PASSWORD);
        Assert.assertEquals(driver().getTitle(), "Home Page", "Title of the page is different from expected");

        myAccountPage
                .openAddNewAddressPage()
                .fillInRequiredFieldsAndSave(phone, address, city, zip);
        Assert.assertEquals(driver().getTitle(), "Address Book", "Title of the page is different from expected");

        //NullPointerException here
        //Because of the wrong driver
        //Because of the wrong locator
        //Because Page Factory is not applied
        new AddressService(driver()).getAddressDataFromPage();
    }
}
