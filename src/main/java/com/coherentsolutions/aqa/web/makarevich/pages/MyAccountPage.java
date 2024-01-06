package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.pages.components.MagentoHeader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.ADD_NEW_ADDRESS_PAGE_URL;

public class MyAccountPage extends MainPage {
    MagentoHeader header;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        header = new MagentoHeader(driver);
    }

    @Step("Open Add New Address page")
    public AddNewAddressPage openAddNewAddressPage() {
        driver.get(ADD_NEW_ADDRESS_PAGE_URL);
        return new AddNewAddressPage(driver);
    }
}
