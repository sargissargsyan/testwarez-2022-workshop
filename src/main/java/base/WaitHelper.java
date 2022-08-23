package base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */
public class WaitHelper {
    public static WaitHelper getWait(){
        return new WaitHelper();
    }

    public void waitForElementToBeVisible(By location) {
        new WebDriverWait(DriverHelper.get().getDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(location));
    }

    public void waitForElementToBeInVisible(By location) {
        new WebDriverWait(DriverHelper.get().getDriver(), 10)
                .until(ExpectedConditions.invisibilityOfElementLocated(location));
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
       return new WebDriverWait(DriverHelper.get().getDriver(), 10)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForLoading() {
        try {
            waitForElementToBeVisible(By.cssSelector(".loader"));
            waitForElementToBeInVisible(By.cssSelector(".loader"));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
