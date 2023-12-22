package com.coherentsolutions.aqa.java.web.makarevich;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void testLogin() {
        mainPage
                .open()
                .getHeader().clickSignInLink()
                .fillInRequiredFieldsAndSubmit("eugendallas@gmail.com", "Password123");
        Assert.assertEquals(driver().getTitle(), "Home Page", "Title of the page is different from expected");
    }
}
