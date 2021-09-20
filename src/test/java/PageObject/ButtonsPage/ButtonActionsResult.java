package PageObject.ButtonsPage;

import PageObject.PageObject;
import PageObject.PageLocators;
import PageObject.PageActions;
import org.openqa.selenium.WebDriver;

import static PageObject.PageLocators.getTextById;

public class ButtonActionsResult extends PageObject {
    public ButtonActionsResult(WebDriver driver) {
        super(driver);
    }

    public Boolean getDoubleClickResult(){
        return PageLocators.waitElementWithThisId("doubleClickMessage").isDisplayed();
    }

    public Boolean getRightClickResult(){
        return PageLocators.waitElementWithThisId("rightClickMessage").isDisplayed();
    }
    public Boolean getDynamicElementResult(){
        return PageLocators.waitElementWithThisId("dynamicClickMessage").isDisplayed();
    }
    public String getDoubleClickMessage(){
        return getTextById("doubleClickMessage");
    }
    public String getRigthClickMessage(){
        return getTextById("rightClickMessage");
    }

    public String getDynamicElementClickMessage(){
        return getTextById("dynamicClickMessage");
    }
}
