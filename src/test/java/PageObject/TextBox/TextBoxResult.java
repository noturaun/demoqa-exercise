package PageObject.TextBox;

import PageObject.PageObject;
import PageObject.PageLocators;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class TextBoxResult extends PageObject {

    public final static String output = "output";
    public final static String fullName = "p[id=\"name\"]";
    public final static String email = "p[id=\"email\"]";
    public final static String currentAddress = "p[id=\"currentAddress\"]";
    public final static String permanentAddress = "p[id=\"permanentAddress\"]";


    public TextBoxResult(WebDriver driver) {
        super(driver);
    }

    public void waitSubmit(){
        PageLocators.waitElementWithThisId(output);
    }


    public List<String> getSubmitResult(){
        return PageLocators.getListOfTextWithCssSelector(List.of(fullName, email, currentAddress, permanentAddress));
    }
    public List<String> getPartialSubmitResult(){
        return PageLocators.getListOfTextWithCssSelector(List.of(fullName, email));
    }
}
