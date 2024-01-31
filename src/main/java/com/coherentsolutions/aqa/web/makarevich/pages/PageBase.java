package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.pages.components.MagentoHeader;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
public abstract class PageBase {
    protected WebDriver driver;
    private MagentoHeader header;

    protected PageBase(WebDriver driver) {
        this.driver = driver;
        header = new MagentoHeader(driver);
        PageFactory.initElements(driver, this);
    }
}
