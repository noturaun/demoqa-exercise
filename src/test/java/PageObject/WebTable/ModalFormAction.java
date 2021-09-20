package PageObject.WebTable;

import PageObject.PageObject;
import PageObject.Locators;
import PageObject.Actions;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

import static PageObject.Actions.*;
import static PageObject.Locators.waitElementWithThisId;


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
    public static final String selectOpt = "select[aria-label='rows per page']";

    Faker faker = new Faker();


    public ModalFormAction(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){
        getDriver().get("https://demoqa.com/webtables");
    }

    public void clickAdd(){
        clickButtonWithThisId(addButton);
    }

    public void inputRegistrationForm(String firstName, String lastName, String email, String age, String salary, String dept){
        waitElementWithThisId(formHeader);
        enterTextToThisFieldWithId(firstNameInput,firstName);
        enterTextToThisFieldWithId(lastNameInput,lastName);
        enterTextToThisFieldWithId(emailInput,email);
        enterTextToThisFieldWithId(ageInput,age);
        enterTextToThisFieldWithId(salaryInput,salary);
        enterTextToThisFieldWithId(departmentInput,dept);
        clickButtonWithThisId(submitButton);
    }

    public void inputRegistrationForm(){
        waitElementWithThisId(formHeader);
        enterTextToThisFieldWithId(firstNameInput,"Muhammad");
        enterTextToThisFieldWithId(lastNameInput,"Syahrul");
        enterTextToThisFieldWithId(emailInput,"noturaun@mail.com");
        enterTextToThisFieldWithId(ageInput,"19");
        enterTextToThisFieldWithId(salaryInput,"123456");
        enterTextToThisFieldWithId(departmentInput,"Xdept");
        clickButtonWithThisId(submitButton);
    }

    public void bulkInput(Integer num){
        List<Map<String, String>> dataList = new LinkedList<>();
//        Map<String,String> data = new HashMap<>();
        for (var i = 0; i < num; i++){
           Map<String, String> data = Map.of(
                   "firstName", faker.name().firstName(),
                   "lastName", faker.name().lastName(),
                   "age", String.valueOf(faker.number().numberBetween(19, 60)),
                   "email", faker.internet().emailAddress(),
                   "salary", faker.number().digits(5),
                   "dept", faker.company().name()
           );
           dataList.add(data);
        }
        for (var data : dataList) {
            clickAdd();
           inputRegistrationForm(
                   data.get("firstName"),
                   data.get("lastName"),
                   data.get("email"),
                   data.get("age"),
                   data.get("salary"),
                   data.get("dept"));
        }
    }

    public void editRecordAt(int row){
        String path = String.format("edit-record-%s",row);
        clickButtonWithThisId(path);
        waitElementWithThisId(formHeader);
        clearInputFieldById(firstNameInput);
        enterTextToThisFieldWithId(firstNameInput,"Michael");
        clickButtonWithThisId(submitButton);
    }

    public void deleteRecordAt(int row){
        String path = String.format("delete-record-%s",row);
        clickButtonWithThisId(path);
    }

    public void selectTableSizeOption(String option){
//        Actions.clickButtonWithThisClassName("-pageSizeOptions");
        selectOption(selectOpt, option);

    }

    public void clickNext(){
        clickButtonWithThisSelector("div[class='-next']");
    }

    public void clickPrev(){
        clickButtonWithThisSelector("div[class='-previous']");
    }

    public void jumpTo(String page){
        enterTextToThisFieldWithCssSelector("input[aria-label='jump to page']", page);
        enterKeysToThisFieldWithCssSelector("input[aria-label='jump to page']", Keys.ENTER);
    }
}
