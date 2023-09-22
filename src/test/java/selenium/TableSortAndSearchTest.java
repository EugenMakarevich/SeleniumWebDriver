package selenium;

import lombok.extern.slf4j.Slf4j;
import model.Employee;
import model.Employees;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.List;

import static constants.ByConstants.SHOW_ENTRIES_DROPDOWN;
import static constants.UrlConstants.TABLE_TEST_URL;

@Slf4j
public class TableSortAndSearchTest extends TestBase {

    public static final String optionToBeSelected = "10";
    public static final int age = 40;
    public static final double salary = 150000.0;

    @Test
    public void testTableSortAndSearch() {
        log.info("Open the URL: {}", TABLE_TEST_URL);
        driver().get(TABLE_TEST_URL);

        Select showEntriesDropdown = new Select(driver().findElement(SHOW_ENTRIES_DROPDOWN));
        String selectedOption = showEntriesDropdown.getFirstSelectedOption().getText();
        log.info("Set up the Show {} entries filter", optionToBeSelected);
        if (!selectedOption.equals(optionToBeSelected)) {
            showEntriesDropdown.selectByVisibleText(optionToBeSelected);
        }
        Assert.assertEquals(optionToBeSelected, showEntriesDropdown.getFirstSelectedOption().getText(), String.format("%s is not selected in Show entries dropdown", optionToBeSelected));

        log.info("Sort employees by following criteria: age > {} and salary <= {}", age, salary);
        List<Employee> sortedEmployeeList = new Employees(driver()).sortEmployees(age, salary);
        Assert.assertFalse(sortedEmployeeList.isEmpty(), "Sorted list is empty!");

        log.info("Print employees who have age > {} and salary <= {}", age, salary);
        for (Employee employee : sortedEmployeeList) {
            log.info(employee.toString());
        }
    }
}
