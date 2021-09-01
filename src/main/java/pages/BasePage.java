package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utils;

import javax.xml.xpath.XPath;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BasePage extends Utils {
    public WebDriver driver;
    public FileInputStream fis;
    public Properties properties;

    public BasePage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        try{
            fis=new FileInputStream("resources/config.properties");
            properties.load(fis);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//a[normalize-space()='BUY NOW']")
    WebElement BuyNowButton;

    @FindBy(xpath="//div[@class='cart-inner']//span[1]")
    WebElement ShoppingCart;


    public boolean BuyNonONBasePage() {
        boolean flag = false;
        if (BuyNowButton.isDisplayed())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void ClikcOnBuyNOw(){
        click(BuyNowButton);
    }
    public boolean redirectToShoppingCartPage() {
        boolean flag = false;
        ClikcOnBuyNOw();
        if (ShoppingCart.isDisplayed())
            flag = true;
        else
            flag = false;
        return flag;
    }

}
