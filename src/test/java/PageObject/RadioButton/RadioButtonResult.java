package PageObject.RadioButton;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonResult extends AbstractPageObj {

    public static final By text = By.cssSelector("span.text-success");

    public RadioButtonResult(WebDriver driver) {
        super(driver);
    }

    public String getText(By node){
        return getDriver().findElement(node).getText();
    }

    public Boolean noRadioDisabled(By node){
        return getDriver().findElement(node).isEnabled();
    }

}
