package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.model.User;
import io.qameta.allure.Step;
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

    @Step("Fill in required fields and submit account")
    public MyAccountPage registerAccount(User user) {
        fillRegistrationFields(user);
        createAccountButton.click();
        return new MyAccountPage(driver);
    }

    @Step("Get contact information")
    public String getContactInformation() {
        return contactInformationText.getText();
    }

    @Step("Get First and Last name")
    public String getFirstLastName(String contactInformation) {
        String[] lines = contactInformation.split("\n");
        return lines[0];
    }

    @Step("Fill in required fields")
    private void fillRegistrationFields(User user) {
        firstNameField.sendKeys(user.getFirstName());
        lastNameField.sendKeys(user.getLastName());
        emailAddressField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        passwordConfirmationField.sendKeys(user.getPassword());
    }
}
