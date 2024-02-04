package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.model.Product;
import com.coherentsolutions.aqa.web.makarevich.services.ProductService;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Step("Click on random product and navigate to product page")
    public ProductPage goToRandomProductPage() {
        getRandomProductLinkFromPage().click();
        return new ProductPage(driver);
    }

    @Step("Add specified number of products ({0}) to the cart")
    public List<Product> addProductToCard(int prodNum) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < prodNum; i++) {
            WebElement productLink = getRandomProductLinkFromPage();
            productLink.click();
            //TODO: Should I add the page to PageBase to prevent initialization here?
            ProductPage productPage = new ProductPage(driver);
            ProductService productService = new ProductService(driver);
            products.add(productService.getProduct());
            productPage.addProductToCart();
            getBreadcrumbs().goToCategory();
            productLinks.remove(productLink);
        }
        return products;
    }

    @Step("Get random product link")
    private WebElement getRandomProductLinkFromPage() {
        int index = new Random().nextInt(productLinks.size());
        return productLinks.get(index);
    }
}
