package com.coherentsolutions.aqa.java.web.makarevich;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.YANDEX_MAIL_PASSWORD_2;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.YANDEX_MAIL_USERNAME_2;

public class YandexMailLogoutTest extends TestBase {

    @Test
    public void testYandexMailLogout() {
        yandex360MailPage.open();
        yandex360MailPage.clickLoginButton();
        yandexMailLoginPage
                .enterUsername(YANDEX_MAIL_USERNAME_2)
                .clickLoginButton()
                .enterPassword(YANDEX_MAIL_PASSWORD_2)
                .clickLoginButton();
        Assert.assertTrue(yandexMailInboxPage.getHeader().isAccountImgDisplayed(), "Account name is not displayed!");

        yandexMailInboxPage.getHeader().clickAccountImg().clickLogoutLink();
        Assert.assertTrue(yandex360MailPage.isLoginButtonDisplayed(), "Login button is not displayed!");
    }
}
