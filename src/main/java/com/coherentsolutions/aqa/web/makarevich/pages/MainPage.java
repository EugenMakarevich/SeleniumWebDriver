package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.pages.components.MagentoHeader;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.MAGENTO_MAIN_PAGE;

@Getter
public class MainPage extends PageBase {
    MagentoHeader header;

    public MainPage(WebDriver driver) {
        super(driver);
        header = new MagentoHeader(driver);
    }

    @Step("Open Magento Main page")
    public MainPage open() {
        driver.get(MAGENTO_MAIN_PAGE);
        return this;
    }
}
