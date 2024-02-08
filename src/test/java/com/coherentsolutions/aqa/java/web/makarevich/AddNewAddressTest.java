package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.model.Address;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_EMAIL;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_PASSWORD;

public class AddNewAddressTest extends TestBase {
    @Test(groups = "Online Store")
    public void testAddNewAddress() {
        loginPage.login(MAGENTO_EMAIL, MAGENTO_PASSWORD);
        Assert.assertEquals(driver().getTitle(), "My Account", "Title of the page is different from expected");

        Address address = addressService.createAddress();

        myAccountPage.openAddNewAddressPage().addNewAddress(address);
        Assert.assertEquals(driver().getTitle(), "Address Book", "Title of the page is different from expected");

        List<Address> addresses = addressService.getAddressDataFromAllPages();
        Assert.assertFalse(addresses.isEmpty(), "Address list is empty");
        Assert.assertTrue(addresses.contains(address), "Address is not added");
    }
}
