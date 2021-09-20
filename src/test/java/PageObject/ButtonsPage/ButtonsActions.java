package PageObject.ButtonsPage;

import PageObject.PageObject;
import PageObject.PageActions;
import org.openqa.selenium.WebDriver;

import static PageObject.PageActions.*;

public class ButtonsActions extends PageObject {

    public static String doubleClickButtonId = "doubleClickBtn";
    public static String rightClickButtonId = "rightClickBtn";
    public static String dynamicClickButtonId = "//div[@class='row']/div[2]/div/div[3]/button";
    //*[@id="TRljr"]

    public ButtonsActions(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){
        getDriver().get("https://demoqa.com/buttons");
    }
    public void doubleClick(){
        performDoubleClick("id", doubleClickButtonId);
    }
    public void rightClick(){
        performRightClick("id", rightClickButtonId);
    }
    public void clickDynamicElement(){
        clickButtonWithThisXpath(dynamicClickButtonId);
    }
}
