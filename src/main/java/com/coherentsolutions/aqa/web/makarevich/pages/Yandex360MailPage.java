package com.coherentsolutions.aqa.web.makarevich.pages;

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
}
