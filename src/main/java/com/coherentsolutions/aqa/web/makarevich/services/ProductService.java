package com.coherentsolutions.aqa.web.makarevich.services;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductService {
    @FindBy(css = "item product product-item")
    private List<WebElement> productItems;
    @FindBy(css = ".product a.product-item-link")
    private WebElement productName;
    @FindBy(css = ".product .price")
    private WebElement productPrice;
    @FindBy(css = ".product a.product-item-link")
    private List<WebElement> productLinks;
    private List<Product> products = new ArrayList<>();

    protected WebDriver driver;

    public ProductService(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getProductsFromPage() {
        for (WebElement productItem : productItems) {
            Product product = new Product();

            WebElement productName = productItem.findElement(By.cssSelector(".product a.product-item-link"));
            WebElement productPrice = productItem.findElement(By.cssSelector(".product .price"));

            product.setName(productName.getText());
            product.setPrice(productPrice.getText());

            products.add(product);
        }
    }

    private WebElement getRandomProductLinkFromPage() {
        int index = new Random().nextInt(productLinks.size());
        return productLinks.get(index);
    }

    public void goToRandomProductPage() {
        getRandomProductLinkFromPage().click();
    }
}