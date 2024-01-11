package com.coherentsolutions.aqa.web.makarevich.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

@Slf4j
public class AddNewAddressPage extends PageBase {
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
    public AddressBookPage fillInRequiredFieldsAndSave(String phone, String address, String city, String zip) {
        phoneField.sendKeys(phone);
        streetAddressFirstField.sendKeys(address);
        cityField.sendKeys(city);
        selectRandomOptionFromDropdown(stateDropdown);
        zipField.sendKeys(zip);
        saveAddressButton.click();
        return new AddressBookPage(driver);
    }

    private void selectRandomOptionFromDropdown(WebElement dropdownElement) {
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();

        if (!options.isEmpty()) {
            int randomIndex = new Random().nextInt(options.size());
            String randomOptionValue = options.get(randomIndex).getAttribute("value");
            dropdown.selectByValue(randomOptionValue);
        } else {
            log.info("No options available in the dropdown.");
        }
    }
}
