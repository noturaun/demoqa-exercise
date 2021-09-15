package PageObject.WebTable;

import PageObject.PageObject;
import PageObject.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class ModalFormResult extends PageObject {


    public static final String formHeader = "registration-form-modal";
    public static final String firstNameInput = "firstName";
    public static final String lastNameInput = "lastName";
    public static final String emailInput = "userEmail";
    public static final String ageInput = "age";
    public static final String salaryInput = "salary";
    public static final String departmentInput = "department";
    public static final String submitButton = "submit";
    public static final String mainHeader = "main-header";
    public static final String tableBody = "rt-tbody";
    public static final String modalDialog ="modal-dialog";
    public static final String cellPath = "//div[@class='rt-tbody']//div[@class='rt-tr-group'][4]//div[@class='rt-td'][1]";


    public ModalFormResult(WebDriver driver) {
        super(driver);
    }

    public void waitLoad(){
        Locators.waitElementWithThisClassName(tableBody);
    }

    public void waitWarning(){
        Locators.waitElementWithThisId(".was-validated .form-control:invalid");
    }

    public String getRowItem(){
        return Locators.getTextByXpath(cellPath);
    }

    public Boolean getModal(){
        return Locators.getElementByClassName(modalDialog).isDisplayed();
    }

    // FIXME: 9/16/21 Selenium could not get the same exact color. Need work around.
    public Color getTextBoxWarning(){
         return Color.fromString(Locators.getColor(".was-validated .form-control:invalid", "border-color"));
//        return Color.fromString(Locators.getColor("input#userEmail", "border-top-color"));
    }
}
