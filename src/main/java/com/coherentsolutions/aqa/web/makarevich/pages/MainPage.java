package com.coherentsolutions.aqa.web.makarevich.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.MAGENTO_MAIN_PAGE_URL;

@Getter
public class MainPage extends PageBase {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Magento Main page")
    public MainPage open() {
        driver.get(MAGENTO_MAIN_PAGE_URL);
        return this;
    }
}
