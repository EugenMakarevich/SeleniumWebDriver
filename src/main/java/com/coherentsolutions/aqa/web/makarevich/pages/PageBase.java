package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.pages.components.Breadcrumbs;
import com.coherentsolutions.aqa.web.makarevich.pages.components.Header;
import com.coherentsolutions.aqa.web.makarevich.pages.components.PageNavigation;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
public abstract class PageBase {
    protected WebDriver driver;
    private Header header;
    private Breadcrumbs breadcrumbs;
    private PageNavigation pageNavigation;

    protected PageBase(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        breadcrumbs = new Breadcrumbs(driver);
        pageNavigation = new PageNavigation(driver);
        PageFactory.initElements(driver, this);
    }
}
