package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    //hold the list of elements
    public WebElement listHolder(int index , String xpath) {
        try {
            List<WebElement> Options = driver.findElements(By.xpath(xpath));
            return Options.get(index);
        }catch (IndexOutOfBoundsException e)
        {
            holdExecutionForSeconds(10);
            List<WebElement> Options = driver.findElements(By.xpath(xpath));
            return Options.get(index);
        }

    }
    //hold Execution
    public static void holdExecutionForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Frame Switch
    public void frameSwitchTo(int index)
    {
        holdExecutionForSeconds(5);
        try {
            driver.switchTo().frame(index);
        }catch (NoSuchWindowException e)
        {
            driver.switchTo().window(driver.getWindowHandle());
            driver.switchTo().frame(index);
        }
    }


    // default webelement
    public void switchDefaultContent()
    {
        driver.switchTo().defaultContent();
    }

    //currentTime
    public String currentTime()
    {
        if(System.getProperty("webdriver.chrome.driver") == "chromedriver.exe")
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/dd/yyyy h:");
            LocalDateTime now = LocalDateTime.now();
            return dtf.format(now);

        }else if(System.getProperty("webdriver.gecko.driver") == "geckodriver.exe") {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/M/yyyy h:");
            LocalDateTime now = LocalDateTime.now();
            return dtf.format(now);

        }else
        {
            System.out.println("else condition");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/dd/yyyy h:");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
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
