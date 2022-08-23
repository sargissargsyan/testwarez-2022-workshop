package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */
public class DriverHelper {
    public static DriverHelper get() {
        return new DriverHelper();
    }

    public static WebDriver driver;
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    private ChromeOptions options;

    public static WebDriver getDriver() {
        if (driverThread.get() == null) {
            driver = WebDriverManager.chromedriver().create();

            driverThread.set(driver);
        }
        return driverThread.get();
    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
        driverThread.remove();
    }
}
