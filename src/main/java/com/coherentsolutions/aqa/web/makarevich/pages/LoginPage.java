package com.coherentsolutions.aqa.web.makarevich.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.LOGIN_PAGE_URL;

public class LoginPage extends MainPage {
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "pass")
    private WebElement passwordField;
    @FindBy(css = "fieldset #send2")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Login page")
    public LoginPage openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    @Step("Open login page, fill in Email and Password filed and Sign in")
    public MyAccountPage login(String email, String password) {
        openLoginPage();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return new MyAccountPage(driver);
    }
}
