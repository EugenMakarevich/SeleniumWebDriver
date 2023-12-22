package com.coherentsolutions.aqa.web.makarevich.pages.components;

import com.coherentsolutions.aqa.web.makarevich.pages.CreateAccountPage;
import com.coherentsolutions.aqa.web.makarevich.pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MagentoHeader extends ComponentBase {
    @FindBy(css = "div.header ul.header li:last-of-type")
    private WebElement createAccountLink;
    @FindBy(css = "header span.logged-in")
    private WebElement greetWelcomeText;
    @FindBy(css = "div.header li.authorization-link")
    private WebElement signInLink;

    public MagentoHeader(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Create an Account link")
    public CreateAccountPage clickCreateAccountLink() {
        createAccountLink.click();
        return new CreateAccountPage(driver);
    }

    @Step("Click Sign In link")
    public LoginPage clickSignInLink() {
        signInLink.click();
        return new LoginPage(driver);
    }

    public boolean isGreetWelcomeTextDisplayed() {
        return greetWelcomeText.isDisplayed();
    }
}
