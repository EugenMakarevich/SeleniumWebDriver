package com.coherentsolutions.aqa.web.makarevich.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexMailLoginPage extends PageBase {
    private By usernameField = By.id("passp-field-login");
    private By passwordField = By.id("passp-field-passwd");
    private By loginButton = By.id("passp:sign-in");

    public YandexMailLoginPage(WebDriver driver) {
        super(driver);
    }

    public YandexMailLoginPage enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public YandexMailLoginPage enterPassword(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
        return this;
    }

    public YandexMailLoginPage submitUsername() {
        clickLoginButton();
        return this;
    }

    public YandexMailInboxPage submitPassword() {
        clickLoginButton();
        return new YandexMailInboxPage(driver);
    }

    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
