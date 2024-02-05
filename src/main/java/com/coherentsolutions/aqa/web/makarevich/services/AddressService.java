package com.coherentsolutions.aqa.web.makarevich.services;

import com.coherentsolutions.aqa.web.makarevich.model.Address;
import com.github.javafaker.Faker;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Getter
public class AddressService {
    @FindBy(css = "#additional-addresses-table tbody tr")
    private List<WebElement> rows;
    @FindBy(css = "a.next")
    private WebElement nextButton;
    private List<Address> addresses = new ArrayList<>();
    protected WebDriver driver;

    public AddressService(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Address createAddress() {
        Address address = new Address();
        Faker faker = new Faker(Locale.US);
        address.setFirstName(faker.name().firstName());
        address.setLastName(faker.name().lastName());
        address.setPhone(faker.phoneNumber().cellPhone());
        address.setStreetAddress(faker.address().streetAddress());
        address.setCity(faker.address().city());
        address.setState(faker.address().state());
        address.setZipCode(faker.address().zipCode());
        address.setCountry("United States");
        return address;
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
    }

    public List<Address> getAddressDataFromAllPages() {
        while (true) {
            getAddressDataFromPage();

            //Check if there's a next page and navigate to it
            if (!driver.findElements(By.cssSelector("a.next")).isEmpty()) {
                nextButton.click();
            } else {
                break; //No more pages
            }
        }
        return addresses;
    }
}
