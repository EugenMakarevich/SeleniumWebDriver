package constants;

import org.openqa.selenium.By;

/**
 The purpose of the class is to list all possible types of locators in Selenium WebDriver
 AND to list the By locators related to the project
 */
public class ByConstants {

    //Sample locators
    public static final By CLASSNAME_SELECTOR = By.className("information");
    public static final By CSS_SELECTOR = By.cssSelector("#fname");
    public static final By ID_SELECTOR = By.id("id");
    public static final By NAME_SELECTOR = By.name("newsletter");
    public static final By LINK_TEXT_SELECTOR = By.linkText("Selenium Official Page");
    public static final By PARTIAL_LINK_TEXT_SELECTOR = By.partialLinkText("Official Page");
    public static final By TAG_NAME_SELECTOR = By.tagName("a");
    public static final By XPATH_SELECTOR = By.xpath("//input[@value='f']");

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
}
