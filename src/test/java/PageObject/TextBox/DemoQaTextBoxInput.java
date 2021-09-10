package PageObject.TextBox;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoQaTextBoxInput extends AbstractPageObj {

    public final static By fullNameInput = By.id("userName");
    public final static By emailInput = By.id("userEmail");
    public final static By currentAddressInput = By.id("currentAddress");
    public final static By permanentAddressInput = By.id("permanentAddress");
    public final static By submitButton = By.id("submit");

    public DemoQaTextBoxInput(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){
        getDriver().get("https://demoqa.com/text-box");
    }

    public void input(String fullname, String email, String currentAddress, String permanentAddress){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(fullNameInput));
        getDriver().findElement(fullNameInput).sendKeys(fullname);
        getDriver().findElement(emailInput).sendKeys(email);
        getDriver().findElement(currentAddressInput).sendKeys(currentAddress);
        getDriver().findElement(permanentAddressInput).sendKeys(permanentAddress);
        getDriver().findElement(submitButton).click();

    }

}
