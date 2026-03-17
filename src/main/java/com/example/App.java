package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.WindowType;

public class App {

    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-gpu");

            driver = new FirefoxDriver(options);

            // ==============================
            // 🔹 TAB 1: SauceDemo Login
            // ==============================
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            Thread.sleep(2000);

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            Thread.sleep(1000);

            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            Thread.sleep(1000);

            driver.findElement(By.id("login-button")).click();
            Thread.sleep(3000);

            System.out.println("✅ SauceDemo login done");

            // ==============================
            // 🔹 TAB 2: AutomationExercise
            // ==============================
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://automationexercise.com/");
            Thread.sleep(5000);

            try {
                driver.findElement(By.cssSelector(".grippy-host")).click();
            } catch (Exception e) {
                System.out.println("Ad popup not found");
            }

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();
            Thread.sleep(4000);

            driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

            System.out.println("✅ Product added to cart");

            // ==============================
            // 🔹 TAB 3: Practice Test Login
            // ==============================
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://practicetestautomation.com/practice-test-login/");

            Thread.sleep(2000);

            driver.findElement(By.id("username")).sendKeys("student");
            Thread.sleep(1000);

            driver.findElement(By.id("password")).sendKeys("Password123");
            Thread.sleep(1000);

            driver.findElement(By.id("submit")).click();

            Thread.sleep(3000);

            System.out.println("✅ PracticeTest login done");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            if (driver != null) {
                try {
                    Thread.sleep(3000);
                    driver.quit();
                } catch (Exception e) {
                    System.out.println("Error closing browser");
                }
            }
        }
    }
}
