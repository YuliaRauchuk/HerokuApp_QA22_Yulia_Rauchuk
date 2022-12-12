package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TyposTest {

    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void typosTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com");
        WebElement typos = driver.findElement(By.linkText("Typos"));
        typos.click();
        driver.navigate().refresh();
        Assert.assertEquals(typos.toString(), "Sometimes you'll see a typo, other times you won,t.");

        driver.quit();
    }
}
