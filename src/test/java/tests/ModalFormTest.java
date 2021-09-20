package tests;

import PageObject.WebTable.ModalFormAction;
import PageObject.WebTable.ModalFormResult;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

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
        String resultFirsName = results.getRecordAt(4,1);
        assert resultFirsName.equals("Muhammad");
        System.out.println(results.getRecordAt(4,1));
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
        // FIXME: 9/16/21 Selenium could not get the same exact color. Need work around color because test sometime pass. Color should be rgb(220, 53, 69)
        Color warning = results.getTextBoxWarning();
        assert warning.asRgb().equals("rgb(220, 53, 69)");
    }

    @Test
    @Disabled
    void getColor() {
        driver.get("https://tiket.tokopedia.com/kereta-api/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header[data-testid='DesktopHeader']")));
        String colorCode = driver.findElement(By.cssSelector("button[data-testid='searchTicketButton'")).getCssValue("background");

        Color green = null;
        Pattern pattern = Pattern.compile("rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)");
        Matcher matcher = pattern.matcher(colorCode);

        if (matcher.find()){
            green = Color.fromString(matcher.group());
            System.out.println(matcher.group());
        }

        assert green.asRgb().equals("rgb(3, 172, 14)");
        //#03AC0E
    }

    @Test
    void testEditRecord() {
        ModalFormAction page = new ModalFormAction(driver);
        page.loadPage();
        page.editRecordAt(1);

        ModalFormResult results = new ModalFormResult(driver);
        results.waitLoad();
        String resultFirsName = results.getRecordAt(1,1);
        System.out.println(resultFirsName);
        assert resultFirsName.equals("Michael");
    }

    @Test
    void testDelete() {
        ModalFormAction page = new ModalFormAction(driver);
        page.loadPage();
        page.deleteRecordAt(1);

        ModalFormResult results = new ModalFormResult(driver);
        results.waitLoad();
        results.recordAtIsExist(1);
        Assertions.assertFalse(results.recordAtIsExist(1));
    }


    @Test
    void testShrinkTable() {
        ModalFormAction page = new ModalFormAction(driver);
        page.loadPage();
        page.selectTableSizeOption("5 rows");

        ModalFormResult results = new ModalFormResult(driver);
        results.showTableSize();
        assertEquals("5 rows", results.showTableSize());
    }

    @Test
    void testGrowTable() {
        ModalFormAction page = new ModalFormAction(driver);
        page.loadPage();
        page.selectTableSizeOption("100 rows");

        ModalFormResult results = new ModalFormResult(driver);
        results.showTableSize();
        assertEquals("100 rows", results.showTableSize());
    }

    @Test
    void testBulkAdd() {
        ModalFormAction page = new ModalFormAction(driver);
        page.loadPage();
        page.bulkInput(20);
        // uncomment to grow table size
        //page.selectTableSizeOption("50 rows");

        ModalFormResult results = new ModalFormResult(driver);
        results.waitLoad();
        for (var name : results.getBulkData()) {
            System.out.println(name);
            assertNotEquals(" ", name);
        }
        
        // uncomment to assert table size
//        assertEquals("50 rows", results.showTableSize());

    }

    @Test
    void testNextPrevious() {
        ModalFormAction page = new ModalFormAction(driver);
        ModalFormResult results = new ModalFormResult(driver);

        page.loadPage();
        page.bulkInput(20);

        page.clickNext();
        results.waitLoad();
        for (var name :
                results.getBulkData()) {
            System.out.println(name);
            assertNotEquals(" ", name);
        }
        assertTrue(results.clickNextResult());

        page.clickPrev();
        results.waitLoad();
        assertTrue(results.clickPrevResult());
        for (var name :
                results.getBulkData()) {
            System.out.println(name);
            assertNotEquals(" ", name);
        }
    }

    @Test
    void testJumpTo() {
        ModalFormAction page = new ModalFormAction(driver);
        ModalFormResult results = new ModalFormResult(driver);

        page.loadPage();
        page.bulkInput(20);
        assertEquals("3", results.pageSize());

        page.jumpTo("3");
        results.waitLoad();
        assertEquals("3", results.jumpToResult());

        // FIXME: 9/20/21 need fix, page did not jump to 1 page
//        results.waitLoad();
//        page.jumpTo("1");
//        assertEquals("1", results.jumpToResult());
    }

    @Test
    void testSearch() {
        String phrase = "39";
        ModalFormAction page = new ModalFormAction(driver);
        ModalFormResult results = new ModalFormResult(driver);

        page.loadPage();
        page.bulkInput(10);
        page.enterSearchPhrase(phrase);

        results.waitLoad();
//        System.out.println(results.searchResult(phrase));
        for (var record : results.searchResult(phrase)) {
            assertTrue(record.contains(phrase));
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}
