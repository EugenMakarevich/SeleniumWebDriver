package com.coherentsolutions.aqa.web.makarevich.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageNavigation extends ComponentBase {
    //TODO: Page Factory
    public PageNavigation(WebDriver driver) {
        super(driver);
    }


    public void goToPreviousPage() {
        if (!driver.findElements(By.className("previous")).isEmpty()) {
            driver.findElement(By.className("previous")).click();
        }
    }

    public void goToNextPage() {
        if (!driver.findElements(By.cssSelector("a.next")).isEmpty()) {
            driver.findElement(By.cssSelector("a.next")).click();
        }
    }

    public void goToFirstPage() {
        do {
            goToPreviousPage();
        } while (!driver.findElements(By.className("previous")).isEmpty());
    }

    public void goToLastPage() {
        do {
            goToNextPage();
        } while (!driver.findElements(By.cssSelector("a.next")).isEmpty());
    }
}
