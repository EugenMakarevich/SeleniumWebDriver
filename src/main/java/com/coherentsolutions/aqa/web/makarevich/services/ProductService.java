package com.coherentsolutions.aqa.web.makarevich.services;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductService {
    protected WebDriver driver;

    public ProductService(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public boolean isProductAddedToCart(List<Product> productsAdded, List<Product> productsInCart) {
        for (Product productAdded : productsAdded) {
            if (!productsInCart.contains(productAdded)) {
                return false; // Product not found in cart
            }
        }
        return true; // All products are found in cart
    }


}