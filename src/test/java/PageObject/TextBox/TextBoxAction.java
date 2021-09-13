package PageObject.TextBox;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static PageObject.AbstractPageObj.mainHeader;

public class TextBoxAction extends AbstractPageObj {

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
        locateElementByClassName(mainHeader);
        getNodeById(fullNameInput).sendKeys(fullname);
        getNodeById(emailInput).sendKeys(email);
        getNodeById(currentAddressInput).sendKeys(currentAddress);
        getNodeById(permanentAddressInput).sendKeys(permanentAddress);
        getNodeById(submitButton).click();
    }

    public void inputPartial(String fullname, String email){
        locateElementByClassName(mainHeader);
        getNodeById(fullNameInput).sendKeys(fullname);
        getNodeById(emailInput).sendKeys(email);
        getNodeById(submitButton).click();
    }

}
