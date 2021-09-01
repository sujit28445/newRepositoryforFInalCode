package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCart extends BasePage {
    public ShoppingCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@value='20000']")
    WebElement FetchedAmount;

    @FindBy(xpath = "//input[@value='Budi']")
    WebElement NameOnShoppingCart;

    @FindBy(xpath = "//input[@value='budi@utomo.com']")
    WebElement EmailOnShoppingCart;

    @FindBy(xpath = "//input[@value='081808466410']")
    WebElement PhoneOnShoppingCart;

    @FindBy(xpath = "//input[@value='Jakarta']")
    WebElement CityOnShoppingCart;

    @FindBy(xpath = "//textarea")
    WebElement AddressOnShoppingCart;

    @FindBy(xpath = "//input[@value='10220']")
    WebElement PostalCodeOnShoppingCart;

    @FindBy(xpath = "//td[@class='amount']")
    WebElement TotalAmount;




    public void ValidateCartvalue(){
        System.out.println("total amount is " +TotalAmount.getText());
        String totalAmountis=TotalAmount.getText();
        String ActualAmount="20,000";
        Assert.assertEquals(totalAmountis,ActualAmount);
        System.out.println("result matched");
    }

    public boolean verifyshoppingacrtdifferentattribute() {
        boolean flag = false;

        if (FetchedAmount.isDisplayed() && NameOnShoppingCart.isDisplayed() && EmailOnShoppingCart.isDisplayed() && PhoneOnShoppingCart.isDisplayed() && CityOnShoppingCart.isDisplayed() && AddressOnShoppingCart.isDisplayed() && PostalCodeOnShoppingCart.isDisplayed() )
            flag = true;
        else
            flag = false;
            return flag;

        }
    public boolean verifyshoppingCartAttributesAreEditable() {
        boolean flag = false;

            //enterText(CardNumberOnCardDetails,properties.getProperty("name"));
            enterText(NameOnShoppingCart, properties.getProperty("name"));
            enterText(EmailOnShoppingCart, properties.getProperty("email"));
            enterText(PhoneOnShoppingCart,properties.getProperty("phone"));
            enterText(CityOnShoppingCart, properties.getProperty("city"));
            wait(AddressOnShoppingCart );
            enterText(AddressOnShoppingCart, properties.getProperty("address"));
            enterText(PostalCodeOnShoppingCart,properties.getProperty("postcode"));

        if (FetchedAmount.isDisplayed() && NameOnShoppingCart.isDisplayed() && EmailOnShoppingCart.isDisplayed() && PhoneOnShoppingCart.isDisplayed() && CityOnShoppingCart.isDisplayed() && AddressOnShoppingCart.isDisplayed() && PostalCodeOnShoppingCart.isDisplayed() )
        flag=true;
        else
            flag = false;
        return flag;

    }

    @FindBy(xpath = "//div[@class='cart-checkout']")
    WebElement CheckoutButtonOnShoppingcartPage;


    public void RedirectstoOrderSummaryPage() {
        click(CheckoutButtonOnShoppingcartPage);
        driver.switchTo().frame("snap-midtrans");
    }









}
