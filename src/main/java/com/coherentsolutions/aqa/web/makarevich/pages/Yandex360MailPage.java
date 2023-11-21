package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.exceptions.TestInfrastructureException;
import com.coherentsolutions.aqa.web.makarevich.utils.ScreenshotUtil;
import io.qameta.allure.Step;
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

    @Step("Open Yandex Mail page")
    public Yandex360MailPage open() {
        driver.get(YANDEX_MAIL_URL);
        return this;
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    @Step("Click on login button")
    public YandexMailLoginPage clickLoginButton() {
        loginButton.click();
        return new YandexMailLoginPage(driver);
    }

    @Step("Take screenshot")
    public Yandex360MailPage takeScreenshot(String screenshotFileName) throws TestInfrastructureException {
        ScreenshotUtil.takeScreenshot(screenshotFileName);
        return this;
    }
}
