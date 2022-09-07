import api.BaseService;
import base.DriverHelper;
import com.google.gson.JsonObject;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import pages.LoginPage;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */
public class SeleniumBase {

    public void login(JsonObject userJson) {
        new LoginPage().open();
        ((JavascriptExecutor) DriverHelper.getDriver())
                .executeScript("window.localStorage.setItem('token'," + userJson.get("auth_token") +" );");
        ((JavascriptExecutor) DriverHelper.getDriver())
                .executeScript("window.localStorage.setItem('userInfo','" + userJson +"');");
    }

    public void login(String username, String password) {
        JsonObject userInfo = BaseService.login(username, password);
        login(userInfo);
    }


    @AfterMethod
    public void cleanUpBase() {
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }
}
