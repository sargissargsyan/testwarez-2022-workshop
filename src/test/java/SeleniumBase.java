import base.DriverHelper;
import org.testng.annotations.AfterMethod;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */
public class SeleniumBase {


    @AfterMethod
    public void cleanUpBase() {
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }
}
