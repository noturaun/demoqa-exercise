package PageObject.TextBox;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.LinkedList;
import java.util.List;

public class TextBoxResult extends AbstractPageObj {

    public final static String output = "output";
    public final static String fullName = "p[id=\"name\"]";
    public final static String email = "p[id=\"email\"]";
    public final static String currentAddress = "p[id=\"currentAddress\"]";
    public final static String permanentAddress = "p[id=\"permanentAddress\"]";


    public TextBoxResult(WebDriver driver) {
        super(driver);
    }

    public void waitSubmit(){
        locateElementById(output);
    }
    public List<String> getText(List<String> nodes){
        List<String> results = new LinkedList<>();
        for (var node : nodes) {
            results.add(getNodeByCssSelector(node).getText());
        }
        return results;
    }

    public List<String> getSubmitResult(){
        return getText(List.of(fullName, email, currentAddress, permanentAddress));
    }
    public List<String> getPartialSubmitResult(){
        return getText(List.of(fullName, email));
    }
}
