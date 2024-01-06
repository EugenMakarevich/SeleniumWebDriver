package com.coherentsolutions.aqa.web.makarevich.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    protected AddNewAddressPage(WebDriver driver) {
        super(driver);
    }
}
