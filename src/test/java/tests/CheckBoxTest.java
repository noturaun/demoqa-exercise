package tests;

import PageObject.Checkbox.DemoQaCheckBoxResult;
import PageObject.Checkbox.DemoQaCheckBoxSelection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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
        DemoQaCheckBoxSelection selection = new DemoQaCheckBoxSelection(driver);
        selection.loadPage();
        selection.waitClick();
        selection.expandNode(DemoQaCheckBoxSelection.homeToggle);

        DemoQaCheckBoxResult result = new DemoQaCheckBoxResult(driver);
        System.out.println(result.result(DemoQaCheckBoxResult.desktopNode));
    }

    @Test
    void testExpandAll() {
        DemoQaCheckBoxSelection selection = new DemoQaCheckBoxSelection(driver);
        selection.loadPage();
        selection.waitClick();
        selection.expandAll();

        DemoQaCheckBoxResult results = new DemoQaCheckBoxResult(driver);
        for (var result :
                results.expandResult()) {
            System.out.println(result);
            Assertions.assertTrue(result.matches("(?i).*Desktop.*|(?i).*Excel File.*"));
        }
    }

    @Test
    void collapseAll() {
        DemoQaCheckBoxSelection selection = new DemoQaCheckBoxSelection(driver);
        selection.loadPage();
        selection.waitClick();
        selection.expandAll();
        selection.collapseAll();

        DemoQaCheckBoxResult results = new DemoQaCheckBoxResult(driver);
        results.collapseResult();
        for (var result: results.collapseResult()){
            Assertions.assertThrows(NoSuchElementException.class, () -> {

            });
        }

    }

    @Test
    void testSelectAll() {
        DemoQaCheckBoxSelection selection = new DemoQaCheckBoxSelection(driver);
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

//        System.out.println(driver.findElement(By.cssSelector("input#tree-node-home")).isSelected());;
        DemoQaCheckBoxResult results = new DemoQaCheckBoxResult(driver);
        results.selectAllResult().forEach((texts,checkeds) -> {
//            System.out.println(texts);
//            System.out.println(checkeds);
            for (var checked :
                    checkeds) {
//                System.out.println(checked);
                Assertions.assertEquals(true, checked);
            }
            for (int i = 0; i < texts.toArray().length; i++) {
//                System.out.println(texts.toArray()[i]);
                Assertions.assertEquals(strings.toArray()[i],texts.toArray()[i]);
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
