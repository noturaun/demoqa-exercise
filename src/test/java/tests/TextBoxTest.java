package tests;

import PageObject.TextBox.TextBoxAction;
import PageObject.TextBox.TextBoxResult;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource(value = {"Muhammad Syahrul, noturaun@mail.com, Bogor, Bogor"})
    void testSumbitFull(String fullName, String email, String currentAddress, String permanentAddress) {
        TextBoxAction input = new TextBoxAction(driver);
        input.loadPage();
        input.input(fullName, email, currentAddress, permanentAddress);

        TextBoxResult results = new TextBoxResult(driver);
        results.waitSubmit();
        results.getSubmitResult();
        for (int idx = 0; idx < results.getSubmitResult().toArray().length; idx++) {
            System.out.println();

        assertEquals("Name:Muhammad Syahrul", results.getSubmitResult().toArray()[0]);
        assertEquals("Email:noturaun@mail.com", results.getSubmitResult().toArray()[1]);
        assertEquals("Current Address :Bogor", results.getSubmitResult().toArray()[2]);
        assertEquals("Permananet Address :Bogor", results.getSubmitResult().toArray()[3]);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"Muhammad Syahrul, noturaun@mail.com,"})
    void testPartialSubmit(String fullName, String email) {
        TextBoxAction input = new TextBoxAction(driver);
        input.loadPage();
        input.inputPartial(fullName, email);

        TextBoxResult results = new TextBoxResult(driver);
        results.waitSubmit();
        results.getPartialSubmitResult();
        for (int idx = 0; idx < results.getPartialSubmitResult().toArray().length; idx++) {
            System.out.println();

            assertEquals("Name:Muhammad Syahrul", results.getPartialSubmitResult().toArray()[0]);
            assertEquals("Email:noturaun@mail.com", results.getPartialSubmitResult().toArray()[1]);
        }

    }

    @Test
    void testFindElements() {
        TextBoxAction input = new TextBoxAction(driver);
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
