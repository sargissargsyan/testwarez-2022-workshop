package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */

public class HomePage extends BasePage<HomePage> {
    @FindBy(css = ".master [tg-nav='create-project']")
    private WebElement newProjectButton;

    @Override
    public HomePage open() {
        return openPage();
    }

    @Override
    public HomePage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "/";
    }

    public NewProjectPage clickNewProject() {
        newProjectButton.click();
        return new NewProjectPage().init();
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
