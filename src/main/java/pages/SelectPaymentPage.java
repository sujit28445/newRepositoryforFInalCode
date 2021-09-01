package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPaymentPage extends BasePage {
    public SelectPaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='text-page-title-content']")
    WebElement SelectPaaymentOnPaymentPage;

    public boolean CheckSlectPayment(){
        boolean flag = false;
        //wait(SelectPaaymentOnPaymentPage);
        if (SelectPaaymentOnPaymentPage.isDisplayed())
        {
            flag = true;
            System.out.println("paymentpopup Verified");
        }
        else
        {
            flag = false;
            System.out.println("Select Payment pop-up not Verified");
        }
        return flag;
    }

    @FindBy(xpath = "//a[@class='list with-promo']//div[@class='list-content']//div[1]")
    WebElement CreditOrDebitCardOnSelectPaymentPage;

    @FindBy(xpath = "//input[@placeholder='4811 1111 1111 1114']")
    WebElement CardNumberOnCardDetails;

    public void ClickonCreditorDebitcard(){
        click(CreditOrDebitCardOnSelectPaymentPage);
    }

    public boolean CheckCreditOrDebitCardOptionIsclickable(){
        boolean flag = false;
        wait1(CreditOrDebitCardOnSelectPaymentPage);
        if (CreditOrDebitCardOnSelectPaymentPage.isDisplayed())
        {
            flag = true;
            click(CreditOrDebitCardOnSelectPaymentPage);
            if(CardNumberOnCardDetails.isDisplayed())
                {
                flag=true;
                System.out.println("redirected to Card Details Page");
                }else
                      flag=false;
        }
        else
        {
            flag = false;
            System.out.println("User is not yet redirected to Credit or Debit card details page");
        }
        return flag;

    }

}
