package PageObject.TextBox;

import PageObject.PageObject;
import PageObject.Locators;
import PageObject.Actions;
import org.openqa.selenium.WebDriver;

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
        Locators.waitElementWithThisClassName(mainHeader);
        Actions.enterTextToThisFieldWithId(fullNameInput, fullname);
        Actions.enterTextToThisFieldWithId(emailInput, email);
        Actions.enterTextToThisFieldWithId(currentAddressInput, currentAddress);
        Actions.enterTextToThisFieldWithId(permanentAddressInput, permanentAddress);
        Actions.clickButtonWithThisId(submitButton);
    }

    public void inputPartial(String fullname, String email){
        Locators.waitElementWithThisClassName(mainHeader);
        Actions.enterTextToThisFieldWithId(fullNameInput, fullname);
        Actions.enterTextToThisFieldWithId(emailInput, email);
        Actions.clickButtonWithThisId(submitButton);
    }

}
