package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    @Test(groups = "Online Store")
    public void testCreateAccount() {
        User user = userService.createUser();

        mainPage
                .open()
                .getHeader().clickCreateAccountLink()
                .registerAccount(user);
        Assert.assertEquals(driver().getTitle(), "My Account", "Title of the page is different from expected");

        String contactInformation = createAccountPage.getContactInformation();
        String firstLastName = createAccountPage.getFirstLastName(contactInformation);
        String expectedFirstLastName = String.format("%s %s", user.getFirstName(), user.getLastName());
        Assert.assertEquals(firstLastName, expectedFirstLastName, "First and Last Name is different from expected");
    }
}
