package com.coherentsolutions.aqa.java.web.makarevich;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.YANDEX_MAIL_PASSWORD_2;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.YANDEX_MAIL_USERNAME_2;

public class YandexMailLoginPageObjectTest extends TestBase {

    @Test
    public void testYandexMailLoginPageObject() {
        yandex360MailPage
                .open()
                .clickLoginButton()
                .enterUsername(YANDEX_MAIL_USERNAME_2)
                .submitUsername()
                .enterPassword(YANDEX_MAIL_PASSWORD_2)
                .submitPassword();
        Assert.assertTrue(yandexMailInboxPage.getHeader().isAccountNameDisplayed(),"Account name is not displayed!");

        String actualUsername = yandexMailInboxPage.getHeader().getAccountName();
        Assert.assertEquals(YANDEX_MAIL_USERNAME_2, actualUsername, "Username does not match with displayed user account name!");
    }
}
