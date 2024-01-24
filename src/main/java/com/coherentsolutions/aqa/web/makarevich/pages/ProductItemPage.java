package com.coherentsolutions.aqa.web.makarevich.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

@Getter
public class ProductItemPage extends PageBase {
    @FindBy(css = "item product product-item")
    private List<WebElement> productItems;
    @FindBy(css = ".product a.product-item-link")
    private WebElement productName;
    @FindBy(css = ".product .price")
    private WebElement productPrice;
    @FindBy(css = ".product a.product-item-link")
    private List<WebElement> productLinks;

    public ProductItemPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getRandomProductLinkFromPage() {
        int index = new Random().nextInt(productLinks.size());
        return productLinks.get(index);
    }

    public ProductPage goToRandomProductPage() {
        getRandomProductLinkFromPage().click();
        return new ProductPage(driver);
    }
}
