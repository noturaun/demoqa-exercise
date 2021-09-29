package tests;

import PageObject.Checkbox.CheckBoxResult;
import PageObject.Checkbox.CheckBoxAction;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

public class CheckBoxTest extends SkeletonTest{
    @Test
    void testExpandHomeFolder() {
        CheckBoxAction selection = new CheckBoxAction(driver);
        selection.loadPage();
        selection.waitClick();
        selection.expandHome();

        CheckBoxResult results = new CheckBoxResult(driver);
//        results.expandHomeResult().forEach();
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
        for (var result : results.expandAllResult()) {
            System.out.println(result);
            assertTrue(result.matches("(?i).*Desktop.*|(?i).*Excel File.*"));
        }
    }

    @Test
//    @Disabled
    void collapseAll() {
        CheckBoxAction selection = new CheckBoxAction(driver);
        CheckBoxResult results = new CheckBoxResult(driver);

        selection.loadPage();
        selection.waitClick();
        selection.expandAll();
        results.collapseResult().forEach(Assertions::assertFalse);
        selection.collapseAll();

//        for (var result: results.collapseResult()){
//            assertThrows(NoSuchElementException.class, () -> {
//            });
//        }
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
//            for (var checked :
//                    checkeds) {
//                assertEquals(true, checked);
//            }
            checkeds.forEach(Assertions::assertTrue);
//            assertThat(checkeds, Matchers.contains(true));
            assertArrayEquals(strings.toArray(), texts.toArray());
//            for (int i = 0; i < texts.toArray().length; i++) {
//                assertEquals(strings.toArray()[i],texts.toArray()[i]);
//            }
        });
    }


}
