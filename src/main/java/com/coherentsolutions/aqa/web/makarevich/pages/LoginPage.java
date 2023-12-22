package com.coherentsolutions.aqa.web.makarevich.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @Step("Fill in Email and Password fileds and Sign in")
    public MyAccountPage fillInRequiredFieldsAndSubmit(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return new MyAccountPage(driver);
    }
}
