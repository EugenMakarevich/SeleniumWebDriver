package com.coherentsolutions.aqa.java.web.makarevich;

import lombok.extern.slf4j.Slf4j;
import com.coherentsolutions.aqa.web.makarevich.model.Employee;
import com.coherentsolutions.aqa.web.makarevich.services.EmployeeService;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.coherentsolutions.aqa.web.makarevich.constants.ByConstants.SHOW_ENTRIES_DROPDOWN;
import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.TABLE_TEST_URL;

@Slf4j
public class TableSortAndSearchTest extends TestBase {
    public static final String OPTION_TO_BE_SELECTED = "10";
    public static final int AGE = 40;
    public static final double SALARY = 150000.0;

    @Test
    public void testTableSortAndSearch() {
        log.info("Open the URL: {}", TABLE_TEST_URL);
        driver().get(TABLE_TEST_URL);

        Select showEntriesDropdown = new Select(driver().findElement(SHOW_ENTRIES_DROPDOWN));
        String selectedOption = showEntriesDropdown.getFirstSelectedOption().getText();
        log.info("Set up the Show {} entries filter", OPTION_TO_BE_SELECTED);
        if (!selectedOption.equals(OPTION_TO_BE_SELECTED)) {
            showEntriesDropdown.selectByVisibleText(OPTION_TO_BE_SELECTED);
        }
        selectedOption = showEntriesDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(OPTION_TO_BE_SELECTED, selectedOption, String.format("%s is not selected in Show entries dropdown", OPTION_TO_BE_SELECTED));

        log.info("Sort employees by following criteria: age > {} and salary <= {}", AGE, SALARY);
        List<Employee> sortedEmployeeList = new EmployeeService(driver()).sortEmployees(AGE, SALARY);

        Assert.assertFalse(sortedEmployeeList.isEmpty(), "Sorted employee list is empty!");
    }
}
