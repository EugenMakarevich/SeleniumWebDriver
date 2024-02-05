package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.MEDIUM_TIMEOUT;

public class ProductPage extends PageBase {
    @FindBy(css = ".swatch-option.text")
    private List<WebElement> sizeOptions;
    @FindBy(css = ".swatch-option.color")
    private List<WebElement> colorOptions;
    @FindBy(css = "h1.page-title")
    private WebElement productName;
    @FindBy(css = ".product-info-main .price")
    private WebElement productPrice;
    @FindBy(css = ".product-addto-links a.towishlist")
    private WebElement addProductToWishListLink;
    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartBtn;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, MEDIUM_TIMEOUT, Duration.ofMillis(200));
    }

    @Step("CLick on Add Product To WishList button")
    public MyWhishListPage addProductToWishList() {
        addProductToWishListLink.click();
        return new MyWhishListPage(driver);
    }

    @Step("Get Product data from the page")
    public Product getProductDataFromPage() {
        Product product = new Product();
        product.setName(getProductName());
        product.setPrice(getProductPrice());
        return product;
    }

    @Step("Choose random size and color and add product to the cart")
    public void addProductToCart() {
        chooseRandomSize();
        chooseRandomColor();
        clickOnAddToCartBtn();
    }

    @Step("Get product name")
    private String getProductName() {
        return productName.getText();
    }

    @Step("Get product price")
    private String getProductPrice() {
        return productPrice.getText();
    }

    @Step("Click on Add To Cart button")
    private void clickOnAddToCartBtn() {
        addToCartBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page .messages")));
    }

    @Step("Choose random size of the product")
    private void chooseRandomSize() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swatch-option.text")));
        WebElement randomSize = sizeOptions.get(new Random().nextInt(sizeOptions.size() - 1));
        randomSize.click();
    }

    @Step("Choose random color of the product")
    private void chooseRandomColor() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swatch-option.color")));
        WebElement randomColor = colorOptions.get(new Random().nextInt(colorOptions.size() - 1));
        randomColor.click();
    }
}
