package tests;

import PageObject.WebTable.ModalFormAction;
import PageObject.WebTable.ModalFormResult;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalFormTest {
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
    @CsvSource(value = {"Muhammad, Syahrul, noturaun@users.noreply.github.com, 19, 12345, Xdept"})
    void testClickAddButton(String firstName, String lastName, String email, String age, String salary, String dept) {
        ModalFormAction click = new ModalFormAction(driver);
        click.loadPage();
        click.clickAdd();
        click.inputRegistrationForm(firstName, lastName, email, age, salary, dept);

        ModalFormResult results = new ModalFormResult(driver);
        results.waitLoad();
        System.out.println(results.getRowItem());
        Assertions.assertEquals("Muhammad", results.getRowItem());
    }

    @AfterEach
    void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}
