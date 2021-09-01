package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BuyNowPage extends BasePage{
    public BuyNowPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"container\"]/a")
    WebElement LogoOnBuyNowPage;


    public boolean LogoOnBuyNowPage() {
        boolean flag = false;
        if (LogoOnBuyNowPage.isDisplayed())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean switchToBuyNowPageAndBackToBasePage() {
        boolean flag = false;
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String s : windows) {
            if (!s.equalsIgnoreCase(parentWindow)) {
                driver.switchTo().window(s);
                if (LogoOnBuyNowPage())
                    flag = true;
                else
                    flag = false;
                break;
            }
        }
        driver.switchTo().window(parentWindow);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return flag;
    }
}
