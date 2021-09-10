package tests;

import PageObject.TextBox.DemoQaTextBoxInput;
import PageObject.TextBox.DemoQaTextBoxSubmitResult;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TextBoxTest {

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
    void textBoxTest() {
        DemoQaTextBoxInput input = new DemoQaTextBoxInput(driver);
        input.loadPage();
        input.input("Muhammad Syahrul", "noturaun@mail.com", "Bogor", "Bogor");

        DemoQaTextBoxSubmitResult result = new DemoQaTextBoxSubmitResult(driver);
        result.waitSubmit();
        String fullName = result.getFullName();
        String email = result.getEmail();
        String currentAddress = result.getCurrentAddress();
        String permanentAddress = result.getPermanentAddress();

        assertEquals("Name:Muhammad Syahrul", fullName);
        assertEquals("Email:noturaun@mail.com", email);
        assertEquals("Current Address :Bogor", currentAddress);
        assertEquals("Permananet Address :Bogor", permanentAddress);
        System.out.println(fullName);
        System.out.println(email);
        System.out.println(currentAddress);
        System.out.println(permanentAddress);

    }

    @Test
    void testFindElements() {
        DemoQaTextBoxInput input = new DemoQaTextBoxInput(driver);
        input.loadPage();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-header")));
        WebElement resutl = driver.findElement(By.id("currentAddress"));
        String currentAddress = resutl.getTagName();

        System.out.println(currentAddress);
    }

    @AfterEach
    void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}
