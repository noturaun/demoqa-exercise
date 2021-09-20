package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static PageObject.PageLocators.*;

public abstract class PageActions extends PageObject{

    public PageActions(WebDriver driver) {
        super(driver);
    }

    static Actions actions = new Actions(getDriver());

    public static void clickButtonWithThisId(String id){
        getElementById(id).click();
    }

    public static void clickButtonWithThisClassName(String className){
        getElementByClassName(className).click();
    }

    public static void clickButtonWithThisSelector(String cssSelector){
        getElementByCssSelector(cssSelector).click();
    }

    public static void clickButtonWithThisXpath(String xpath){
        getElementByXpath(xpath).click();
    }

    public static void enterTextToThisFieldWithId(String id, String phrase){
        getElementById(id).sendKeys(phrase);
    }

    public static void enterTextToThisFieldWithCssSelector(String cssSelector, String phrase){
        getElementByCssSelector(cssSelector).sendKeys(phrase);
    }

    public static void enterTextToThisFieldWithClassName(String className, String phrase){
        getElementByClassName(className).sendKeys(phrase);
    }

    public static void clearInputFieldById(String id){
        getElementById(id).clear();
    }

    public static void selectOption(String selector, String visibleText){
        getSelectElement(selector).selectByVisibleText(visibleText);
    }

    public static void enterKeysToThisFieldWithCssSelector(String cssSelector, Keys keys){
        getElementByCssSelector(cssSelector).sendKeys(keys);
    }

    public static void performDoubleClick(String selectorType, String selector){
        String type = selectorType;
        switch (type){
            case "id" -> actions.doubleClick(getElementById(selector)).perform();
            case "className" -> actions.doubleClick(getElementByClassName(selector)).perform();
            case "cssSelector" -> actions.doubleClick(getElementByCssSelector(selector)).perform();
            case "xpath" -> actions.doubleClick(getElementByXpath(selector)).perform();
            default -> {
                throw new NoSuchElementException(selector);
            }
        }
    }

    public static void performRightClick(String selectorType, String selector){
        String type = selectorType;
        switch (type){
            case "id" -> actions.contextClick(getElementById(selector)).perform();
            case "className" -> actions.contextClick(getElementByClassName(selector)).perform();
            case "cssSelector" -> actions.contextClick(getElementByCssSelector(selector)).perform();
            case "xpath" -> actions.contextClick(getElementByXpath(selector)).perform();
            default -> {
                throw new NoSuchElementException(selector);
            }
        }
    }
}
