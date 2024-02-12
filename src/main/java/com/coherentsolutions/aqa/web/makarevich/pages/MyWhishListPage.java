package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
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

    public List<Product> getProductDataFromAllPages() {
        //Time breaker
        long startTime = System.currentTimeMillis();
        long timeout = 30000;

        List<Product> products = new ArrayList<>();
        while (true) {
            products.addAll(getProductsFromPage());

            //Check if there's a next page and navigate to it
            if (!driver.findElements(By.cssSelector("a.next")).isEmpty()) {
                driver.findElement(By.cssSelector("a.next")).click();
            } else {
                break; //No more pages
            }

            // Check the timeout
            long currentTime = System.currentTimeMillis();
            if (currentTime - startTime > timeout) {
                // Timeout reached, break out of the loop
                System.out.println("Timeout reached. Exiting the loop.");
                break;
            }
        }
        return products;
    }

    //TODO: Put all this to the page
    public List<Product> getProductsFromPage() {
        List<WebElement> whishlistItems1 = whishlistItems;
        List<Product> products = new ArrayList<>();

        for (WebElement wishlistItem : whishlistItems1) {
            Product product = new Product();

            WebElement productName = wishlistItem.findElement(By.cssSelector(".products-grid .product-items .product-item a.product-item-link"));
            WebElement productPrice = wishlistItem.findElement(By.cssSelector(".products-grid .product-items .product-item .price"));

            product.setName(productName.getText());
            product.setPrice(productPrice.getText());

            products.add(product);
        }
        return products;
    }
}
