package tests;

import PageObject.Checkbox.CheckBoxResult;
import PageObject.Checkbox.CheckBoxAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class CheckBoxTest {
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
    void testExpandHomeFolder() {
        CheckBoxAction selection = new CheckBoxAction(driver);
        selection.loadPage();
        selection.waitClick();
        selection.expandHome();

        CheckBoxResult results = new CheckBoxResult(driver);
        for (var result :
                results.expandHomeResult()) {
            System.out.println(result);
            assertTrue(result.matches("(?i).*Desktop.*|(?i).*Downloads.*"));
        }

    }

    @Test
    void testExpandAll() {
        CheckBoxAction selection = new CheckBoxAction(driver);
        selection.loadPage();
        selection.waitClick();
        selection.expandAll();

        CheckBoxResult results = new CheckBoxResult(driver);
        for (var result :
                results.expandAllResult()) {
            System.out.println(result);
            assertTrue(result.matches("(?i).*Desktop.*|(?i).*Excel File.*"));
        }
    }

    @Test
    @Disabled
    void collapseAll() {
        CheckBoxAction selection = new CheckBoxAction(driver);
        selection.loadPage();
        selection.waitClick();
        selection.expandAll();
        selection.collapseAll();

        CheckBoxResult results = new CheckBoxResult(driver);
        results.collapseResult();
        for (var result: results.collapseResult()){
            assertThrows(NoSuchElementException.class, () -> {
            });
        }
    }

    @Test
    void testSelectAll() {
        CheckBoxAction selection = new CheckBoxAction(driver);
        selection.loadPage();
        selection.waitClick();
        selection.expandAll();
        selection.selectAll();

        List<String> strings = List.of("home",
                "desktop",
                "notes",
                "commands",
                "documents",
                "workspace",
                "react",
                "angular",
                "veu",
                "office",
                "public",
                "private",
                "classified",
                "general",
                "downloads",
                "wordFile",
                "excelFile");

        CheckBoxResult results = new CheckBoxResult(driver);
        results.selectAllResult().forEach((texts,checkeds) -> {
            for (var checked :
                    checkeds) {
                assertEquals(true, checked);
            }
            for (int i = 0; i < texts.toArray().length; i++) {
                assertEquals(strings.toArray()[i],texts.toArray()[i]);
            }
        });
    }

    @AfterEach
    void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}
