package PageObject.TextBox;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

import java.util.List;

import static PageObject.PageLocators.*;

public class TextBoxResult extends PageObject {

    public final static String emailFieldError = "field-error";
    public final static String output = "output";
    public final static String fullName = "p[id=\"name\"]";
    public final static String email = "p[id=\"email\"]";
    public final static String currentAddress = "p[id=\"currentAddress\"]";
    public final static String permanentAddress = "p[id=\"permanentAddress\"]";


    public TextBoxResult(WebDriver driver) {
        super(driver);
    }

    public void waitSubmit(){
        waitElementWithThisId(output);
    }


    public List<String> getSubmitResult(){
        return getListOfTextWithCssSelector(List.of(fullName, email, currentAddress, permanentAddress));
    }
    public List<String> getPartialSubmitResult(){
        return getListOfTextWithCssSelector(List.of(fullName, email));
    }

    public Color getWarning(){
        return Color.fromString(getDriver().findElement(By.className(emailFieldError)).getCssValue("border-top"));
    }
}
