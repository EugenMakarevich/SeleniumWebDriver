package com.coherentsolutions.aqa.web.makarevich.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMailLoginPage extends PageBase {
    @FindBy(id = "passp-field-login")
    private WebElement usernameField;
    @FindBy(id = "passp-field-passwd")
    private WebElement passwordField;
    @FindBy(id = "passp:sign-in")
    private WebElement loginButton;

    public YandexMailLoginPage(WebDriver driver) {
        super(driver);
    }

    public YandexMailLoginPage enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public YandexMailLoginPage enterPassword(String pass) {
        passwordField.sendKeys(pass);
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
        loginButton.click();
    }
}
