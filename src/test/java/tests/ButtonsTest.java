package tests;

import PageObject.ButtonsPage.ButtonActionsResult;
import PageObject.ButtonsPage.ButtonsActions;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonsTest extends SkeletonTest{
    @Test
    void testPerformDoubleCLick() {
        ButtonsActions actions = new ButtonsActions(driver);
        actions.loadPage();
        actions.doubleClick();

        ButtonActionsResult result = new ButtonActionsResult(driver);
        assertTrue(result.getDoubleClickResult());
        assertEquals("You have done a double click", result.getDoubleClickMessage());
    }

    @Test
    void testPerformRightClick() {
        ButtonsActions actions = new ButtonsActions(driver);
        actions.loadPage();
        actions.rightClick();

        ButtonActionsResult result = new ButtonActionsResult(driver);
        assertTrue(result.getRightClickResult());
        assertEquals("You have done a right click", result.getRigthClickMessage());
    }

    @Test
    void testPerformClickOnDynamicButton() {
        ButtonsActions actions = new ButtonsActions(driver);
        actions.loadPage();
        actions.clickDynamicElement();

        ButtonActionsResult result = new ButtonActionsResult(driver);
        assertTrue(result.getDynamicElementResult());
        assertEquals("You have done a dynamic click", result.getDynamicElementClickMessage());
    }
}
