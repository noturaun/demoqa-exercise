package PageObject.RadioButton;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonResult extends AbstractPageObj {

    public static final String text = "span.text-success";

    public RadioButtonResult(WebDriver driver) {
        super(driver);
    }

    public String getText(String node){
        return getTextByCssSelector(node);
    }

    public Boolean noRadioDisabled(String node){
        return getNodeByCssSelector(node).isEnabled();
    }

}
