package com.coherentsolutions.aqa.web.makarevich.services;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import com.coherentsolutions.aqa.web.makarevich.pages.ProductItemPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    // ToDo: get rid of all FindBy annotations,
    // just move it to an appropriate page
    // Put here only stuff that are related to work with Product object

    private List<Product> products = new ArrayList<>();

    protected WebDriver driver;

    public ProductService(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getProductsFromPage() {
        List<WebElement> productItems = new ProductItemPage(driver).getProductItems();

        for (WebElement productItem : productItems) {
            Product product = new Product();

            WebElement productName = productItem.findElement(By.cssSelector(".product a.product-item-link"));
            WebElement productPrice = productItem.findElement(By.cssSelector(".product .price"));

            product.setName(productName.getText());
            product.setPrice(productPrice.getText());

            products.add(product);
        }
    }
}