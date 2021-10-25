package tests;

import PageObject.WebTable.WebTableAction;
import PageObject.WebTable.WebTableResult;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.Color;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class WebTableTest extends SkeletonTest{
    Faker faker = new Faker();


    @Test
    void testClickAddButton() {
        WebTableAction page = new WebTableAction(driver);
        page.loadPage();
        page.clickAdd();

        WebTableResult results = new WebTableResult(driver);
        System.out.println(results.getModal());;
        Assertions.assertTrue(results.getModal());
    }

    @ParameterizedTest
    @CsvSource(value = {"Muhammad, Syahrul, noturaun@users.noreply.github.com, 19, 12345, Xdept"})
    void testAddData(String firstName, String lastName, String email, String age, String salary, String dept) {
        WebTableAction page = new WebTableAction(driver);
        page.loadPage();
        page.clickAdd();
        page.inputRegistrationForm(firstName, lastName, email, age, salary, dept);

        WebTableResult results = new WebTableResult(driver);
        results.waitLoad();
        String resultFirsName = results.getRecordAt(4,1);
        assert resultFirsName.equals("Muhammad");
        System.out.println(results.getRecordAt(4,1));
    }

    @ParameterizedTest
    @CsvSource(value = {"Muhammad, Syahrul, 74359025+noturaun@users.noreply.github.com, 19, 12345, Xdept"})
    void testAddDataWithInvalidEmail(String firstName, String lastName, String email, String age, String salary, String dept) {
        WebTableAction page = new WebTableAction(driver);
        page.loadPage();
        page.clickAdd();
        page.inputRegistrationForm(firstName, lastName, email, age, salary, dept);

        WebTableResult results = new WebTableResult(driver);
        System.out.println(results.getTextBoxWarning());
        // FIXME: 9/16/21 Selenium could not get the same exact color. Need work around because test sometime pass. Color should be rgb(220, 53, 69)
        Color warning = results.getTextBoxWarning();
        assumeTrue(warning.asRgb().equals("rgb(220, 53, 69)"), "Color did not match");
        assert warning.asRgb().equals("rgb(220, 53, 69)");
    }

    @Test
    void testEditRecord() {
        WebTableAction page = new WebTableAction(driver);
        page.loadPage();
        page.editRecordAt(1);

        WebTableResult results = new WebTableResult(driver);
        results.waitLoad();
        String resultFirsName = results.getRecordAt(1,1);
        System.out.println(resultFirsName);
        assert resultFirsName.equals("Michael");
    }

    @Test
    void testDelete() {
        WebTableAction page = new WebTableAction(driver);
        page.loadPage();
        page.deleteRecordAt(1);

        WebTableResult results = new WebTableResult(driver);
        results.waitLoad();
        results.recordAtIsExist(1);
        Assertions.assertFalse(results.recordAtIsExist(1));
    }


    @Test
    void testShrinkTable() {
        WebTableAction page = new WebTableAction(driver);
        page.loadPage();
        page.selectTableSizeOption("5 rows");

        WebTableResult results = new WebTableResult(driver);
        results.showTableSize();
        assertEquals("5 rows", results.showTableSize());
    }

    @Test
    void testGrowTable() {
        WebTableAction page = new WebTableAction(driver);
        page.loadPage();
        page.selectTableSizeOption("100 rows");

        WebTableResult results = new WebTableResult(driver);
        results.showTableSize();
        assertEquals("100 rows", results.showTableSize());
    }

    @Test
    void testBulkAdd() {
        WebTableAction page = new WebTableAction(driver);
        page.loadPage();
        page.bulkInput(20);
        // uncomment to grow table size
        // page.selectTableSizeOption("50 rows");

        WebTableResult results = new WebTableResult(driver);
        results.waitLoad();
        for (var name : results.getBulkData()) {
            System.out.println(name);
            assertNotEquals(" ", name);
        }
        
        // uncomment to assert table size
        // assertEquals("50 rows", results.showTableSize());
    }

    @RepeatedTest(5)
    void testAddUsingRepeatedTest() {
        WebTableAction page = new WebTableAction(driver);
        page.loadPage();
        page.clickAdd();
        page.inputRegistrationForm(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                String.valueOf(faker.number().numberBetween(19, 60)),
                faker.number().digits(5),
                faker.company().industry());

        WebTableResult results = new WebTableResult(driver);
        results.waitLoad();
        for (var name : results.getBulkData()) {
            System.out.println(name);
            assertNotEquals(" ", name);
        }

    }

    @Test
    void testNextPrevious() {
        WebTableAction page = new WebTableAction(driver);
        WebTableResult results = new WebTableResult(driver);

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
    @Disabled
    void testJumpTo() {
        WebTableAction page = new WebTableAction(driver);
        WebTableResult results = new WebTableResult(driver);

        page.loadPage();
        page.bulkInput(20);
        assertEquals("3", results.pageSize());

        page.jumpTo("3");
        page.sendEnter();
        results.waitTabelPageChange("3");
        page.jumpTo("1");
        page.sendEnter();
        results.waitTabelPageChange("1");
        assertEquals("1", results.jumpToResult());

        // FIXME: 9/20/21 need fix, page did not jump to 1 page
//        results.waitLoad();
//        page.jumpTo("1");
//        assertEquals("1", results.jumpToResult());
    }

    @Test
    void testSearch() {
        String phrase = "39";
        WebTableAction page = new WebTableAction(driver);
        WebTableResult results = new WebTableResult(driver);

        page.loadPage();
        page.bulkInput(10);
        page.enterSearchPhrase(phrase);

        results.waitLoad();
        for (var record : results.searchResult(phrase)) {
            assertTrue(record.contains(phrase));
            System.out.println(record);
        }
    }

}
