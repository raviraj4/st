package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
    public static void main(String[] args) {
        // WebDriverManager will automatically download the correct version of ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open a website
            driver.get("https://www.example.com");

            // Print the title of the page
            System.out.println("Page title is: " + driver.getTitle());

            // Find a link by its text and click it
            WebElement link = driver.findElement(By.linkText("More information..."));
            link.click();

            // Wait for the page to load
            Thread.sleep(2000);

            // Print the title of the new page
            System.out.println("New page title is: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
