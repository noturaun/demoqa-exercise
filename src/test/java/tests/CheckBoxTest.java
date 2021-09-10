package tests;

import PageObject.Checkbox.CheckBoxResult;
import PageObject.Checkbox.CheckBoxSelection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
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
        CheckBoxSelection selection = new CheckBoxSelection(driver);
        selection.loadPage();
        selection.waitClick();
        selection.expandNode(CheckBoxSelection.homeToggle);

        CheckBoxResult result = new CheckBoxResult(driver);
        System.out.println(result.result(CheckBoxResult.desktopNode));
    }

    @Test
    void testExpandAll() {
        CheckBoxSelection selection = new CheckBoxSelection(driver);
        selection.loadPage();
        selection.waitClick();
        selection.expandAll();

        CheckBoxResult results = new CheckBoxResult(driver);
        for (var result :
                results.expandResult()) {
            System.out.println(result);
            Assertions.assertTrue(result.matches("(?i).*Desktop.*|(?i).*Excel File.*"));
        }
    }

    @Test
    void collapseAll() {
        CheckBoxSelection selection = new CheckBoxSelection(driver);
        selection.loadPage();
        selection.waitClick();
        selection.expandAll();
        selection.collapseAll();

        CheckBoxResult results = new CheckBoxResult(driver);
        results.collapseResult();
        for (var result: results.collapseResult()){
            Assertions.assertThrows(NoSuchElementException.class, () -> {

            });
        }

    }

    @Test
    void testSelectAll() {
        CheckBoxSelection selection = new CheckBoxSelection(driver);
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
        CheckBoxResult results = new CheckBoxResult(driver);
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
