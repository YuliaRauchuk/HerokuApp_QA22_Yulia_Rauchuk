package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class NotificationMessagesTest {

    WebDriver driver;
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void notificationMessageTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");

        driver.findElement(By.cssSelector(".example a")).click();
        String message = driver.findElement(By.cssSelector(".flash")).getText();
        Assert.assertEquals(message, "Action unsuccesful, please try again\n" + "×");

        driver.quit();
    }
}