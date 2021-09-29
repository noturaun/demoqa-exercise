package tests;

import PageObject.RadioButton.RadioButtonResult;
import PageObject.RadioButton.RadioButtonAction;
import org.junit.jupiter.api.*;

public class RadioButtonTest extends SkeletonTest{

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
}
