package com.coherentsolutions.aqa.web.makarevich.services;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    protected WebDriver driver;

    public ProductService(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<Product> getProductDataFromAllPages() {
        while (true) {
            getProductsFromPage();

            //Check if there's a next page and navigate to it
            if (!driver.findElements(By.cssSelector("a.next")).isEmpty()) {
                driver.findElement(By.cssSelector("a.next")).click();
            } else {
                break; //No more pages
            }
        }
        return products;
    }

    public void getProductsFromPage() {
        List<WebElement> productItems = getProductItems();

        for (WebElement productItem : productItems) {
            Product product = new Product();

            WebElement productName = productItem.findElement(By.cssSelector(".products-grid .product-items .product-item a.product-item-link"));
            WebElement productPrice = productItem.findElement(By.cssSelector(".products-grid .product-items .product-item .price"));

            product.setName(productName.getText());
            product.setPrice(productPrice.getText());

            products.add(product);
        }
    }

    private List<WebElement> getProductItems() {
        return driver.findElements(By.cssSelector(".products-grid .product-items .product-item"));
    }
}