package com.coherentsolutions.aqa.web.makarevich.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.SHORT_TIMEOUT;

@Getter
public class ProductItemPage extends PageBase {
    @FindBy(css = ".item product .product-item")
    private List<WebElement> productItems;
    @FindBy(css = ".product a.product-item-link")
    private WebElement productName;
    @FindBy(css = ".product .price")
    private WebElement productPrice;
    @FindBy(css = ".products-grid .product-items .product-item .tocart")
    private WebElement addToCardButton;
    @FindBy(css = ".product a.product-item-link")
    private List<WebElement> productLinks;

    public ProductItemPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage goToRandomProductPage() {
        getRandomProductLinkFromPage().click();
        return new ProductPage(driver);
    }

    public ProductItemPage addProductToCard(int prodNum) {
        for (int i = 0; i < prodNum; i++) {
            WebElement productLink = getRandomProductLinkFromPage();
            productLink.click();
            ProductPage productPage = new ProductPage(driver);
            productPage.addProductToCart();
            productPage.goToCategory();
            productLinks.remove(productLink);
        }
        return new ProductItemPage(driver);
    }

    private WebElement getRandomProductLinkFromPage() {
        int index = new Random().nextInt(productLinks.size());
        return productLinks.get(index);
    }

    private void hoverOnProduct(WebElement productLink) {
        Actions actions = new Actions(driver);
        actions.moveToElement(productLink).perform();
        WebDriverWait wait = new WebDriverWait(driver, SHORT_TIMEOUT, Duration.ofMillis(800));
        //wait.until(ExpectedConditions.visibilityOf(addToCardButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".products-grid .product-items .product-item .tocart")));
    }

    private void clickOnCardIcon() {
        addToCardButton.click();
    }
}
