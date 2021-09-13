package PageObject.RadioButton;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RadioButtonAction extends AbstractPageObj {

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
        locateElementByClassName(mainHeader);
    }
    public void choose(String node){
        getNodeByCssSelector(node).click();
    }
    public Boolean isEnabled(String node){
        return getNodeByCssSelector(node).isEnabled();
    }
}
