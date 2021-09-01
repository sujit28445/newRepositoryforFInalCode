package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"wrapper-inner\"]")
    WebElement FilterSearchBox;

    public boolean filterSearchBoxIsPresent(){
        if(isVisible(FilterSearchBox))
            return true;
        else
            return false;
    }
}
