package com.coherentsolutions.aqa.web.makarevich.pages.components;

import com.coherentsolutions.aqa.web.makarevich.pages.ProductItemPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Breadcrumbs extends ComponentBase {
    @FindBy(xpath = "//li[contains(@class, 'item category')][last()]/a")
    private WebElement categoryBtn;

    public Breadcrumbs(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to the category")
    public ProductItemPage goToCategory() {
        categoryBtn.click();
        return new ProductItemPage(driver);
    }
}
