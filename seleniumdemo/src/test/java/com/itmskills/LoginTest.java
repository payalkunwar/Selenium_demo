package com.itmskills;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class LoginTest {
public static void main(String[] args) {
WebDriver driver = new ChromeDriver();
try {
driver.manage().window().maximize();
driver.get("https://www.saucedemo.com");
driver.findElement(By.id("user-name"))
.sendKeys("standard_user");
driver.findElement(By.id("password"))
.sendKeys("secret_sauce");
driver.findElement(By.id("login-button"))
.click();
WebDriverWait wait =
new WebDriverWait(driver,
Duration.ofSeconds(10));
WebElement titleElement =
wait.until(
ExpectedConditions
.visibilityOfElementLocated(
By.className("title")));
String title = titleElement.getText();
Assert.assertEquals(

title,
"Products",
"Login failed!");
System.out.println("Login Successful");
} finally {
driver.quit();
}
}
}