package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.exceptions.TestInfrastructureException;
import com.coherentsolutions.aqa.web.makarevich.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.YANDEX_MAIL_URL;

public class Yandex360MailPage extends PageBase {
    @FindBy(id = "header-login-button")
    private WebElement loginButton;

    public Yandex360MailPage(WebDriver driver) {
        super(driver);
    }

    public Yandex360MailPage open() {
        driver.get(YANDEX_MAIL_URL);
        return this;
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public YandexMailLoginPage clickLoginButton() {
        loginButton.click();
        return new YandexMailLoginPage(driver);
    }

    public Yandex360MailPage takeScreenshot(String screenshotFileName) throws TestInfrastructureException {
        ScreenshotUtil.takeScreenshot(driver, screenshotFileName);
        return this;
    }
}
