import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */
public class LoginTest extends SeleniumBase {
    @Test
    public void loginViaUI() {
        LoginPage loginPage = new LoginPage().open();
        loginPage.login("testwarez-2022@user.test", "Testwarez2022");

        //do checks
    }

    @Test
    public void loginViaUIError() {
        LoginPage loginPage = new LoginPage().open();
        loginPage.typeUsername("qweqweqwe");
        loginPage.typePassword("Testwarez2022");

        //do checks
    }
}

