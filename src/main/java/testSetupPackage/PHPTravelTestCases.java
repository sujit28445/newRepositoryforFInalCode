package testSetupPackage;

import javafx.scene.layout.Priority;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.Setup;

public class PHPTravelTestCases {
    public WebDriver driver;
    BasePage basePage;
    BuyNowPage buyNowPage;
    SearchResultsPage searchResultsPage;
    ShoppingCart shoppingCart;
    SummaryPage summaryPage;
    SelectPaymentPage selectPaymentPage;
    PaymentDetailsPage paymentDetailsPage;
    BankPaymentPage bankPaymentPage;

    @BeforeClass
    public void tearUp() {
        driver = Setup.launchBrowser("chrome");
    }

    @BeforeMethod
    public void launchWebsite() {
        basePage = new BasePage(driver);
        buyNowPage = new BuyNowPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        selectPaymentPage =new SelectPaymentPage(driver);
        driver.get(basePage.properties.getProperty("url"));
        shoppingCart=new ShoppingCart(driver);
        bankPaymentPage =new BankPaymentPage(driver);
        summaryPage =new SummaryPage(driver);
        paymentDetailsPage=new PaymentDetailsPage(driver);

    }

    @Test (priority = 1)
    public void ValidateThatUSerIsRedirectedToShoppingCartPageAfterClikcingOnBuyNow(){
        Assert.assertTrue(basePage.redirectToShoppingCartPage());
        System.out.println("User has redirected to Shopping cart Popup Page and Testcase is Pass");
    }
    @Test(priority = 2)
    public void ValidatePhoneNameEmailAddressCityAndPostCodeIsAvailableOnShoppingCartPage(){

        basePage.redirectToShoppingCartPage();
        Assert.assertTrue(shoppingCart.verifyshoppingacrtdifferentattribute());
        System.out.println("All Attributes are Present on ");
    }
    @Test(priority = 3)
    public void ValidateThePillowAmountIs20000(){
        basePage.redirectToShoppingCartPage();
        shoppingCart.ValidateCartvalue();
    }
    @Test(priority = 4)
    public void ValidateThatEmailPhoneCityAddressAndPostcodeFieldsAreEditable(){
        basePage.redirectToShoppingCartPage();
        Assert.assertTrue(shoppingCart.verifyshoppingCartAttributesAreEditable());
        System.out.println("Fields has been updated.");
    }

    @Test(priority=5)
    public void ValidateThatUserIsRedirectingToOrderSummaryPageAfterClickingOnCheckOut(){
        basePage.redirectToShoppingCartPage();
        shoppingCart.RedirectstoOrderSummaryPage();
        summaryPage.checkOrderSummary();
    }
    @Test (priority = 6)
    public void ValidateTheOrderDetailsOnOrderPage(){
        basePage.redirectToShoppingCartPage();
        shoppingCart.RedirectstoOrderSummaryPage();
        summaryPage.CheckOrderDetails();
    }
    @Test (priority=7)
    public  void ValidateThatUserIsRedirectedToSlectPaymentPageAfterClickingOnContinueFromOrderDetailPage(){
        basePage.redirectToShoppingCartPage();
        shoppingCart.RedirectstoOrderSummaryPage();
        summaryPage.RedirectToSelectPaymentPage();
        Assert.assertTrue(selectPaymentPage.CheckSlectPayment());
    }

    @Test(priority=9)
    public void ValidateThatUserISAbleToRedirectToCardDetailsPageAfterClickingOnCreditOrDebitCardOption(){
        basePage.redirectToShoppingCartPage();
        shoppingCart.RedirectstoOrderSummaryPage();
        summaryPage.RedirectToSelectPaymentPage();
        Assert.assertTrue(selectPaymentPage.CheckCreditOrDebitCardOptionIsclickable());
    }
    @Test(priority=10)
    public void ValidateThatOrderTotalAMountIsGettingChengeAfterPromoCouponApplied(){
        basePage.redirectToShoppingCartPage();
        shoppingCart.RedirectstoOrderSummaryPage();
        summaryPage.RedirectToSelectPaymentPage();
        selectPaymentPage.ClickonCreditorDebitcard();
        //paymentDetailsPage.Select1000RsPromocode();
        paymentDetailsPage.CheckAfterSelectingCouponNewAmountOnOrderpaymentDetailsPage();
    }
    @Test(priority=11)
    public void ValidateThatpayNowisClickableafterValidInput(){
        basePage.redirectToShoppingCartPage();
        shoppingCart.RedirectstoOrderSummaryPage();
        summaryPage.RedirectToSelectPaymentPage();
        selectPaymentPage.ClickonCreditorDebitcard();
        paymentDetailsPage.EnterCardNumber();
        paymentDetailsPage.EnterCVV();
        paymentDetailsPage.EnterExpiryDate();
        paymentDetailsPage.clickOnPayNow();
        Assert.assertTrue(paymentDetailsPage.checkredirectiontopaymentconfirmationPage());
    }
    @Test(priority = 18)
    public void getcurrentdate() throws InterruptedException {
    bankPaymentPage.getcurrentdateTime();
        basePage.redirectToShoppingCartPage();
        shoppingCart.RedirectstoOrderSummaryPage();
        summaryPage.RedirectToSelectPaymentPage();
        selectPaymentPage.ClickonCreditorDebitcard();
        paymentDetailsPage.EnterCardNumber();
        paymentDetailsPage.EnterCVV();
        paymentDetailsPage.EnterExpiryDate();
        paymentDetailsPage.clickOnPayNow();
        Thread.sleep(1000);
        bankPaymentPage.CheckMerchantName();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
