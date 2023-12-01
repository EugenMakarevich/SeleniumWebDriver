package com.coherentsolutions.aqa.web.makarevich.pages;

import io.qameta.allure.Step;
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

    @Step("Enter username: {0}")
    public YandexMailLoginPage enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    @Step("Enter password: {0}")
    public YandexMailLoginPage enterPassword(String pass) {
        passwordField.sendKeys(pass);
        return this;
    }

    @Step("Submit username")
    public YandexMailLoginPage submitUsername() {
        clickLoginButton();
        return this;
    }

    @Step("Submit password")
    public YandexMailInboxPage submitPassword() {
        clickLoginButton();
        return new YandexMailInboxPage(driver);
    }

    @Step("Click on Login button")
    private void clickLoginButton() {
        loginButton.click();
    }
}
