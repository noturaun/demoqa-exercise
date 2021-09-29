package PageObject.WebTable;

import PageObject.PageObject;
import PageObject.PageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static PageObject.PageLocators.*;

public class WebTableResult extends PageObject {


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
    public static final String rowGroup = "div[role='rowgroup']";
    public static final String modalDialog ="modal-dialog";
    public static final String cellPath = "//div[@class='rt-tbody']//div[@class='rt-tr-group'][%s]";
    public static final String firstNameCell = "//div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-td'][1]";
    public static final String firstNameCol = "//div[@class='rt-tbody']//div[@class='rt-tr-group'][%s]//div[@class='rt-td'][%s]";
    public static final String selectOpt = "select[aria-label='rows per page']";
    public static final String tableData = "//div[./div[contains(text(),\"%s\")]]";
    public static final String searchBoxId = "searchBox";
    public static final String tablePage = "inpuy[aria-label=\"jump to page\"]";



    public WebTableResult(WebDriver driver) {
        super(driver);
    }

    public void waitLoad(){
        PageLocators.waitElementWithThisClassName(tableBody);
    }

    public void waitTabelPageChange(String page){ getWait().until(ExpectedConditions.textToBe(By.cssSelector(tablePage), page)); }

    public void waitWarning(){
        PageLocators.waitElementWithThisId(".was-validated .form-control:invalid");
    }

    public String getRecordAt(int row, int col){
        String path = String.format(firstNameCol,row,col);
        return PageLocators.getTextByXpath(path);
    }

    public Boolean getModal(){
        return PageLocators.getElementByClassName(modalDialog).isDisplayed();
    }

    public String matcher(String strings){
        Pattern pattern = Pattern.compile("rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)");
        Matcher matcher = pattern.matcher(strings);
        return matcher.group();
    }

    // FIXME: 9/16/21 Selenium could not get the same exact color. Need work around.
    public Color getTextBoxWarning(){
         return Color.fromString(PageLocators.getColor("input[id='userEmail']", "border-color"));
//        return Color.fromString(Locators.getColor("input#userEmail", "border-top-color"));
    }

    public Boolean recordAtIsExist(int row){
        String path = String.format(cellPath,row);
        if (isThisThisElementXPathIsgetElementByXpath(path)){
            return true;
        }
        return false;
    }

    public String showTableSize(){

        // assert using selected option
            for (var option: PageLocators.getSelectElement(selectOpt).getOptions()) {
                if (option.isSelected()){
                    return option.getText();
            }
        }

        // assert using tag name
//        for (var row : Locators.getElementsByCssSelector(rowGroup)) {
//            System.out.println(row.getTagName());
//        }
        return null;
    }

    public List<String> getBulkData(){
        List<String> firstNames = new LinkedList<>();
        for (var firstName : getElementsByXpath(firstNameCell)){
            firstNames.add(firstName.getText().trim());
        }
        return firstNames;
    }

    public Boolean clickNextResult(){
        return waitElementWithThisCssSelectorEnabled("div[class='-previous']").isEnabled();
    }

    public Boolean clickPrevResult(){
        return waitElementWithThisCssSelectorEnabled("div[class='-next']").isEnabled();
    }

    public String jumpToResult(){
        return getElementByCssSelector("input[aria-label='jump to page']").getAttribute("value");
    }

    public String pageSize(){
        return getTextByClassName("-totalPages");
    }

    public List<String> searchResult(String phrase){
        String searchPhrase = String.format(tableData, phrase);
        List<String> searchText = new LinkedList<>();
        for (var element: getElementsByXpath(searchPhrase)) {
//            System.out.println(searchPhrase);
                searchText.add(element.getText());
            System.out.println(element.getText());
        }
        return searchText;
    }
}
