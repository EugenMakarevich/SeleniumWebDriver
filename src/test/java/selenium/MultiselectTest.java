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

import static constants.ByConstants.MULTISELECT;
import static constants.ByConstants.MULTISELECT_OPTION;
import static constants.TestConstants.MULTISELECT_TEST_URL;

@Slf4j
public class MultiselectTest extends TestBase {

    @Test
    public void testMultiselect() {
        log.info("Open the URL: {}", MULTISELECT_TEST_URL);
        driver().get(MULTISELECT_TEST_URL);

        WebElement multiSelect = driver().findElement(MULTISELECT);
        List<WebElement> options = multiSelect.findElements(MULTISELECT_OPTION);
        List<String> selectedOptions = new ArrayList<>();

        int optionsNum = 3;
        log.info("Select {} random options:", optionsNum);
        Random random = new Random();
        for (int i = 0; i < optionsNum; i++) {
            int randomIndex = random.nextInt(options.size());
            WebElement option = options.get(randomIndex);
            option.click();
            log.info("Option {}: {}", i, option.getText());
            selectedOptions.add(option.getText());
            options.remove(randomIndex);
        }

        log.info("Verify options are selected");
        for (String selectedOption : selectedOptions) {
            WebElement selectedElement = multiSelect.findElement(By.xpath(String.format("//option[text()='%s']", selectedOption)));
            Assert.assertTrue(selectedElement.isSelected(), String.format("%s is not selected.", selectedOption));
        }
    }
}
