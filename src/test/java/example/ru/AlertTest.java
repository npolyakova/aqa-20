package example.ru;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertTest extends BaseTest{

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.of(7, ChronoUnit.SECONDS));
    }

    @Test
    public void shouldAcceptAlert() {
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("confirmButton")).click();

        driver.switchTo().alert().accept();

        assertTrue(driver.findElement(By.className("text-success")).isDisplayed());
    }
}
