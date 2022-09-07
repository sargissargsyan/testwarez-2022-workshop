import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utils.TestUtils;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */
public class RegisterTest extends SeleniumBase {
    private String username = TestUtils.randomString(5);
    private String email = TestUtils.randomEmail(username);
    private String password = TestUtils.randomString(10);

    @Test
    public void register() {
        RegisterPage registerPage = new RegisterPage().open();
        registerPage.setFullName("Testwarez Name");
        registerPage.setUsername(username);
        registerPage.setpassword(password);
        registerPage.setEmail(email);
        registerPage.clickSignUpButton();

        LoginPage loginPage = new LoginPage().open();
        loginPage.login(email, password);

        //do checks
    }
}
