package com.coherentsolutions.aqa.java.web.makarevich;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAccountTest extends TestBase {
    @DataProvider(name = "createAccountData")
    public static Object[][] createAccountData() {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        return new Object[][]{
                //{"Eugen", "Makarevich", "eugenmakarevich@gmail.com", "Password123", "Password123"},//TODO: for test, delete
                {"AutoFirstName" + timestamp, "AutoLastName" + timestamp, "autouser" + timestamp + "@gmail.com", "Password123"}
        };
    }

    @Test(dataProvider = "createAccountData")
    public void testCreateAccount(String firstName, String lastName, String email, String password) {
        mainPage
                .open()
                .getHeader().clickCreateAccountLink()
                .fillInRequiredFieldsAndSubmit(firstName, lastName, email, password);
        Assert.assertEquals(driver().getTitle(), "My Account", "Title of the page is different from expected");

        String contactInformation = createAccountPage.getContactInformation();
        String firstLastName = createAccountPage.getFirstLastName(contactInformation);
        String expectedFirstLastName = String.format("%s %s", firstName, lastName);
        Assert.assertEquals(firstLastName, expectedFirstLastName, "First and Last Name is not correct");
    }
}
