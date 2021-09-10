package PageObject.Checkbox;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoQaCheckBoxSelection extends AbstractPageObj {

    public static final By mainHeader = By.className("main-header");
    public static final By homeToggle = By.cssSelector("button[title=\"Toggle\"]");
    public static final By expandAll = By.cssSelector("button[title=\"Expand all\"]");
    public static final By collapseAll = By.cssSelector("button[title=\"Collapse all\"]");
    public static final By selectAll = By.cssSelector("label[for=\"tree-node-home\"]");

    public DemoQaCheckBoxSelection(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){
        getDriver().get("https://demoqa.com/checkbox");
    }

    public void waitClick(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(mainHeader));

    }
    public void expandNode(By node){
        getDriver().findElement(node).click();
    }
    public void expandAll(){
        getDriver().findElement(expandAll).click();
    }
    public void collapseAll(){
        getDriver().findElement(collapseAll).click();
    }

    public void selectAll(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
        getDriver().findElement(selectAll).click();
    }

}
