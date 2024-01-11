package com.coherentsolutions.aqa.web.makarevich.services;

import com.coherentsolutions.aqa.web.makarevich.model.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AddressService {
    @FindBy(css = "#additional-addresses-table tbody tr")
    private List<WebElement> rows;
    private List<Address> addresses = new ArrayList<>();

    protected WebDriver driver;

    public AddressService(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getAddressDataFromPage() {
        for (WebElement row : rows) {
            Address address = new Address();

            List<WebElement> cols = row.findElements(By.cssSelector("td"));

            address.setFirstName(cols.get(0).getText());
            address.setLastName(cols.get(1).getText());
            address.setStreetAddress(cols.get(2).getText());
            address.setCity(cols.get(3).getText());
            address.setCountry(cols.get(4).getText());
            address.setState(cols.get(5).getText());
            address.setZipCode(cols.get(6).getText());
            address.setPhone(cols.get(7).getText());

            addresses.add(address);
        }

        for (Address address : addresses) {
            System.out.println(address);
        }
    }
}