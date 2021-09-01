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
}
