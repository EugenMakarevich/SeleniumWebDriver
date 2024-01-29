package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends PageBase {
    @FindBy(css = ".products-grid .product-item")
    private List<WebElement> productItems;
    @FindBy(css = "h1.page-title")
    private WebElement productName;
    @FindBy(css = ".product-info-main .price")
    private WebElement productPrice;
    @FindBy(css = ".product-addto-links a.towishlist")
    private WebElement addProductToWishListLink;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get product name")
    public String getProductName() {
        return productName.getText();
    }

    @Step("Get product price")
    public String getProductPrice() {
        return productPrice.getText();
    }

    @Step("Add Product to Wish List")
    public MyWhishListPage clickOnAddProductToWishListLink() {
        addProductToWishListLink.click();
        return new MyWhishListPage(driver);
    }

    public Product getProductDataFromPage() {
        Product product = new Product();

        product.setName(productName.getText());
        product.setPrice(productPrice.getText());

        return product;
    }
}
