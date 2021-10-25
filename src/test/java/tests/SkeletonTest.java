package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SkeletonTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    @Disabled
    void getColor() {
        driver.get("https://tiket.tokopedia.com/kereta-api/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header[data-testid='DesktopHeader']")));
        String colorCode = driver.findElement(By.cssSelector("button[data-testid='searchTicketButton'")).getCssValue("background");

        Color green = null;
        Pattern pattern = Pattern.compile("rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)");
        Matcher matcher = pattern.matcher(colorCode);

        if (matcher.find()){
            green = Color.fromString(matcher.group());
            System.out.println(matcher.group());
        }

        assert green.asRgb().equals("rgb(3, 172, 14)");
        //#03AC0E
    }



    @AfterEach
    void tearDown() {
        var camera = (TakesScreenshot) driver;
        File screenCapture = camera.getScreenshotAs(OutputType.FILE);
        System.out.println(screenCapture.getAbsolutePath());
        if (driver != null){
            driver.quit();
        }
    }
}
