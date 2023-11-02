package com.coherentsolutions.aqa.java.web.makarevich;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.*;

public class YandexMailLogoutTest extends TestBase {

    @Test
    public void testYandexMailLogout() {
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
