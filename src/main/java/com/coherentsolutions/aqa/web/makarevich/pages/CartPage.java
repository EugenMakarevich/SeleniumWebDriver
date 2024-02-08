package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.MEDIUM_TIMEOUT;
import static com.coherentsolutions.aqa.web.makarevich.utils.ExtractMoneyUtils.extractDouble;

@Getter
public class CartPage extends PageBase {
    @FindBy(className = "item-info")
    private List<WebElement> productList;
    @FindBy(className = "action-delete")
    private List<WebElement> removeButtons;
    @FindBy(css = ".input-text.qty")
    private List<WebElement> productQuantities;
    @FindBy(css = ".subtotal .cart-price .price")
    private List<WebElement> productSubtotals;
    @FindBy(css = ".sub .price")
    private WebElement cartSubtotal;
    @FindBy(css = ".grand .price")
    private WebElement cartOrderTotal;
    private List<Product> products = new ArrayList<>();

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get products from all cart pages")
    public List<Product> getProductsFromAllPages() {
        do {
            getProductsFromPage();
            getPageNavigation().goToNextPage();

            // Check if there's a next page
        } while (!driver.findElements(By.cssSelector("a.next")).isEmpty());
        return products;
    }

    public double getAllSubtotals(List<Product> products) {
        double cartItemSubtotals = 0;
        for (Product product : products) {
            cartItemSubtotals += product.getSubtotal();
        }
        return cartItemSubtotals;
    }

    @Step("Verify the cart subtotal is valid")
    public boolean isCartSubtotalValid(List<Product> products) {
        WebDriverWait wait = new WebDriverWait(driver, MEDIUM_TIMEOUT, Duration.ofMillis(200));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sub .price")));
        double expectedSubtotal = extractDouble(cartSubtotal.getText());
        double actualSubtotal = getAllSubtotals(products);
        return actualSubtotal == expectedSubtotal;
    }

    @Step("Get product from the cart")
    private Product getProduct(WebElement productItem) {
        Product product = new Product();
        WebElement productName = productItem.findElement(By.cssSelector(".product-item-name a"));
        WebElement productPrice = productItem.findElement(By.cssSelector(".item-info .price .price-excluding-tax"));
        WebElement productQty = productItem.findElement(By.cssSelector(".input-text.qty"));
        WebElement productSubtotal = productItem.findElement(By.cssSelector(".subtotal .cart-price .price"));
        product.setName(productName.getText());
        product.setPrice(productPrice.getText());
        product.setQty(Integer.parseInt(productQty.getAttribute("value")));
        product.setSubtotal(extractDouble(productSubtotal.getText()));
        return product;
    }

    @Step("Get products from the cart page")
    private List<Product> getProductsFromPage() {
        for (WebElement productItem : productList) {
            products.add(getProduct(productItem));
        }
        return products;
    }
}
