package PageObject.Checkbox;

import PageObject.PageObject;
import PageObject.PageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static PageObject.PageLocators.*;

public class CheckBoxResult extends PageObject {

    /*
        locator used to interact with the checkbox web at https://demoqa.com/checkbox
     */
    public static final String homeNode = "//span[contains(text(), \"Home\")]";
    public static final String desktopNode = "//span[contains(text(), \"Desktop\")]";
    public static final String noteNode = "//span[contains(text(), \"Notes\")]";
    public static final String commandNode = "//span[contains(text(), \"Commands\")]";
    public static final String documentsNode = "//span[contains(text(), \"Documents\")]";
    public static final String workspaceNode = "//span[contains(text(), \"WorkSpace\")]";
    public static final String reactNode = "//span[contains(text(), \"React\")]";
    public static final String angularNode = "//span[contains(text(), \"Angular\")]";
    public static final String veuNode = "//span[contains(text(), \"Veu\")]";
    public static final String officeNode = "//span[contains(text(), \"Office\")]";
    public static final String publicNode = "//span[contains(text(), \"Public\")]";
    public static final String privateNode = "//span[contains(text(), \"Private\")]";
    public static final String classifiedNode = "//span[contains(text(), \"Classified\")]";
    public static final String generalNode = "//span[contains(text(), \"General\")]";
    public static final String downloadsNode = "//span[contains(text(), \"Downloads\")]";
    public static final String wordNode = "//span[contains(text(), \"Word File.doc\")]";
    public static final String excelNode = "//span[contains(text(), \"Excel File.doc\")]";


    /*
    locator used to check if the checkbox checked or not.
    pass these variable as an arguments for @nodesList method.
     */
    public static final String homeNodeChecked = "input#tree-node-home";
    public static final String desktopNodeChecked = "input#tree-node-desktop";
    public static final String noteNodeChecked = "input#tree-node-notes";
    public static final String commandNodeChecked = "input#tree-node-commands";
    public static final String documentsNodeChecked = "input#tree-node-documents";
    public static final String workspaceNodeChecked = "input#tree-node-workspace";
    public static final String reactNodeChecked = "input#tree-node-react";
    public static final String angularNodeChecked = "input#tree-node-angular";
    public static final String veuNodeChecked = "input#tree-node-veu";
    public static final String officeNodeChecked = "input#tree-node-office";
    public static final String publicNodeChecked = "input#tree-node-public";
    public static final String privateNodeChecked = "input#tree-node-private";
    public static final String classifiedNodeChecked = "input#tree-node-classified";
    public static final String generalNodeChecked = "input#tree-node-general";
    public static final String downloadsNodeChecked = "input#tree-node-downloads";
    public static final String wordNodeChecked = "input#tree-node-wordFile";
    public static final String excelNodeChecked = "input#tree-node-excelFile";

    public static final String resultText = "#result span.text-success";

    public CheckBoxResult(WebDriver driver) {
        super(driver);
    }

    public String result(By node){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(node));
        return getDriver().findElement(node).getText();
    }

    /*
        this method is used to expand all the folders
     */
    public List<String> expandAllResult(){
        waitElementWithThisCssSelector(desktopNode);
        waitElementWithThisCssSelector((excelNode));

        return List.of(getTextByCssSelector(desktopNode), getTextByCssSelector(excelNode));
    }
    public List<String> expandHomeResult(){
        waitElementWithThisCssSelector(desktopNode);
        waitElementWithThisCssSelector(downloadsNode);

        return List.of(getTextByCssSelector(desktopNode), getTextByCssSelector(downloadsNode));
    }
    /*
        this method used to collapse all the folders
     */
    public List<Boolean> collapseResult(){
        return List.of(
                getWait().until(ExpectedConditions.invisibilityOf(getElementByXpath(desktopNode))),
                getWait().until(ExpectedConditions.invisibilityOf(getElementByXpath(excelNode)))
        );
    }

    // return checkbox checked status
    public List<Boolean> nodesList(List<String> nodes){
        List<Boolean> status = new LinkedList<>();
        for (var node : nodes) {
            status.add(isThisButtonWithSelectorIsSelected(node));
        }
        return status;
    }

    /*
        return checked status and list of selected folders
     */
    public Map<List<String>, List<Boolean>> selectAllResult(){
        waitElementWithThisCssSelector(desktopNode);
//        if(!locateElementByCssSelector(homeNode).isSelected()){
//            System.out.println("Will not load");
//        }

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
        List<WebElement> texts = getElementsByCssSelector(resultText);
        List<String> selected = new LinkedList<>();

        for (var text: texts) {
            selected.add(text.getText());
        }
        return Map.of(selected,checked);
    }
}
