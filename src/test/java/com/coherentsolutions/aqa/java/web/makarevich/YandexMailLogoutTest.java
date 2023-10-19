package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.pages.Yandex360MailPage;
import com.coherentsolutions.aqa.web.makarevich.pages.YandexMailLoginPage;
import com.coherentsolutions.aqa.web.makarevich.pages.components.Header;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.YANDEX_MAIL_PASSWORD_2;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.YANDEX_MAIL_USERNAME_2;
import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.YANDEX_MAIL_URL;

public class YandexMailLogoutTest extends TestBase {
    Yandex360MailPage yandex360MailPage;
    YandexMailLoginPage yandexMailLoginPage;
    Header header;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        yandex360MailPage = new Yandex360MailPage(driver());
        yandexMailLoginPage = new YandexMailLoginPage(driver());
        header = new Header(driver());
    }

    @Test
    public void testYandexMailLogout() {
        driver().get(YANDEX_MAIL_URL);
        yandex360MailPage.clickLoginButton();
        yandexMailLoginPage
                .enterUsername(YANDEX_MAIL_USERNAME_2)
                .clickLoginButton()
                .enterPassword(YANDEX_MAIL_PASSWORD_2)
                .clickLoginButton();
        Assert.assertTrue(header.isAccountImgDisplayed());

        header.clickAccountImg().clickLogoutLink();
        Assert.assertTrue(yandex360MailPage.isLoginButtonDisplayed());
    }
}
