package PageObject;

import org.openqa.selenium.WebDriver;

public abstract class Actions extends PageObject{
    public Actions(WebDriver driver) {
        super(driver);
    }

    public static void clickButtonWithThisId(String id){
        Locators.getElementById(id).click();
    }

    public static void clickButtonWithThisClassName(String className){
        Locators.getElementByClassName(className).click();
    }

    public static void clickButtonWithThisSelector(String cssSelector){
        Locators.getElementByCssSelector(cssSelector).click();
    }

    public static void clickButtonWithThisXpath(String xpath){
        Locators.getElementByXpath(xpath).click();
    }

    public static void enterTextToThisFieldWithId(String id, String phrase){
        Locators.getElementById(id).sendKeys(phrase);
    }

    public static void enterTextToThisFieldWithCssSelector(String cssSelector, String phrase){
        Locators.getElementByCssSelector(cssSelector).sendKeys(phrase);
    }

    public static void enterTextToThisFieldWithClassName(String className, String phrase){
        Locators.getElementByClassName(className).sendKeys(phrase);
    }
}