package example.ru;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CookiesTest extends BaseTest{

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.of(7, ChronoUnit.SECONDS));
    }

    @Test
    public void shouldShowPopup() throws InterruptedException {
        driver.get("https://www.eldorado.ru/");
        //FIXME
        Thread.sleep(4000);
        wait.until(
                ExpectedConditions.visibilityOf(
                        driver.findElement(By.cssSelector("[href=\"https://static.eldorado.ru/static/MVM_Cookie_Policy.pdf\"]"))
                )
        );
    }

    @Test
    public void shouldNotShowPopup() throws InterruptedException {
        driver.get("https://www.eldorado.ru/");
        driver.manage().addCookie(new Cookie("cookAllow", "1"));
        driver.navigate().refresh();
        //FIXME
        Thread.sleep(4000);
        wait.until(
                ExpectedConditions.visibilityOf(
                        driver.findElement(By.cssSelector("[href=\"https://static.eldorado.ru/static/MVM_Cookie_Policy.pdf\"]"))
                )
        );
    }
}
