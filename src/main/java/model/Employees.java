package model;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Employees {
    private WebDriver driver;
    private List<Employee> employees = new ArrayList<>();

    public Employees(WebDriver driver) {
        this.driver = driver;
    }

    public void getEmployeeDataFromPage() {
        WebElement employeeTable = driver.findElement(By.id("example"));
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
        while (true) {
            getEmployeeDataFromPage();

            //Check if there's a next page and navigate to it
            WebElement nextButton = driver.findElement(By.id("example_next"));
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
}
