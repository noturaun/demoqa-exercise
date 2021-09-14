package PageObject.RadioButton;

import PageObject.PageObject;
import PageObject.Locators;
import org.openqa.selenium.WebDriver;


public class RadioButtonAction extends PageObject {

    public static final String mainHeader = "main-header";
    public static final String yes = "label[for=\"yesRadio\"]";
    public static final String no = "label[for=\"noRadio\"]";
    public static final String impressive = "label[for=\"impressiveRadio\"]";

    public RadioButtonAction(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){
        getDriver().get("https://demoqa.com/radio-button");
    }
    public void waitClick(){
        Locators.waitElementWithThisClassName(mainHeader);
    }
    public void choose(String node){
        Locators.getElementByCssSelector(node).click();
    }
    public Boolean isEnabled(String node){
        return Locators.getElementByCssSelector(node).isEnabled();
    }
}
