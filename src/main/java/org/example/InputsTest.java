package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class InputsTest {
    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void inputsTest () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("10");
        input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(input.getAttribute("value"), "11");

        input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(input.getAttribute("value"), "10");

        input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(input.getAttribute("value"), "9");

        input.clear();

        input.sendKeys("1");
        input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(input.getAttribute("value"), "2");
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(input.getAttribute("value"), "-1");

        input.clear();

        input.sendKeys("--40");
        input.sendKeys(Keys.ARROW_UP);
        input.sendKeys(Keys.ARROW_UP);
        input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(input.getAttribute("value"), "3");

        input.clear();

        input.sendKeys("sun");
        Assert.assertEquals(input.getAttribute("value"), "");
        driver.quit();

    }
}