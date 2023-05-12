package example.ru;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalStorageTest extends BaseTest {

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
    }

    @Test
    public void shouldShowCookiesPopup() {
        driver.get("https://www.sberleasing.ru/");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".cookie-warning__group"))));
    }

    @Test
    public void shouldNotShowCookiesPopup() {
        driver.get("https://www.sberleasing.ru/");
        driver.getLocalStorage().setItem("showedSblCookie", "Y");
        driver.get("https://www.sberleasing.ru/about/dokumenty/"); // or page can be refreshed

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".cookie-warning__group"))));
    }
}
