package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SummaryPage extends BasePage {
    public SummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='text-page-title-content']")
    WebElement OrderSummary;

    public boolean checkOrderSummary() {
        boolean flag = false;
        if (OrderSummary.isDisplayed()) {
            flag = true;
            System.out.println("Summary page Pop-up handled");
        } else {
            flag = false;
            System.out.println("Summary pagePop-up couldn't handled");
        }
        return flag;
    }

    @FindBy(xpath = "//span[@class='item-name']")
    WebElement ItemNameOnSummaryPopup;

    @FindBy(xpath = "//td[@class='table-amount text-body']")
    WebElement ItemCostOnSummaryPopup;

    public void CheckOrderDetails() {
        boolean flag=false;

        String ActualItemName = ItemNameOnSummaryPopup.getText();
        String ExpectedItemName = "Midtrans Pillow";
        String ActualAmount = ItemCostOnSummaryPopup.getText();
        String ExpectedAmount = "20,000";
        /*if(ExpectedItemName==ItemNameOnSummaryPopup.getText() && ExpectedAmount==ItemCostOnSummaryPopup.getText()){
            flag=true;
            System.out.println("Order Details Verified");
        }
            else{
            flag=false;
            System.out.println("Order Details not Verified");
        }*/
        //return flag;
        Assert.assertEquals(ActualItemName,ExpectedItemName);
        System.out.println("Actual Product name Verified with" + ActualItemName);
        Assert.assertEquals(ActualAmount,ExpectedAmount);
        System.out.println("Actual Product Amount Verified with" + ActualAmount);
    }
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement ContinueFromOrderDetailsPopup;

    public void RedirectToSelectPaymentPage(){
        click(ContinueFromOrderDetailsPopup);
    }

}
