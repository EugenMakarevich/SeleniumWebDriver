package selenium;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.ArrayList;
import java.util.List;

import static constants.ByConstants.NEXT_PAGE_BUTTON;
import static constants.ByConstants.SHOW_ENTRIES_DROPDOWN;
import static constants.TestConstants.TABLE_TEST_URL;

@Slf4j
public class TableSortAndSearchTest extends TestBase {

    @Test
    public void TestTableSortAndSearch() {
        log.info("Open the URL: {}", TABLE_TEST_URL);
        driver().get(TABLE_TEST_URL);

        Select showEntriesDropdown = new Select(driver().findElement(SHOW_ENTRIES_DROPDOWN));
        String optionToBeSelected = "10";
        String selectedOption = showEntriesDropdown.getFirstSelectedOption().getText();
        log.info("Set up the Show {} entries filter", optionToBeSelected);
        if (!selectedOption.equals(optionToBeSelected)) {
            showEntriesDropdown.selectByVisibleText(optionToBeSelected);
        }
        Assert.assertEquals(optionToBeSelected, showEntriesDropdown.getFirstSelectedOption().getText(), String.format("%s is not selected.", optionToBeSelected));

        int age = 40;
        double salary = 150000.0;
        log.info("Sort employees by following criteria: age > {} and salary <= {}", age, salary);
        List<Employee> sortedList = new Employee().sortEmployees(age, salary);
        Assert.assertFalse(sortedList.isEmpty(), "Sorted list is empty!");

        log.info("Print employees who have age > {} and salary <= {}", age, salary);
        for (Employee employee : sortedList) {
            System.out.println(employee.toString());
        }
    }

    public class Employee {
        private String name;
        private String position;
        private String office;
        private int age;
        private String start_date;
        private double salary;
        private List<Employee> employees = new ArrayList<>();

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getOffice() {
            return office;
        }

        public void setOffice(String office) {
            this.office = office;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getStart_date() {
            return start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void getEmployeeDataFromPage() {
            WebElement employeeTable = driver().findElement(By.id("example"));
            List<WebElement> rows = employeeTable.findElements(By.cssSelector("tbody > tr"));

            for (WebElement row : rows) {
                Employee employee = new Employee();

                List<WebElement> cols = row.findElements(By.cssSelector("td"));

                employee.setName(cols.get(0).getText());
                employee.setPosition(cols.get(1).getText());
                employee.setOffice(cols.get(2).getText());
                employee.setAge(Integer.parseInt(cols.get(3).getText()));
                employee.setStart_date(cols.get(4).getText());
                employee.setSalary(Integer.parseInt(cols.get(5).getText().replaceAll("[^0-9]", "")));

                employees.add(employee);
            }
        }

        public void getEmployeeDataFromAllPages() {
            while(true) {
                getEmployeeDataFromPage();

                //Check if there's a next page and navigate to it
                WebElement nextButton = driver().findElement(NEXT_PAGE_BUTTON);
                if (nextButton.getAttribute("class").contains("disabled")) {
                    break; //No more pages
                } else {
                    nextButton.click();
                }
            }
        }

        public List<Employee> sortEmployees(int age, double salary) {
            getEmployeeDataFromAllPages();

            List<Employee> sortedList = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getAge() > age & employee.getSalary() <= salary) {
                    sortedList.add(employee);
                }
            }
            return sortedList;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", office='" + office + '\'' +
                    ", age=" + age +
                    ", start_date='" + start_date + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
