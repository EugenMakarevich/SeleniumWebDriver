package com.coherentsolutions.aqa.web.makarevich.pages.components;

import com.coherentsolutions.aqa.web.makarevich.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends PageBase {
    private By accountImg = By.cssSelector("a.user-account .user-pic .user-pic__image");
    private By logoutLink = By.cssSelector(".menu__group .menu__list-item:last-child");
    private By accountName = By.cssSelector("a.user-account_left-name > span.user-account__name");

    public Header(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountNameDisplayed() {
        return driver.findElement(accountName).isDisplayed();
    }

    public boolean isAccountImgDisplayed() {
        return driver.findElement(accountImg).isDisplayed();
    }

    public String getAccountName() {
        return driver.findElement(accountName).getText();
    }

    public Header clickAccountImg() {
        driver.findElement(accountImg).click();
        return this;
    }

    public Header clickLogoutLink() {
        driver.findElement(logoutLink).click();
        return this;
    }
}
