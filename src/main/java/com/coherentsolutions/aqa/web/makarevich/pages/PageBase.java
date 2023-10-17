package com.coherentsolutions.aqa.web.makarevich.pages;

import org.openqa.selenium.WebDriver;

public abstract class PageBase {
    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }
}
