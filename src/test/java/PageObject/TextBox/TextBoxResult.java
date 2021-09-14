package PageObject.TextBox;

import PageObject.PageObject;
import PageObject.Locators;
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
        Locators.waitElementWithThisId(output);
    }


    public List<String> getSubmitResult(){
        return Locators.getListOfTextWithCssSelector(List.of(fullName, email, currentAddress, permanentAddress));
    }
    public List<String> getPartialSubmitResult(){
        return Locators.getListOfTextWithCssSelector(List.of(fullName, email));
    }
}
