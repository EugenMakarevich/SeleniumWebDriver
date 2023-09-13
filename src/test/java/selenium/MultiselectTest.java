package selenium;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static constants.TestConstants.MULTISELECT_TEST_URL;

@Slf4j
public class MultiselectTest extends TestBase {

    @Test
    public void testMultiselect() {
        log.info("Navigate to the page " + MULTISELECT_TEST_URL);
        driver().get(MULTISELECT_TEST_URL);

        WebElement multiSelect = driver().findElement(By.id("multi-select"));
        List<WebElement> options = multiSelect.findElements(By.tagName("option"));

        List<String> selectedOptions = new ArrayList<>();

        log.info("Select 3 random options:");
        Random random = new Random();
        int optionsNum = 3;
        for (int i = 0; i < optionsNum; i++) {
            int randomIndex = random.nextInt(options.size());
            WebElement option = options.get(randomIndex);
            option.click();
            selectedOptions.add(option.getText());
            log.info("Option " + i + ": " + option.getText());
            options.remove(randomIndex);
        }

        // Verify that the selected options are selected
        for (String selectedOption : selectedOptions) {
            WebElement selectedElement = multiSelect.findElement(By.xpath("//option[text()='" + selectedOption + "']"));
            Assert.assertTrue(selectedElement.isSelected(), selectedOption + " is not selected.");
        }
    }
}
