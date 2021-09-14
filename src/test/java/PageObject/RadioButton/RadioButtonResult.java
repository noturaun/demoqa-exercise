package PageObject.RadioButton;

import PageObject.PageObject;
import PageObject.Locators;
import org.openqa.selenium.WebDriver;

public class RadioButtonResult extends PageObject {

    public static final String text = "span.text-success";

    public RadioButtonResult(WebDriver driver) {
        super(driver);
    }

    public String getText(String node){
        return Locators.getTextByCssSelector(node);
    }

    public Boolean noRadioDisabled(String node){
        return Locators.getElementByCssSelector(node).isEnabled();
    }

}
