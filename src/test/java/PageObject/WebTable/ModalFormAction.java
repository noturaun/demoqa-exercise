package PageObject.WebTable;

import PageObject.PageObject;
import PageObject.Locators;
import PageObject.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ModalFormAction extends PageObject {

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
    public static final String addButton = "addNewRecordButton";


    public ModalFormAction(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){
        getDriver().get("https://demoqa.com/webtables");
    }

    public void clickAdd(){
        Actions.clickButtonWithThisId(addButton);
    }

    public void inputRegistrationForm(String firstName, String lastName, String email, String age, String salary, String dept){
        Locators.waitElementWithThisId(formHeader);
        Actions.enterTextToThisFieldWithId(firstNameInput,firstName);
        Actions.enterTextToThisFieldWithId(lastNameInput,lastName);
        Actions.enterTextToThisFieldWithId(emailInput,email);
        Actions.enterTextToThisFieldWithId(ageInput,age);
        Actions.enterTextToThisFieldWithId(salaryInput,salary);
        Actions.enterTextToThisFieldWithId(departmentInput,dept);
        Actions.clickButtonWithThisId(submitButton);
    }

    public void inputRegistrationForm(){
        Locators.waitElementWithThisId(formHeader);
        Actions.enterTextToThisFieldWithId(firstNameInput,"Muhammad");
        Actions.enterTextToThisFieldWithId(lastNameInput,"Syahrul");
        Actions.enterTextToThisFieldWithId(emailInput,"noturaun@mail.com");
        Actions.enterTextToThisFieldWithId(ageInput,"19");
        Actions.enterTextToThisFieldWithId(salaryInput,"123456");
        Actions.enterTextToThisFieldWithId(departmentInput,"Xdept");
        Actions.clickButtonWithThisId(submitButton);
    }
}
