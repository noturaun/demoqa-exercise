package tests;

import PageObject.RadioButton.RadioButtonResult;
import PageObject.RadioButton.RadioButtonSelection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RadioButtonTest {
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
    void testSelectYes() {
        RadioButtonSelection selection = new RadioButtonSelection(driver);
        selection.loadPage();
        selection.waitClick();
        selection.choose(RadioButtonSelection.yes);

        RadioButtonResult result = new RadioButtonResult(driver);
        System.out.println(result.getText(RadioButtonResult.text));
        Assertions.assertEquals("Yes",result.getText(RadioButtonResult.text));
    }

    @Test
    void testSelectImpressive() {
        RadioButtonSelection selection = new RadioButtonSelection(driver);
        selection.loadPage();
        selection.waitClick();
        selection.choose(RadioButtonSelection.impressive);

        RadioButtonResult result = new RadioButtonResult(driver);
        System.out.println(result.getText(RadioButtonResult.text));
        Assertions.assertEquals("Impressive",result.getText(RadioButtonResult.text));
    }


    @Disabled
    @Test
    void testSelectNo() {
        RadioButtonSelection selection = new RadioButtonSelection(driver);
        selection.loadPage();
        selection.waitClick();
        if (selection.isEnabled(RadioButtonSelection.no)){
            selection.choose(RadioButtonSelection.no);
        }

        RadioButtonResult result = new RadioButtonResult(driver);
        System.out.println(result.noRadioDisabled(RadioButtonSelection.no));
        Assertions.assertEquals(false,selection.isEnabled(RadioButtonSelection.no));
    }

    @AfterEach
    void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}
