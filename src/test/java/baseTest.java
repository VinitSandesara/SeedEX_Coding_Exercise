import ParallelTest.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeMethod;

public class baseTest extends TestListenerAdapter {


    public static WebDriver driver;


    public void invokeBrowser() {
        LocalDriverManager.getDriver().get("https://trade.cert.seedcx.com/");
        this.driver = LocalDriverManager.getDriver();
    }




}
