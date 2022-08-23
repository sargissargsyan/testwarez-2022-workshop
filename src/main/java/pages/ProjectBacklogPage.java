package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static base.DriverHelper.getDriver;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */

public class ProjectBacklogPage extends BasePage<ProjectBacklogPage> {
    @FindBy(css = ".new-us [variant='primary']")
    private WebElement newStoryButton;

    @Override
    public ProjectBacklogPage open() {
        return openPage();
    }

    @Override
    public ProjectBacklogPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void clickNewStoryButton() {
        newStoryButton.click();
    }

    @Override
    protected void isLoaded() throws Error {

    }

    public String getCurrentProjectId() {
        return getDriver().getCurrentUrl().split("/")[4];
    }
}
