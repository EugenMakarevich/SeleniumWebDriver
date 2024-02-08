package com.coherentsolutions.aqa.web.makarevich.services;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.MEDIUM_TIMEOUT;

public class ProductService {
    //TODO: delete products
    private List<Product> products = new ArrayList<>();

    protected WebDriver driver;

    public ProductService(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<Product> getProductDataFromAllPages() {
        //TODO: Time broker
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

    //TODO: Put all this to the page
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

    public Product getProduct() {
        WebDriverWait wait = new WebDriverWait(driver, MEDIUM_TIMEOUT, Duration.ofMillis(200));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-info-main .price")));
        Product product = new Product();
        WebElement productName = driver.findElement(By.cssSelector(".product-info-main h1"));
        WebElement productPrice = driver.findElement(By.cssSelector(".product-info-main .price"));
        product.setName(productName.getText());
        product.setPrice(productPrice.getText());
        return product;
    }

    public boolean isProductAddedToCart(List<Product> productsAdded, List<Product> productsInCart) {
        for (Product productAdded : productsAdded) {
            if (!productsInCart.contains(productAdded)) {
                return false; // Product not found in cart
            }
        }
        return true; // All products are found in cart
    }

    //TODO: Change to @FindBy
    private List<WebElement> getProductItems() {
        return driver.findElements(By.cssSelector(".products-grid .product-items .product-item"));
    }
}