package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class PageLocators extends PageObject{
    public PageLocators(WebDriver driver) {
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

    public static WebElement waitElementWithThisClassNameEnabled(String className){
        return getWait().until(ExpectedConditions.elementToBeClickable(By.className(className)));
    }

    public static WebElement waitElementWithThisIdEnabled(String id){
        return getWait().until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public static WebElement waitElementWithThisCssSelectorEnabled(String cssSelector){
        return getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
    }

    public static WebElement waitElementWithThisXpathEnabled(String xpath){
        return getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
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

    public static List<WebElement> getElementsByCssSelector(String cssSelector){
        return getDriver().findElements(By.cssSelector(cssSelector));
    }

    public static List<WebElement> getElementsByClassName(String className){
        return getDriver().findElements(By.className(className));
    }

    public static List<WebElement> getElementsByXpath(String xpath){
        return getDriver().findElements(By.xpath(xpath));
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

    public static List<String> getListOfTextWithClassName(List<String> className){
        List<String> list = new LinkedList<>();
        for (var classname : className) {
            list.add(getTextByCssSelector(classname));
        }
        return list;
    }

    public static List<String> getListOfTextWithXpath(List<String> xpath){
        List<String> list = new LinkedList<>();
        for (var path : xpath) {
            list.add(getTextByCssSelector(path));
        }
        return list;
    }

    public static Boolean isThisButtonIdIsSelected(String id){
        return getElementById(id).isSelected();
    }


    public static Boolean isThisButtonWithSelectorIsSelected(String cssSelector){
        return getElementByCssSelector(cssSelector).isSelected();
    }

    public static Boolean isThisThisElementSelectorIsExist(String selector){
        return getElementByCssSelector(selector).isSelected();
    }

    public static Boolean isThisThisElementXPathIsgetElementByXpath(String xpath){
        return getElementByXpath(xpath).isSelected();
    }

    public static String getColor(String selector, String attr){
        return getElementByCssSelector(selector).getCssValue(attr);
    }

    public static Select getSelectElement(String selector){
        return new Select(getElementByCssSelector(selector));
    }

    public static List<String> getSelectedOption(String selector){
        return getSelectElement(selector).getAllSelectedOptions()
                .stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public static String getValueByClassName(String className){
        return getElementByClassName(className).getAttribute("value");
    }

    public static String getValueById(String id){
        return PageLocators.getElementById(id).getAttribute("value");
    }

    public static String getValueByCssSelector(String cssSelector){
        return PageLocators.getElementByCssSelector(cssSelector).getAttribute("value");
    }

    public static Boolean waitValueContains(String locator, String attribute, String value){
        return getWait().until(ExpectedConditions.attributeContains(By.id(locator), attribute, value));
    }

    public static WebElement getTextLink(String text){
        return getDriver().findElement(By.linkText(text));
    }

//    public static
}
