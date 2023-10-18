package com.coherentsolutions.aqa.web.makarevich.pages;

import org.openqa.selenium.WebDriver;

public abstract class PageBase {
    protected WebDriver driver;

    protected PageBase(WebDriver driver) {
        this.driver = driver;
    }
}
