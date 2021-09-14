package tests;

import PageObject.RadioButton.RadioButtonResult;
import PageObject.RadioButton.RadioButtonAction;
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
        RadioButtonAction selection = new RadioButtonAction(driver);
        selection.loadPage();
        selection.choose(RadioButtonAction.yes);

        RadioButtonResult result = new RadioButtonResult(driver);
        Assertions.assertEquals("Yes",result.getText(RadioButtonResult.text));
    }

    @Test
    void testSelectImpressive() {
        RadioButtonAction selection = new RadioButtonAction(driver);
        selection.loadPage();
//        selection.waitClick();
        selection.choose(RadioButtonAction.impressive);

        RadioButtonResult result = new RadioButtonResult(driver);
        System.out.println(result.getText(RadioButtonResult.text));
        Assertions.assertEquals("Impressive",result.getText(RadioButtonResult.text));
    }


    @Disabled
    @Test
    void testSelectNo() {
        RadioButtonAction selection = new RadioButtonAction(driver);
        selection.loadPage();
//        selection.waitClick();
        if (selection.isEnabled(RadioButtonAction.no)){
            selection.choose(RadioButtonAction.no);
        }

        RadioButtonResult result = new RadioButtonResult(driver);
        System.out.println(result.noRadioDisabled(RadioButtonAction.no));
        Assertions.assertEquals(false,selection.isEnabled(RadioButtonAction.no));
    }

    @AfterEach
    void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}
