package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.pages.components.MagentoHeader;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends MainPage {
    MagentoHeader header;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        header = new MagentoHeader(driver);
    }
}
