package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BankPaymentPage extends BasePage{
    public BankPaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Credit/Debit Card']")
    private WebElement CreditDebitCardLogo;
    @FindBy(xpath = "//input[@name='promo']")
    private WebElement DiscountOption;
    @FindBy(xpath = "//span[@class='text-amount-amount']")
    private WebElement AmountValue;
    private String CardDetailsListPath = "//input[@type='tel']";
    @FindBy(xpath = "//a[@class='button-main-content']")
    private WebElement PayNowButton;
    @FindBy(xpath = "//button[@class='btn btn-sm btn-success']")
    private WebElement OKButton;
    private String MerchantDetails = "//div[@class='col-xs-7']";
    @FindBy(id = "PaRes")
    private WebElement InputOTP;
    @FindBy(xpath = "//span[text()='Transaction failed']")
    private WebElement FailedMessage;
    @FindBy(xpath = "//button[@name='cancel']")
    private WebElement CancelButton;
    private String DiscountCheckBox = "//input[@name='promo']";
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement UseAnotherPaymentOptionButton;
    @FindBy(xpath = "//span[text()='Thank you for your purchase.']")
    private WebElement SuccessMessage;
    public boolean successMessageVisible()
    {
        switchDefaultContent();
        boolean Flag =  wait(SuccessMessage).isDisplayed();
        return Flag;
    }

    public boolean verifyCreditDebitCardLogoVisible()
    {
        boolean Flag = wait(CreditDebitCardLogo).isDisplayed();
        return Flag;
    }

    public boolean verifyON10PercentDiscount()
    {
        click(listHolder(1 , DiscountCheckBox));
        boolean Flag = (AmountValue.getText()).contains(properties.getProperty("10PercentDiscount"));
        return Flag;
    }
    public boolean verifyOnPotongan10Rupiah()
    {
        click(listHolder(0 , DiscountCheckBox));
        boolean Flag = (AmountValue.getText()).contains(properties.getProperty("Potongan10Rupiah"));
        return Flag;
    }
    public boolean verifyDemoMasterCard()
    {
        click(listHolder(2 , DiscountCheckBox));
        boolean Flag = (AmountValue.getText()).contains(properties.getProperty("DemoMasterCard"));
        return Flag;
    }
    public void enterCardNumber()
    {
        enterText(listHolder(0 , CardDetailsListPath) , (properties.getProperty("CardNUmber")));
    }
    public void enteExpiryDate()
    {
        enterText(listHolder(1 , CardDetailsListPath) , (properties.getProperty("CardExpiryDate")));
    }
    public void enterCVV()

    {
        enterText(listHolder(2 , CardDetailsListPath) , (properties.getProperty("CardCVV")));
    }
    public void clickOnPayNow()
    {
        click(PayNowButton);
        holdExecutionForSeconds(5);
        frameSwitchTo(0);
    }

    public boolean verifyMerchantName()
    {
        boolean Flag = (listHolder(0 , MerchantDetails).getText()).contains(properties.getProperty("MerchantName"));
        return Flag;
    }
    public boolean verifyAmount()
    {
        boolean Flag = (listHolder(1 , MerchantDetails)).getText().contains(properties.getProperty("TransactionAmount"));
        return Flag;
    }
    public boolean verifyTransactionTime()
    {
        boolean Flag = (listHolder(2 ,MerchantDetails).getText()).contains(currentTime());
        return Flag;
    }
    public boolean verifyCardNumber()
    {
        boolean Flag = (listHolder(3 , MerchantDetails)).getText().contains(properties.getProperty("TransactionCardNumber"));
        return Flag;
    }
    public void enterOTP()
    {
        enterText((InputOTP), properties.getProperty("OTP"));
    }
    public void clickOnOKButton()
    {
        click(OKButton);
        holdExecutionForSeconds(5);
    }
    public void enterInValidOTP()
    {
        enterText((InputOTP), properties.getProperty("InvalidOTP"));
        System.out.println("entered invalid otp");
    }
    public boolean failedScreenDiplayed()
    {
        frameSwitchTo(0);
        boolean Flag = FailedMessage.isDisplayed();
        return Flag;
    }
    public void clickOnCancelButton()
    {
        click(CancelButton);
    }





}
