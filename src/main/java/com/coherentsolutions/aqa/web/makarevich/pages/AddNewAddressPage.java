package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.model.Address;
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

    @Step("Add new address")
    public AddressBookPage addNewAddress(Address address) {
        fillAddressFields(address);
        saveAddressButton.click();
        return new AddressBookPage(driver);
    }

    @Step("Fill in all required fields and Save new address")
    private void fillAddressFields(Address address) {
        firstNameField.clear();
        firstNameField.sendKeys(address.getFirstName());
        lastNameField.clear();
        lastNameField.sendKeys(address.getLastName());
        phoneField.sendKeys(address.getPhone());
        streetAddressFirstField.sendKeys(address.getStreetAddress());
        cityField.sendKeys(address.getCity());
        new Select(stateDropdown).selectByVisibleText(address.getState());
        zipField.sendKeys(address.getZipCode());
    }
}
