package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class AddElements {
    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void AddElementTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com");
        WebElement AddRemoveElements= driver.findElement(By.linkText("Add/Remove Elements"));
        AddRemoveElements.click();
        WebElement AddElement1= driver.findElement(By.xpath("//button[text()='Add Element']"));
        WebElement AddElement2= driver.findElement(By.xpath("//button[text()='Add Element']"));
        AddElement1.click();
        AddElement2.click();
        WebElement Delete=driver.findElement(By.xpath("//button[text()='Delete']"));
        Delete.isDisplayed();
        Delete.click();
    }
}