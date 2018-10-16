package Pages;

import Locators.landingPageLocators;
import base.driverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class LandingPage extends driverBase {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = landingPageLocators.total_widget_close_buttons)
    public List<WebElement> _total_close_button;

    @FindBy(xpath = landingPageLocators.total_Search_TextBox_HintText)
    public List<WebElement> _total_Search_TextBox_HintText;

    @FindBy(xpath = landingPageLocators.total_Search_TextBox)
    public List<WebElement> _total_Search_TextBox;

    @FindBy(xpath = landingPageLocators.hoover_Over_BTC_Related_Product_DropDown)
    public WebElement _hoover_Over_BTC_Related_Product_DropDown;

    @FindBy(xpath = landingPageLocators.Select_BTC_Product_Chart)
    public List<WebElement>  _Select_BTC_Product_Chart;



    public LandingPage Close_BTC_Chart() throws InterruptedException {

        try {
            _total_close_button.get(0).click();
            Thread.sleep(3000); // Just to show an action how it performed i am pausing the execution for 5 sec. This line can be removed later
        }catch (Throwable t) {
            System.out.println("There is an exception please check..." + t.getMessage());
        }

        return this;

    }


    public LandingPage  Search_For_BTC_Related_Product_And_Select_Chart_From_DropDown(String input, String selectSubMenu) throws InterruptedException {

        try {
            for (int i = 0; i < _total_Search_TextBox_HintText.size(); i++) {

                if (_total_Search_TextBox_HintText.get(i).getText().equalsIgnoreCase("Explore Instruments")) {
                    _total_Search_TextBox.get(i).sendKeys(input);

                    WebDriverWait wait = getWait();
                    wait.until(ExpectedConditions.elementToBeClickable(_hoover_Over_BTC_Related_Product_DropDown));

                    Actions action = new Actions(driver);

                    action.moveToElement(_hoover_Over_BTC_Related_Product_DropDown)
                            .build().perform();

                    wait.until(ExpectedConditions.visibilityOfAllElements(_Select_BTC_Product_Chart));

                    for (int j = 0; j < _Select_BTC_Product_Chart.size(); j++) {

                        if (_Select_BTC_Product_Chart.get(j).getText().equalsIgnoreCase(selectSubMenu)) {

                            action.moveToElement(_Select_BTC_Product_Chart.get(j))
                                    .click()
                                    .build().perform();
                            Thread.sleep(3000); // Just to show an action how it performed i am pausing the execution for 5 sec. This line can be removed later
                            return this;
                        }
                    }

                    return this;
                }

            }
        }catch (Throwable t) {
            System.out.println("There is an exception please check..." + t.getMessage());
        }

        return this;
    }


}
