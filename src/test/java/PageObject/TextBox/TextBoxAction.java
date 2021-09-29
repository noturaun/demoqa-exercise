package PageObject.TextBox;

import PageObject.PageObject;
import PageObject.PageLocators;
import PageObject.PageActions;
import org.openqa.selenium.WebDriver;

import static PageObject.PageActions.clickButtonWithThisId;
import static PageObject.PageActions.enterTextToThisFieldWithId;
import static PageObject.PageLocators.waitElementWithThisClassName;

public class TextBoxAction extends PageObject {

    public final static String fullNameInput = "userName";
    public final static String emailInput = "userEmail";
    public final static String currentAddressInput = "currentAddress";
    public final static String permanentAddressInput = "permanentAddress";
    public final static String submitButton = "submit";

    public TextBoxAction(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){
        getDriver().get("https://demoqa.com/text-box");
    }

    public void input(String fullname, String email, String currentAddress, String permanentAddress){
        waitElementWithThisClassName(mainHeader);
        enterTextToThisFieldWithId(fullNameInput, fullname);
        enterTextToThisFieldWithId(emailInput, email);
        enterTextToThisFieldWithId(currentAddressInput, currentAddress);
        enterTextToThisFieldWithId(permanentAddressInput, permanentAddress);
    }

    public void inputPartial(String fullname, String email){
        waitElementWithThisClassName(mainHeader);
        enterTextToThisFieldWithId(fullNameInput, fullname);
        enterTextToThisFieldWithId(emailInput, email);
    }

    public void submit(){
        clickButtonWithThisId(submitButton);
    }

}
