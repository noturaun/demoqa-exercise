package tests;

import PageObject.WebTable.ModalFormAction;
import PageObject.WebTable.ModalFormResult;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalFormTest {
    WebDriver driver;
    WebDriverWait wait;

    String addButton = "addNewRecordButton";

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
    void testClickAddButton() {
        ModalFormAction click = new ModalFormAction(driver);
        click.loadPage();
        click.clickAdd(addButton);
        click.inputRegistrationForm();

        ModalFormResult results = new ModalFormResult(driver);
        results.waitLoad();
        System.out.println(results.getInputedText("rt-td"));
        Assertions.assertEquals('x', results.getInputedText("rt-td"));

        System.out.println(click.findNode(addButton).getTagName());
    }

    @AfterEach
    void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}
