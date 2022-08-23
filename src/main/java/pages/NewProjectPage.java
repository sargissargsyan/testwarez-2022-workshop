package pages;

import base.BasePage;
import base.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */

public class NewProjectPage extends BasePage<NewProjectPage> {
    @FindBy(css = "[tg-nav='create-project-scrum']")
    private WebElement scrumItem;

    @FindBy(css = "[tg-nav='create-project-kanban']")
    private WebElement kanbanItem;

    @FindBy(css = "[tg-nav='create-project-duplicate']")
    private WebElement duplicateProjectItem;

    @FindBy(css = "[tg-nav='create-project-import']")
    private WebElement importProjectItem;

    @Override
    public NewProjectPage open() {
        return openPage();
    }

    @Override
    public NewProjectPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "/project/new";
    }

    public NewScrumProjectPage selectScrum() {
        WaitHelper.getWait().waitForElementToBeVisible(scrumItem).click();
        WaitHelper.getWait().waitForLoading();
        return new NewScrumProjectPage().init();
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
