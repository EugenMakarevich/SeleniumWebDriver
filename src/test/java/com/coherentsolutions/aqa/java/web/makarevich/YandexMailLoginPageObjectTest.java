package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.exceptions.TestInfrastructureException;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.*;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestSuitConstants.YANDEX;

public class YandexMailLoginPageObjectTest extends TestBase {

    @Test(groups = {YANDEX}, description = "Log into Yandex Mail")
    @Description("Log into Yandex Mail with valid credentials")
    public void testYandexMailLoginPageObject() throws TestInfrastructureException {
        yandex360MailPage
                .open()
                .takeScreenshot(SCREENSHOT_PNG_NAME)
                .clickLoginButton()
                .enterUsername(YANDEX_MAIL_USERNAME_2)
                .submitUsername()
                .enterPassword(YANDEX_MAIL_PASSWORD_2)
                .submitPassword();
        Assert.assertTrue(yandexMailInboxPage.getHeader().isAccountNameDisplayed(),"Account name is not displayed!");

        String actualUsername = yandexMailInboxPage.getHeader().getAccountName();
        //Assert.assertEquals(YANDEX_MAIL_USERNAME_2, actualUsername, "Username does not match with displayed user account name!");
        Assert.assertEquals("YANDEX_MAIL_USERNAME_2", actualUsername, "Username does not match with displayed user account name!");
    }
}
