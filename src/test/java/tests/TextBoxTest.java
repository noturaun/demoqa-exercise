package tests;

import PageObject.TextBox.TextBoxAction;
import PageObject.TextBox.TextBoxResult;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TextBoxTest extends SkeletonTest{

    @ParameterizedTest //74359025+noturaun@users.noreply.github.com
    @CsvSource(value = {"Muhammad Syahrul, noturaun@users.noreply.github.com, Bogor, Bogor"})
    void testSumbitFull(String fullName, String email, String currentAddress, String permanentAddress) {
        TextBoxAction input = new TextBoxAction(driver);
        // Given : User is on TextBox section
        input.loadPage();
        // When : User enters username as {string}, email as {string}, current address as {string}, and permanent address as {string}
        input.input(fullName, email, currentAddress, permanentAddress);

        // And : User click on submit
        input.submit();

        TextBoxResult results = new TextBoxResult(driver);
        results.waitSubmit();

        List<String> params = List.of("Name:" + fullName, "Email:" + email, "Current Address :" + currentAddress, "Permananet Address :" + permanentAddress);
        // Then : User should see the data they have entered
        assertIterableEquals(params, results.getSubmitResult());
    }

    @ParameterizedTest
    @CsvSource(value = {"Muhammad Syahrul, noturaun@users.noreply.github.com"})
    void testPartialSubmit(String fullName, String email) {
        TextBoxAction input = new TextBoxAction(driver);
        // Given : User is on TextBox section
        input.loadPage();
        // When : User enters username as {string}, email as {string}
        input.inputPartial(fullName, email);
        // And : User click on submit
        input.submit();

        List<String> params = List.of("Name:" + fullName, "Email:" + email);
        TextBoxResult results = new TextBoxResult(driver);
        results.waitSubmit();
        // Then : User should see the data they have entered
        assertIterableEquals(params, results.getPartialSubmitResult());

    }

    @ParameterizedTest
    @CsvSource(value = {"Muhammad Syahrul, x"})
    void testInvalidEmailInput(String fullName, String email) {
        TextBoxAction input = new TextBoxAction(driver);
        // Given : User is on TextBox section
        input.loadPage();
        // When : User enters username as {string}, email as {string}
        input.inputPartial(fullName, email);
        // And : User click on submit
        input.submit();

        TextBoxResult results = new TextBoxResult(driver);
//        results.waitSubmit();
        Color warning = results.getWarning();
//        assertEquals(warning.);
        System.out.println(warning);
    }

    @Disabled
    @Test
    void testFindElements() {
        TextBoxAction input = new TextBoxAction(driver);
        input.loadPage();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-header")));
        WebElement resutl = driver.findElement(By.id("currentAddress"));
        String currentAddress = resutl.getTagName();

        System.out.println(currentAddress);
    }
}
