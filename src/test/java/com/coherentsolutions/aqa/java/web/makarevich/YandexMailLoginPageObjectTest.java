package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.pages.Yandex360MailPage;
import com.coherentsolutions.aqa.web.makarevich.pages.YandexMailInboxPage;
import com.coherentsolutions.aqa.web.makarevich.pages.YandexMailLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.YANDEX_MAIL_PASSWORD_2;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.YANDEX_MAIL_USERNAME_2;
import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.YANDEX_MAIL_URL;

public class YandexMailLoginPageObjectTest extends TestBase {
    Yandex360MailPage yandex360MailPage;
    YandexMailLoginPage yandexMailLoginPage;
    YandexMailInboxPage yandexMailInboxPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        yandex360MailPage = new Yandex360MailPage(driver());
        yandexMailLoginPage = new YandexMailLoginPage(driver());
        yandexMailInboxPage = new YandexMailInboxPage(driver());
    }

    @Test
    public void TestYandexMailLoginPageObject() {
        driver().get(YANDEX_MAIL_URL);
        yandex360MailPage.clickLoginButton();
        yandexMailLoginPage
                .enterUsername(YANDEX_MAIL_USERNAME_2)
                .clickLoginButton()
                .enterPassword(YANDEX_MAIL_PASSWORD_2)
                .clickLoginButton();

        String actualUsername = yandexMailInboxPage.getUsername();
        Assert.assertTrue(yandexMailInboxPage.isUsernameDisplayed());
        Assert.assertEquals(YANDEX_MAIL_USERNAME_2, actualUsername);
    }
}
