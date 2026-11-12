package com.epam.training.denis_siromlya.practical_task_1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class DynamicLoadingTest {

    private static final String PAGE_URL =
            "https://the-internet.herokuapp.com/dynamic_loading/1";
    private static final Duration TIMEOUT = Duration.ofSeconds(15);

    private WebDriver driver;

    @Test
    void shouldDisplayHelloWorldAfterLoadingFinishes() {
        ChromeOptions options = new ChromeOptions();
        boolean headless = Boolean.getBoolean("headless");
        if (headless) {
            options.addArguments("--headless=new", "--disable-gpu", "--no-sandbox");
        }
        driver = new ChromeDriver(options);
        if (headless) {
            driver.manage().window().setSize(new Dimension(1920, 1080));
        } else {
            driver.manage().window().maximize();
        }
        driver.get(PAGE_URL);

        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
        String actualText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")))
                .getText();

        assertEquals("Hello World!", actualText);
    }

    @AfterEach
    void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
