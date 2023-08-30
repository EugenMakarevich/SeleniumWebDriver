package constants;

import org.openqa.selenium.By;

/**
 The purpose of the ByConstants class is to list all possible types of locators in Selenium WebDrive
 This is not applicable to the project
 */
public class ByConstants {
    public static final By BY_CLASSNAME = By.className("information");
    public static final By BY_CSS_SELECTOR = By.cssSelector("#fname");
    public static final By BY_ID = By.id("id");
    public static final By BY_NAME = By.name("newsletter");
    public static final By BY_LINK_TEXT = By.linkText("Selenium Official Page");
    public static final By BY_PARTIAL_LINK_TEXT = By.partialLinkText("Official Page");
    public static final By BY_TAG_NAME = By.tagName("a");
    public static final By BY_XPATH = By.xpath("//input[@value='f']");
}
