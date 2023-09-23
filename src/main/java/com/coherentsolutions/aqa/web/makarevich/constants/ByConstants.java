package com.coherentsolutions.aqa.web.makarevich.constants;

import org.openqa.selenium.By;

/**
 List of By constants
 */
public class ByConstants {
    //Yandex Mail Constants
    public static final By LOGIN_BUTTON_MAIN_PAGE = By.id("header-login-button");
    public static final By EMAIL_FIELD = By.id("passp-field-login");
    public static final By LOGIN_BUTTON_AUTHORIZATION_PAGE = By.id("passp:sign-in");
    public static final By PASSWORD_FIELD = By.id("passp-field-passwd");
    public static final By USER_ACCOUNT_NAME = By.cssSelector("a.user-account_left-name > span.user-account__name");

    //Multiselect locators
    public static final By MULTISELECT = By.id("multi-select");
    public static final By MULTISELECT_OPTION = By.tagName("option");

    //Alerts locators
    public static final By ALERT_BOX_BUTTON = By.xpath("//button[text()='Click me!']");
    public static final By CONFIRM_BOX_BUTTON = By.xpath("//button[contains(@class, 'btn-lg') and text()='Click me!']");
    public static final By CONFIRM_BOX_RESULT = By.id("confirm-demo");

    //Loading the data Dynamically locators
    public static final By GET_NEW_USER_BUTTON = By.id("save");
    public static final By USER_INFORMATION_BOX = By.id("loading");
    public static final By USER_PHOTO = By.tagName("img");

    //Progress Bar Test locators
    public static final By DOWNLOAD_BUTTON = By.id("cricle-btn");
    public static final By PERCENT_TEXT = By.className("percenttext");

    //Table Sort And Search Demo locators
    public static final By SHOW_ENTRIES_DROPDOWN = By.name("example_length");
    public static final By NEXT_PAGE_BUTTON = By.id("example_next");
}
