package PageObject.RadioButton;

import PageObject.AbstractPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static PageObject.Checkbox.CheckBoxSelection.mainHeader;

public class RadioButtonSelection extends AbstractPageObj {

    public static final By yes = By.cssSelector("label[for=\"yesRadio\"]");
    public static final By no = By.cssSelector("label[for=\"noRadio\"]");
    public static final By impressive = By.cssSelector("label[for=\"impressiveRadio\"]");

    public RadioButtonSelection(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){
        getDriver().get("https://demoqa.com/radio-button");
    }
    public void waitClick(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
    }
    public void choose(By node){
        getDriver().findElement(node).click();
    }
    public Boolean isEnabled(By node){
        return getDriver().findElement(node).isEnabled();
    }
}
