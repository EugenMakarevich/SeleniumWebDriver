package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.pages.components.Breadcrumbs;
import com.coherentsolutions.aqa.web.makarevich.pages.components.MagentoHeader;
import com.coherentsolutions.aqa.web.makarevich.pages.components.PageNavigation;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
public abstract class PageBase {
    protected WebDriver driver;
    private MagentoHeader header;
    private Breadcrumbs breadcrumbs;
    private PageNavigation pageNavigation;

    protected PageBase(WebDriver driver) {
        this.driver = driver;
        header = new MagentoHeader(driver);
        breadcrumbs = new Breadcrumbs(driver);
        pageNavigation = new PageNavigation(driver);
        PageFactory.initElements(driver, this);
    }
}
