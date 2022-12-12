package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SortableDataTablesTest {

    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void sortableDataTablesTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com");
        WebElement sortableDataTables= driver.findElement(By.linkText("Sortable Data Tables"));
        sortableDataTables.click();

        WebElement field1 = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        field1.isDisplayed();
        Assert.assertEquals(field1.getText(), "Smith");

        WebElement field2 = driver.findElement(By.xpath("//table//tr[2]//td[5]"));
        Assert.assertEquals(field2.getText(), "http://www.frank.com");

        WebElement field3 = driver.findElement(By.xpath("//table//tr[4]//td[3]"));
        Assert.assertEquals(field3.getText(), "tconway@earthlink.net");

        driver.quit();

    }
}