package PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPageObj {

    private WebDriver driver;
    private WebDriverWait wait;

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
}
