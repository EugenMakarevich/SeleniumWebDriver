package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductPage extends PageBase {
    @FindBy(css = ".swatch-option.text")
    private List<WebElement> sizeOptions;
    @FindBy(css = ".swatch-option.color")
    private List<WebElement> colorOptions;
    @FindBy(className = "towishlist")
    private WebElement toWishlistBtn;
    @FindBy(css = "h1.page-title")
    private WebElement productName;
    @FindBy(css = ".product-info-main .price")
    private WebElement productPrice;
    @FindBy(css = ".product-addto-links a.towishlist")
    private WebElement addProductToWishListLink;
    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartBtn;
    @FindBy(xpath = "//li[contains(@class, 'item category')][last()]/a")
    private WebElement categoryBtn;

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

    public void addProductToCart() {
        chooseRandomSize();
        chooseRandomColor();
        addToCartBtn.click();
    }

    public void chooseRandomSize() {
        WebElement randomSize = sizeOptions.get(new Random().nextInt(sizeOptions.size() - 1));
        randomSize.click();
    }

    public void chooseRandomColor() {
        WebElement randomColor = colorOptions.get(new Random().nextInt(colorOptions.size() - 1));
        randomColor.click();
    }

    public ProductItemPage goToCategory() {
        categoryBtn.click();
        return new ProductItemPage(driver);
    }
}
