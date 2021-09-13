package PageObject.WebTable;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ModalFormAction extends AbstractPageObj {

    /*
        Pass these strings as argument fo findNode() method
     */
    public static final String formHeader = "registration-form-modal";
    public static final String firstNameInput = "firstName";
    public static final String lastNameInput = "lastName";
    public static final String emailInput = "userEmail";
    public static final String ageInput = "age";
    public static final String salaryInput = "salary";
    public static final String departmentInput = "department";
    public static final String submitButton = "submit";
    public static final String mainHeader = "main-header";


    public ModalFormAction(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){
        getDriver().get("https://demoqa.com/webtables");
    }

    public WebElement waitLoad(String node){
        if(node.equals("main-header")) {
            return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className(node)));
        }
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(node)));
    }

    public WebElement findNode(String node){
        if(node.equals("main-header")){
            return getDriver().findElement(By.className(node));
        }
        return getDriver().findElement(By.id(node));
    }

    public void clickAdd(String node){
        waitLoad(mainHeader);
        findNode(node).click();
    }

    public void inputRegistrationForm(){
        waitLoad(formHeader);
        findNode(firstNameInput).sendKeys("x");
        findNode(lastNameInput).sendKeys("y");
        findNode(emailInput).sendKeys("x@xyz.cc");
        findNode(ageInput).sendKeys("28");
        findNode(salaryInput).sendKeys("12345");
        findNode(departmentInput).sendKeys("dept");
        findNode(submitButton).click();
    }


}
