package com.coherentsolutions.aqa.web.makarevich.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Slf4j
public class AddNewAddressPage extends PageBase {
    @FindBy(id = "firstname")
    private WebElement firstNameField;
    @FindBy(id = "lastname")
    private WebElement lastNameField;
    @FindBy(id = "telephone")
    private WebElement phoneField;
    @FindBy(id = "street_1")
    private WebElement streetAddressFirstField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "region_id")
    private WebElement stateDropdown;
    @FindBy(id = "zip")
    private WebElement zipField;
    @FindBy(id = "country")
    private WebElement countryDropdown;
    @FindBy(className = "save")
    private WebElement saveAddressButton;

    protected AddNewAddressPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill in all required fields and Save new address")
    public AddressBookPage fillInRequiredFieldsAndSave(String firstName, String lastName, String phone, String street, String city, String state, String zip, String country) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        phoneField.sendKeys(phone);
        streetAddressFirstField.sendKeys(street);
        cityField.sendKeys(city);
        new Select(stateDropdown).selectByVisibleText(state);
        zipField.sendKeys(zip);
        new Select(countryDropdown).selectByVisibleText(country);
        saveAddressButton.click();
        return new AddressBookPage(driver);
    }
}
