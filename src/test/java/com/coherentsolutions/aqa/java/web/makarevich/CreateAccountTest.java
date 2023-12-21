package com.coherentsolutions.aqa.java.web.makarevich;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    @DataProvider(name = "createAccountData")
    public static Object[][] createAccountData() {
        return new Object[][]{
                {"Eugen", "Makarevich", "eugenmakarevich@gmail.com", "Password123", "Password123"}
        };
    }

    @Test(dataProvider = "createAccountData")
    public void testCreateAccount(String firstName, String lastName, String email, String password, String passwordConfirmation) {
        mainPage
                .open()
                .getHeader().clickCreateAccountLink()
                .fillInAllRequiredFieldsAndSubmit(firstName, lastName, email, password, passwordConfirmation);
        Assert.assertTrue(myAccountPage.getHeader().isGreetWelcomeTextDisplayed(), "Greet welcome text is not displayed");
    }
}
