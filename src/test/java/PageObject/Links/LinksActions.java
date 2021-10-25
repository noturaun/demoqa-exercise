package PageObject.Links;

import PageObject.PageObject;
import PageObject.PageLocators;
import PageObject.PageActions;
import org.openqa.selenium.WebDriver;

public class LinksActions extends PageObject {


    public LinksActions(WebDriver driver) {
        super(driver);
    }


    public void clickLink(String text){
        PageActions.clickLink(text);
    }
}
