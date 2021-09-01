package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.jnlp.BasicService;
import java.io.FileInputStream;
import java.util.Properties;

public class PaymentDetailsPage extends BasePage{
    public PaymentDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        properties = new Properties();
        try{
            fis=new FileInputStream("resources/config.properties");
            properties.load(fis);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FindBy(xpath = "//span[@class='text-amount-amount']")
    WebElement ChecngedAmountAfterCouponAppled;

    @FindBy(xpath="//div[@class='page-container scroll']//div[1]//div[1]//label[1]//input[1]")
    WebElement Slect10RsCouponCode;

    @FindBy(xpath="#application > div.container-fluid > div > div > div > form > div:nth-child(4) > div.input-row > div:nth-child(2) > div")
    WebElement Slect10PercenCouponCode;

    @FindBy(xpath="//*[@id=\"application\"]/div[3]/div/div/div/form/div[4]/div[2]/div[3]/div/label/input")
    WebElement Slect1000RsCouponCode;

   public void select10RsPromocode(){
       if(!Slect10RsCouponCode.isSelected())
           click(Slect10RsCouponCode);
       else
           click(Slect10RsCouponCode);
   }
   public void Slect10PercenTPromocode(){
       if(!Slect10PercenCouponCode.isSelected())
           click(Slect10PercenCouponCode);
       else
           click(Slect10PercenCouponCode);
   }
   public void Select1000RsPromocode(){
       if(!Slect1000RsCouponCode.isSelected())
       click(Slect1000RsCouponCode);
       else
           click(Slect1000RsCouponCode);
   }

   public void CheckAfterSelectingCouponNewAmountOnOrderpaymentDetailsPage(){
       //boolean flag = false;
       String ChangedValue="19,000";
       Select1000RsPromocode();
       System.out.println(ChecngedAmountAfterCouponAppled.getText());
       Assert.assertEquals(ChecngedAmountAfterCouponAppled.getText(),ChangedValue);
       System.out.println("Amount Is Verified");
   }
    @FindBy(xpath = "//input[@placeholder='4811 1111 1111 1114']")
    WebElement CardNumberOnCardDetails;

    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    WebElement ExpiryDateofCard;

    @FindBy(xpath = "//input[@placeholder='123']")
    WebElement CVVNumberOfTheCard;

    public void EnterCardNumber(){
      //String CardNumber=properties.getProperty("cardNumber");
      enterText(CardNumberOnCardDetails,properties.getProperty("cardNumber"));
    }
    public void EnterExpiryDate(){
        enterText(ExpiryDateofCard,properties.getProperty("ExpiryDate"));
    }
    public void EnterCVV(){
       enterText(CVVNumberOfTheCard,properties.getProperty("CVV"));
    }
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement PayNowOnPaymntDetailPage;
    public void clickOnPayNow(){
        click(PayNowOnPaymntDetailPage);
        //driver.switchTo().frame(0);
        driver.switchTo().window(driver.getWindowHandle());
        driver.switchTo().frame(0);

    }
    @FindBy(xpath = "//h1[normalize-space()='COCO STORE']")
    WebElement PaymentgatewayName;
    public boolean checkredirectiontopaymentconfirmationPage(){
        boolean flag = false;

        if (PaymentgatewayName.isDisplayed() )
        {
            flag = true;
            System.out.println("redirected successfully");
        }
        else
        {
            flag = false;
            System.out.println("not redirected to payment confirmation page");
        }
        return flag;

    }


}
