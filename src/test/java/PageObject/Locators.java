package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.LinkedList;
import java.util.List;

public abstract class Locators extends PageObject{
    public Locators(WebDriver driver) {
        super(driver);
    }
    
    public static WebElement waitElementWithThisClassName(String className){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public static WebElement waitElementWithThisId(String id){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public static WebElement waitElementWithThisCssSelector(String selector){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
    }
    public static WebElement waitElementWithThisXpath(String xpath){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static WebElement getElementById(String id){
        return getDriver().findElement(By.id(id));
    }

    public static WebElement getElementByClassName(String className){
        return getDriver().findElement(By.className(className));
    }

    public static WebElement getElementByCssSelector(String cssSelector){
        return getDriver().findElement(By.cssSelector(cssSelector));
    }


    public static WebElement getElementByXpath(String xpath){
        return getDriver().findElement(By.xpath(xpath));
    }

    public static List<WebElement> getListOfElement(String cssSelector){
        return getDriver().findElements(By.cssSelector(cssSelector));
    }

    public static String getTextById(String id){
        return getElementById(id).getText();
    }

    public static String getTextByClassName(String className){
        return getElementByClassName(className).getText();
    }

    public static String getTextByCssSelector(String selector){
        return getElementByCssSelector(selector).getText();
    }

    public static String getTextByXpath(String xpath){
        return getElementByXpath(xpath).getText();
    }

    public static List<String> getListOfTextWithCssSelector(List<String> cssSelector){
        List<String> list = new LinkedList<>();
        for (var selector : cssSelector) {
            list.add(getTextByCssSelector(selector));
        }
        return list;
    }

    public static List<String> getListOfTextWithId(List<String> classNames){
        List<String> list = new LinkedList<>();
        for (var className : classNames) {
            list.add(getTextByCssSelector(className));
        }
        return list;
    }

    public static List<String> getListOfTextWithXpath(List<String> xpaths){
        List<String> list = new LinkedList<>();
        for (var xpath : xpaths) {
            list.add(getTextByCssSelector(xpath));
        }
        return list;
    }

    public static Boolean isThisButtonIdIsSelected(String id){
        return getElementByCssSelector(id).isSelected();
    }
}
