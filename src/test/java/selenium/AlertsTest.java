package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

import static constants.ByConstants.ALERT_BOX_BUTTON;
import static constants.ByConstants.CONFIRM_BOX_BUTTON;
import static constants.TestConstants.ALERTS_TEST_URL;

public class AlertsTest extends TestBase {
    @Test(priority = 1)
    public void testJavaScriptAlertBox() {
        // Open the URL
        driver().get(ALERTS_TEST_URL);

        // Click the "Click me!" button for the JavaScript Alert Box
        driver().findElement(ALERT_BOX_BUTTON).click();

        // Switch to the alert
        Alert alert = driver().switchTo().alert();

        // Get the alert text
        String alertText = alert.getText();

        // Verify the alert text
        Assert.assertEquals(alertText, "I am an alert box!");

        // Close the alert
        alert.accept();
    }

    @Test(priority = 2)
    public void testJavaScriptConfirmBoxAccept() {
        // Open the URL
        driver().get(ALERTS_TEST_URL);

        // Click the "Click for Confirm Box" button for the JavaScript Confirm Box
        driver().findElement(CONFIRM_BOX_BUTTON).click();

        // Switch to the alert
        Alert alert = driver().switchTo().alert();

        // Accept the alert (Click OK)
        alert.accept();

        // Verify the result text
        WebElement resultElement = driver().findElement(By.id("confirm-demo"));
        String resultText = resultElement.getText();

        Assert.assertEquals(resultText, "You pressed OK!");
    }

    @Test(priority = 3)
    public void testJavaScriptConfirmBoxDismiss() {
        // Open the URL
        driver().get(ALERTS_TEST_URL);

        // Click the "Click for Confirm Box" button for the JavaScript Confirm Box
        driver().findElement(CONFIRM_BOX_BUTTON).click();

        // Switch to the alert
        Alert alert = driver().switchTo().alert();

        // Dismiss the alert (Click Cancel)
        alert.dismiss();

        // Verify the result text
        WebElement resultElement = driver().findElement(By.id("confirm-demo"));
        String resultText = resultElement.getText();

        Assert.assertEquals(resultText, "You pressed Cancel!");
    }
}
