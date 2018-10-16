import Pages.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import sun.jvm.hotspot.debugger.Page;

public class TestCase extends baseTest {


    @Test
    public void Close_BTC_Chart_Widget() throws InterruptedException {

        invokeBrowser();

        LandingPage lPage = new LandingPage(driver);
        PageFactory.initElements(driver,lPage);

        lPage
                .Close_BTC_Chart();

    }

    @Test
    public void Search_For_BTC_Related_Product_And_Select_Chart_From_DropDown() throws InterruptedException {

        invokeBrowser();

        LandingPage lPage = new LandingPage(driver);
        PageFactory.initElements(driver,lPage);

        lPage
                .Search_For_BTC_Related_Product_And_Select_Chart_From_DropDown("BTC", "Chart");

    }



}
