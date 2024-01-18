package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.pages.components.MagentoHeader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.*;

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

    @Step("Open Wishlist page")
    public WhishlistPage openWishlistPage() {
        driver.get(WHISHLIST_PAGE_URL);
        return new WhishlistPage(driver);
    }

    @Step("Open Women -> Top -> Jackets page")
    public void openWomenTopJacketsPage() {
        driver.get(WOMEN_TOP_JACKETS_PAGE);
    }
}
