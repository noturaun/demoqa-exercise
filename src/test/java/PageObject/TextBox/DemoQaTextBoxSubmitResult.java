package PageObject.TextBox;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoQaTextBoxSubmitResult extends AbstractPageObj {

    public final static By output = By.id("output");
    public final static By fullName = By.cssSelector("p[id=\"name\"]");
    public final static By email = By.cssSelector("p[id=\"email\"]");
    public final static By currentAddress = By.cssSelector("p[id=\"currentAddress\"]");
    public final static By permanentAddress = By.cssSelector("p[id=\"permanentAddress\"]");


    public DemoQaTextBoxSubmitResult(WebDriver driver) {
        super(driver);
    }

    public void waitSubmit(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(output));
    }
    public String getFullName(){
        WebElement fullNameResult = getDriver().findElement(fullName);

        return fullNameResult.getText();
    }

    public String getEmail(){
        WebElement emailResult = getDriver().findElement(email);

        return emailResult.getText();
    }

    public String getCurrentAddress(){
        WebElement currentAddressResult = getDriver().findElement(currentAddress);

        return currentAddressResult.getText();
    }
    public String getPermanentAddress(){
        WebElement permanentAddressResult = getDriver().findElement(permanentAddress);

        return permanentAddressResult.getText();
    }
}
