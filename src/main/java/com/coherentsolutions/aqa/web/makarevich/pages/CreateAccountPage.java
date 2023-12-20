package com.coherentsolutions.aqa.web.makarevich.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends PageBase {
    @FindBy(id = "firstname")
    private WebElement firstNameField;
    @FindBy(id = "lastname")
    private WebElement lastNameField;
    @FindBy(id = "email_address")
    private WebElement emailAddressField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmationField;
    @FindBy(css = "button.submit")
    private WebElement createAccountButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage fillInAllRequiredFieldsAndSubmit(String firstName, String lastName, String email, String password, String passwordConfirmation) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailAddressField.sendKeys(email);
        passwordField.sendKeys(password);
        passwordConfirmationField.sendKeys(passwordConfirmation);
        createAccountButton.click();
        return this;
    }
}
