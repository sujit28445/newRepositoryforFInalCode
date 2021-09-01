package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Utils extends Setup {
    public boolean isVisible(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()) {
                flag = true;
            }
        } catch (NoSuchElementException e) {
            flag = false;
        }
        return flag;
    }

    public static void holdExecution(int seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isEditable(WebElement element) {
        boolean flag = false;
        try {
            if (element.isEnabled()) {
                flag = true;
            }
        } catch (NoSuchElementException e) {
            flag = false;
        }
        return flag;
    }

    public WebElement wait(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement wait1(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element){
        try{
            wait(element).click();
        }catch (StaleElementReferenceException e){
            element.click();
            holdExecution(10);
        }catch (NoSuchElementException e){
            element.click();
            holdExecution(10);
        }
    }

    public void enterText(WebElement element,String text){
        try{
            wait(element).clear();
            element.sendKeys(text);
        }catch (StaleElementReferenceException e){
            element.sendKeys(text);
            holdExecution(10);
        }catch (NoSuchElementException e){
            element.sendKeys(text);
            holdExecution(10);
        }
    }
}
