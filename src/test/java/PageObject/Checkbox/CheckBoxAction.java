package PageObject.Checkbox;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckBoxAction extends AbstractPageObj {

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
        locateElementByCssSelector(homeToggle);

    }
    public void expandHome(){
        getNodeByCssSelector(homeToggle).click();
    }
    public void expandAll(){
        getNodeByCssSelector(expandAll).click();
    }
    public void collapseAll(){
        getNodeByCssSelector(collapseAll).click();
    }

    public void selectAll(){
        locateElementByClassName(mainHeader);
        getNodeByCssSelector(selectAll).click();
    }

}
