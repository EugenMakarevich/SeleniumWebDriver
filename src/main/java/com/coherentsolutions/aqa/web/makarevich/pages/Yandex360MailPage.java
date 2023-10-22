package com.coherentsolutions.aqa.web.makarevich.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.YANDEX_MAIL_URL;

public class Yandex360MailPage extends PageBase {
    private By loginButton = By.id("header-login-button");

    public Yandex360MailPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(YANDEX_MAIL_URL);
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
