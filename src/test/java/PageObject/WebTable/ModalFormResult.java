package PageObject.WebTable;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModalFormResult extends AbstractPageObj {


    public static final String formHeader = "registration-form-modal";
    public static final String firstNameInput = "firstName";
    public static final String lastNameInput = "lastName";
    public static final String emailInput = "userEmail";
    public static final String ageInput = "age";
    public static final String salaryInput = "salary";
    public static final String departmentInput = "department";
    public static final String submitButton = "submit";
    public static final String mainHeader = "main-header";


    public ModalFormResult(WebDriver driver) {
        super(driver);
    }

    public WebElement getNode(String node){
        return getDriver().findElement(By.id(node));
    }
    public void waitLoad(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className(mainHeader)));
    }

    public String getInputedText(String node){
        return getDriver().findElement(By.className(node)).getText();
    }
}
