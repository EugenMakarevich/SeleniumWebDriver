package com.coherentsolutions.aqa.web.makarevich.pages.components;

import com.coherentsolutions.aqa.web.makarevich.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends PageBase {
    private By ACCOUNT_IMG = By.cssSelector("a.user-account .user-pic .user-pic__image");
    private By LOGOUT_LINK = By.cssSelector(".menu__group .menu__list-item:last-child");

    public Header(WebDriver driver) {
        super(driver);
    }

    public Header clickAccountImg() {
        driver.findElement(ACCOUNT_IMG).click();
        return this;
    }

    public Header clickLogoutLink() {
        driver.findElement(LOGOUT_LINK).click();
        return this;
    }
}
