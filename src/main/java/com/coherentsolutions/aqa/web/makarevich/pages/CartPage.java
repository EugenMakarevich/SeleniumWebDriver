package com.coherentsolutions.aqa.web.makarevich.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class CartPage extends PageBase {
    @FindBy(className = "item-info")
    private List<WebElement> productList;

    public CartPage(WebDriver driver) {
        super(driver);
    }
}
