package PageObject.Checkbox;

import PageObject.PageObject;
import PageObject.Locators;
import PageObject.Actions;
import org.openqa.selenium.WebDriver;

public class CheckBoxAction extends PageObject {

    public static final String mainHeader = "main-header";
    public static final String homeToggle = "button[title=\"Toggle\"]";
    public static final String expandAll = "button[title=\"Expand all\"]";
    public static final String collapseAll = "button[title=\"Collapse all\"]";
    public static final String selectAll = "label[for=\"tree-node-home\"]";

    public CheckBoxAction(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){
        getDriver().get("https://demoqa.com/checkbox");
    }

    public void waitClick(){
        Locators.waitElementWithThisCssSelector(homeToggle);
    }
    public void expandHome(){
        Actions.clickButtonWithThisSelector(homeToggle);
    }
    public void expandAll(){
        Actions.clickButtonWithThisSelector(expandAll);
    }
    public void collapseAll(){
        Actions.clickButtonWithThisSelector(collapseAll);
    }

    public void selectAll(){
        Locators.waitElementWithThisClassName(mainHeader);
        Actions.clickButtonWithThisSelector(selectAll);
    }

}
