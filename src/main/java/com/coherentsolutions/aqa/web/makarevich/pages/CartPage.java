package com.coherentsolutions.aqa.web.makarevich.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get product quantity")
    private int getPrdQuantity() {
        int initialQuantity = 0;
        for (WebElement productQuantity : productQuantities) {
            int quantity = Integer.parseInt(productQuantity.getAttribute("value"));
            initialQuantity += quantity;
        }
        return initialQuantity;
    }

    @Step("Get product quantity from all pages")
    public int getPrdQuantityFromAllPages() {
        int prdQuantity = 0;
        while (true) {
            prdQuantity += getPrdQuantity();

            //Check if there's a next page and navigate to it
            if (!driver.findElements(By.cssSelector("a.next")).isEmpty()) {
                driver.findElement(By.cssSelector("a.next")).click();
            } else {
                break; //No more pages
            }
        }

        //Go back to the firs page
        while (true) {
            if (!driver.findElements(By.className("previous")).isEmpty()) {
                driver.findElement(By.className("previous")).click();
            } else {
                break;
            }
        }
        return prdQuantity;
    }

    @Step("Get product quantity from page")
    private double getPrdSubtotalFromPage() {
        double prdSubtotal = 0;
        for (WebElement productSubtotal : productSubtotals) {
            double subtotal = extractDouble(productSubtotal.getText());
            prdSubtotal += subtotal;
        }
        return prdSubtotal;
    }

    @Step("Get product quantity from all pages")
    public double getPrdSubtotalFromAllPages() {
        double prdSubtotal = 0;
        while (true) {
            prdSubtotal += getPrdSubtotalFromPage();

            //Check if there's a next page and navigate to it
            if (!driver.findElements(By.cssSelector("a.next")).isEmpty()) {
                driver.findElement(By.cssSelector("a.next")).click();
            } else {
                break; //No more pages
            }
        }

        //Go back to the firs page
        while (true) {
            if (!driver.findElements(By.className("previous")).isEmpty()) {
                driver.findElement(By.className("previous")).click();
            } else {
                break;
            }
        }
        return prdSubtotal;
    }

    @Step("Verify the cart subtotal is valid")
    public boolean isCartSubtotalValid() {
        WebDriverWait wait = new WebDriverWait(driver, MEDIUM_TIMEOUT, Duration.ofMillis(200));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sub .price")));
        double expectedSubtotal = extractDouble(cartSubtotal.getText());
        double actualSubtotal = getPrdSubtotalFromAllPages();
        return actualSubtotal == expectedSubtotal;
    }
}
