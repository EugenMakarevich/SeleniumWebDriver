package com.coherentsolutions.aqa.web.makarevich.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WhishlistPage extends PageBase {
    @FindBy(css = ".products-grid .product-items .product-item")
    private List<WebElement> whishlistItem;

    protected WhishlistPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWhishlistEmpty() {
        return whishlistItem.isEmpty();
    }

    public void removeAllItemsFromWishlist() {
        if (!whishlistItem.isEmpty()) {

        }
    }
}
