package PageObject.Checkbox;

import PageObject.PageObject;
import PageObject.PageLocators;
import PageObject.PageActions;
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
        PageLocators.waitElementWithThisCssSelector(homeToggle);
    }
    public void expandHome(){
        PageActions.clickButtonWithThisSelector(homeToggle);
    }
    public void expandAll(){
        PageActions.clickButtonWithThisSelector(expandAll);
    }
    public void collapseAll(){
        PageActions.clickButtonWithThisSelector(collapseAll);
    }

    public void selectAll(){
        PageLocators.waitElementWithThisClassName(mainHeader);
        PageActions.clickButtonWithThisSelector(selectAll);
    }

}
