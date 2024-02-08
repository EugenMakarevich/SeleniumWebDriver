package com.coherentsolutions.aqa.java.web.makarevich;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_EMAIL;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.MAGENTO_PASSWORD;

public class LoginTest extends TestBase {
    @Test(groups = "Online Store")
    public void testLogin() {
        loginPage.login(MAGENTO_EMAIL, MAGENTO_PASSWORD);
        Assert.assertEquals(driver().getTitle(), "My Account", "Title of the page is different from expected");
    }
}
