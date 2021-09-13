package PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPageObj {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public static final String mainHeader = "main-header";

    public AbstractPageObj(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebDriver getDriver(){
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebElement locateElementByClassName(String className){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public WebElement locateElementById(String id){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public WebElement locateElementByCssSelector(String selector){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
    }
    public WebElement locateElementByXpath(String xpath){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }


    public WebElement getNodeById(String node){
        return getDriver().findElement(By.id(node));
    }

    public WebElement getNodeByClassName(String node){
        return getDriver().findElement(By.className(node));
    }

    public WebElement getNodeByCssSelector(String node){
        return getDriver().findElement(By.cssSelector(node));
    }

    public List<WebElement> getListOfElement(String cssSelector){
        return getDriver().findElements(By.cssSelector(cssSelector));
    }

    public WebElement getNodeByXpath(String xpath){
        return getDriver().findElement(By.xpath(xpath));
    }

    public String getTextById(String id){
        return getNodeById(id).getText();
    }

    public String getTextByClassName(String className){
        return getNodeByClassName(className).getText();
    }

    public String getTextByCssSelector(String selector){
        return getNodeByCssSelector(selector).getText();
    }

    public String getTextByXpath(String xpath){
        return getNodeByClassName(xpath).getText();
    }
}
