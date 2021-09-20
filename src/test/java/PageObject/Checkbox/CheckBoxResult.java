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

public class CheckBoxResult extends PageObject {

    /*
        locator used to interact with the checkbox web at https://demoqa.com/checkbox
     */
    public static final String homeNode = "label[for=\"tree-node-home\"]0";
    public static final String desktopNode = "label[for=\"tree-node-desktop\"]";
    public static final String noteNode = "label[for=\"tree-node-notes\"]";
    public static final String commandNode = "label[for=\"tree-node-commands\"]";
    public static final String documentsNode = "label[for=\"tree-node-documents\"]";
    public static final String workspaceNode = "label[for=\"tree-node-workspace\"]";
    public static final String reactNode = "label[for=\"tree-node-react\"]";
    public static final String angularNode = "label[for=\"tree-node-angular\"]";
    public static final String veuNode = "label[for=\"tree-node-veu\"]";
    public static final String officeNode = "label[for=\"tree-node-office\"]";
    public static final String publicNode = "label[for=\"tree-node-public\"]";
    public static final String privateNode = "label[for=\"tree-node-private\"]";
    public static final String classifiedNode = "label[for=\"tree-node-classified\"]";
    public static final String generalNode = "label[for=\"tree-node-general\"]";
    public static final String downloadsNode = "label[for=\"tree-node-downloads\"]";
    public static final String wordNode = "label[for=\"tree-node-wordFile\"]";
    public static final String excelNode = "label[for=\"tree-node-excelFile\"]";

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
        PageLocators.waitElementWithThisCssSelector(desktopNode);
        PageLocators.waitElementWithThisCssSelector((excelNode));

        return List.of(PageLocators.getTextByCssSelector(desktopNode), PageLocators.getTextByCssSelector(excelNode));
    }
    public List<String> expandHomeResult(){
        PageLocators.waitElementWithThisCssSelector(desktopNode);
        PageLocators.waitElementWithThisCssSelector(downloadsNode);

        return List.of(PageLocators.getTextByCssSelector(desktopNode), PageLocators.getTextByCssSelector(downloadsNode));
    }
    /*
        this method used to collapse all the folders
     */
    public List<Boolean> collapseResult(){
        return List.of(
                PageLocators.getElementByCssSelector(desktopNode).isDisplayed(),
                PageLocators.getElementByCssSelector(excelNode).isDisplayed()
        );
    }

    // return checkbox checked status
    public List<Boolean> nodesList(List<String> nodes){
        List<Boolean> status = new LinkedList<>();
        for (var node : nodes) {
            status.add(PageLocators.isThisButtonIdIsSelected(node));
        }
        return status;
    }

    /*
        return checked status and list of selected folders
     */
    public Map<List<String>, List<Boolean>> selectAllResult(){
        PageLocators.waitElementWithThisCssSelector(desktopNode);
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
        List<WebElement> texts = PageLocators.getElementsByCssSelector(resultText);
        List<String> selected = new LinkedList<>();

        for (var text: texts) {
            selected.add(text.getText());
        }
        return Map.of(selected,checked);
    }
}
