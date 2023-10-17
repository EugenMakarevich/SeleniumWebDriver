package com.coherentsolutions.aqa.web.makarevich.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexMailInboxPage extends PageBase {
    private By username = By.cssSelector("a.user-account_left-name > span.user-account__name");
    private By avatarImg = By.cssSelector("a.i-bem .user-account__pic .user-pic__image");

    public YandexMailInboxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUsernameDisplayed() {
        return driver.findElement(username).isDisplayed();
    }

    public boolean isAvatarImgDisplayed() {
        return driver.findElement(avatarImg).isDisplayed();
    }

    public String getUsername() {
        return driver.findElement(username).getText();
    }
}
