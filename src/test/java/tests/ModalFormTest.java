package tests;

import PageObject.WebTable.ModalFormAction;
import PageObject.WebTable.ModalFormResult;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
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

    @Test
    void testClickAddButton() {
        ModalFormAction page = new ModalFormAction(driver);
        page.loadPage();
        page.clickAdd();

        ModalFormResult results = new ModalFormResult(driver);
        System.out.println(results.getModal());;
        Assertions.assertTrue(results.getModal());
    }

    @ParameterizedTest
    @CsvSource(value = {"Muhammad, Syahrul, noturaun@users.noreply.github.com, 19, 12345, Xdept"})
    void testAddData(String firstName, String lastName, String email, String age, String salary, String dept) {
        ModalFormAction page = new ModalFormAction(driver);
        page.loadPage();
        page.clickAdd();
        page.inputRegistrationForm(firstName, lastName, email, age, salary, dept);

        ModalFormResult results = new ModalFormResult(driver);
        results.waitLoad();
        String resultFirsName = results.getRowItem();
        assert resultFirsName.equals("Muhammad");
        System.out.println(results.getRowItem());
    }

    @ParameterizedTest
    @CsvSource(value = {"Muhammad, Syahrul, 74359025+noturaun@users.noreply.github.com, 19, 12345, Xdept"})
    void testAddDataWithInvalidEmail(String firstName, String lastName, String email, String age, String salary, String dept) {
        ModalFormAction page = new ModalFormAction(driver);
        page.loadPage();
        page.clickAdd();
        page.inputRegistrationForm(firstName, lastName, email, age, salary, dept);

        ModalFormResult results = new ModalFormResult(driver);
        System.out.println(results.getTextBoxWarning());
        // FIXME: 9/16/21 Selenium could not get the same exact color. Need work around.
        Color warning = results.getTextBoxWarning();
        assert warning.asRgb().equals("rgb(220, 53, 69");
    }

    @AfterEach
    void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}
