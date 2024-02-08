package com.coherentsolutions.aqa.web.makarevich.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyWhishListPage extends PageBase {
    @FindBy(css = ".wishlist .product-items .product-item")
    private List<WebElement> whishlistItems;

    public MyWhishListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWhishlistEmpty() {
        return whishlistItems.isEmpty();
    }
}
