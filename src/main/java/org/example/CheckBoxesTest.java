package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxesTest {
    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void checkBoxesTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com");
        WebElement CheckBoxes = driver.findElement(By.linkText("Checkboxes"));
        CheckBoxes.isDisplayed();
        CheckBoxes.click();
        List<WebElement> checkBoxes= driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertEquals(checkBoxes.size(),2);
        Assert.assertFalse(checkBoxes.get(0).isSelected());
        checkBoxes.get(0).click();
        Assert.assertTrue(checkBoxes.get(0).isSelected());
        Assert.assertTrue(checkBoxes.get(1).isSelected());
        checkBoxes.get(1).click();
        Assert.assertFalse(checkBoxes.get(1).isSelected());
        driver.quit();
    }
}