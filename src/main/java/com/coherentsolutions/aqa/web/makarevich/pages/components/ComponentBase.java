package com.coherentsolutions.aqa.web.makarevich.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class ComponentBase {
    WebDriver driver;

    ComponentBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
