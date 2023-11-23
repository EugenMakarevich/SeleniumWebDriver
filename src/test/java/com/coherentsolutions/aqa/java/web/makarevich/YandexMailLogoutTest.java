package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.exceptions.TestInfrastructureException;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.*;
import static com.coherentsolutions.aqa.web.makarevich.constants.GlobalConstants.YANDEX;

public class YandexMailLogoutTest extends TestBase {

    @Test(groups = {YANDEX}, description = "Log out Yandex Mail")
    @Description("Log into Yandex Mail and log out")
    public void testYandexMailLogout() throws TestInfrastructureException {
        yandex360MailPage
                .open()
                .takeScreenshot(SCREENSHOT_PNG_NAME)
                .clickLoginButton()
                .enterUsername(YANDEX_MAIL_USERNAME_2)
                .submitUsername()
                .enterPassword(YANDEX_MAIL_PASSWORD_2)
                .submitPassword();
        Assert.assertTrue(yandexMailInboxPage.getHeader().isAccountImgDisplayed(), "Account image is not displayed!");

        yandexMailInboxPage.getHeader().clickAccountImg().clickLogoutLink();
        Assert.assertTrue(yandex360MailPage.isLoginButtonDisplayed(), "Login button is not displayed!");
    }
}
