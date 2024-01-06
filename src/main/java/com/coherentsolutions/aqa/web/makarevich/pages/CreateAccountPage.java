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
    @FindBy(css = ".box-information .box-content")
    private WebElement contactInformationText;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage fillInRequiredFieldsAndSubmit(String firstName, String lastName, String email, String password) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailAddressField.sendKeys(email);
        passwordField.sendKeys(password);
        passwordConfirmationField.sendKeys(password);
        createAccountButton.click();
        return new MyAccountPage(driver);
    }

    public String getContactInformation() {
        return contactInformationText.getText();
    }

    public String getFirstLastName(String contactInformation) {
        String[] lines = contactInformation.split("\n");
        return lines[0];
    }
}
