package base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class driverBase {

    public WebDriver driver;

    public driverBase() {

    }

    public driverBase(WebDriver driver){
        this.driver=driver;
    }

    protected WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }
}
