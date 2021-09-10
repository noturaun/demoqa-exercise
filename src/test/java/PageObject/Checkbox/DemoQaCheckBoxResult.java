package PageObject.Checkbox;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DemoQaCheckBoxResult extends AbstractPageObj {

    /*
        locator used to interact with the checkbox web at https://demoqa.com/checkbox
     */
    public static final By homeNode = By.cssSelector("label[for=\"tree-node-home\"]0");
    public static final By desktopNode = By.cssSelector("label[for=\"tree-node-desktop\"]");
    public static final By noteNode = By.cssSelector("label[for=\"tree-node-notes\"]");
    public static final By commandNode = By.cssSelector("label[for=\"tree-node-commands\"]");
    public static final By documentsNode = By.cssSelector("label[for=\"tree-node-documents\"]");
    public static final By workspaceNode = By.cssSelector("label[for=\"tree-node-workspace\"]");
    public static final By reactNode = By.cssSelector("label[for=\"tree-node-react\"]");
    public static final By angularNode = By.cssSelector("label[for=\"tree-node-angular\"]");
    public static final By veuNode = By.cssSelector("label[for=\"tree-node-veu\"]");
    public static final By officeNode = By.cssSelector("label[for=\"tree-node-office\"]");
    public static final By publicNode = By.cssSelector("label[for=\"tree-node-public\"]");
    public static final By privateNode = By.cssSelector("label[for=\"tree-node-private\"]");
    public static final By classifiedNode = By.cssSelector("label[for=\"tree-node-classified\"]");
    public static final By generalNode = By.cssSelector("label[for=\"tree-node-general\"]");
    public static final By downloadsNode = By.cssSelector("label[for=\"tree-node-downloads\"]");
    public static final By wordNode = By.cssSelector("label[for=\"tree-node-wordFile\"]");
    public static final By excelNode = By.cssSelector("label[for=\"tree-node-excelFile\"]");

    /*
    locator used to check if the checkbox checked or not.
    pass these variable as an arguments for @nodesList method.
     */
    public static final By homeNodeChecked = By.cssSelector("input#tree-node-home");
    public static final By desktopNodeChecked = By.cssSelector("input#tree-node-desktop");
    public static final By noteNodeChecked = By.cssSelector("input#tree-node-notes");
    public static final By commandNodeChecked = By.cssSelector("input#tree-node-commands");
    public static final By documentsNodeChecked = By.cssSelector("input#tree-node-documents");
    public static final By workspaceNodeChecked = By.cssSelector("input#tree-node-workspace");
    public static final By reactNodeChecked = By.cssSelector("input#tree-node-react");
    public static final By angularNodeChecked = By.cssSelector("input#tree-node-angular");
    public static final By veuNodeChecked = By.cssSelector("input#tree-node-veu");
    public static final By officeNodeChecked = By.cssSelector("input#tree-node-office");
    public static final By publicNodeChecked = By.cssSelector("input#tree-node-public");
    public static final By privateNodeChecked = By.cssSelector("input#tree-node-private");
    public static final By classifiedNodeChecked = By.cssSelector("input#tree-node-classified");
    public static final By generalNodeChecked = By.cssSelector("input#tree-node-general");
    public static final By downloadsNodeChecked = By.cssSelector("input#tree-node-downloads");
    public static final By wordNodeChecked = By.cssSelector("input#tree-node-wordFile");
    public static final By excelNodeChecked = By.cssSelector("input#tree-node-excelFile");

    public static final By resultText = By.cssSelector("#result span.text-success");

    public DemoQaCheckBoxResult(WebDriver driver) {
        super(driver);
    }

    public String result(By node){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(node));
        return getDriver().findElement(node).getText();
    }

    /*
        this method is used to expand all the folders
     */
    public List<String> expandResult(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(desktopNode));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(excelNode));

        return List.of(getDriver().findElement(desktopNode).getText(), getDriver().findElement(excelNode).getText());
    }
    /*
        this method used to collapse all the folders
     */
    public List<Boolean> collapseResult(){
        return List.of(getDriver().findElement(desktopNode).isDisplayed(), getDriver().findElement(excelNode).isDisplayed());
    }

    // return checkbox checked status
    public List<Boolean> nodesList(List<By> nodes){
        List<Boolean> status = new LinkedList<>();
        for (var node : nodes) {
            status.add(getDriver().findElement(node).isSelected());
        }
        return status;
    }

    /*
        return checked status and list of selected folders
     */
    public Map<List<String>, List<Boolean>> selectAllResult(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(desktopNode));
        if(!getDriver().findElement(homeNodeChecked).isSelected()){
            System.out.println("Will not load");
        }

        List<Boolean> checked = nodesList(List.of(
                homeNodeChecked,
                desktopNodeChecked,
                noteNodeChecked,
                commandNodeChecked,
                documentsNodeChecked,
                workspaceNodeChecked,
                reactNodeChecked,
                angularNodeChecked,
                veuNodeChecked,
                officeNodeChecked,
                publicNodeChecked,
                privateNodeChecked,
                classifiedNodeChecked,
                generalNodeChecked,
                downloadsNodeChecked,
                wordNodeChecked,
                excelNodeChecked));
        List<WebElement> texts = getDriver().findElements(resultText);
        List<String> selected = new LinkedList<>();

        for (var text: texts) {
            selected.add(text.getText());
        }
        return Map.of(selected,checked);
    }
}
