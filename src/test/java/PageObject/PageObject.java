package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class PageObject {

    private static WebDriver driver;
    private static WebDriverWait wait;
    public static final String mainHeader = "main-header";

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

}
