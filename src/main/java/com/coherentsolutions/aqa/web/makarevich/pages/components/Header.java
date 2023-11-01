package com.coherentsolutions.aqa.web.makarevich.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends ComponentBase {
    @FindBy(css = "a.user-account .user-pic .user-pic__image")
    private WebElement accountImg;
    @FindBy(css = ".menu__group .menu__list-item:last-child")
    private WebElement logoutLink;
    @FindBy(css = "a.user-account_left-name > span.user-account__name")
    private WebElement accountName;

    public Header(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountNameDisplayed() {
        return accountName.isDisplayed();
    }

    public boolean isAccountImgDisplayed() {
        return accountImg.isDisplayed();
    }

    public String getAccountName() {
        return accountName.getText();
    }

    public Header clickAccountImg() {
        accountImg.click();
        return this;
    }

    public Header clickLogoutLink() {
        logoutLink.click();
        return this;
    }
}
