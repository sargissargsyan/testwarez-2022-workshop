package pages;

import base.BasePage;
import base.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */

public class NewIssuePage extends BasePage<NewIssuePage> {
    @FindBy(css = "[name='subject']")
    private WebElement subjectInput;

    @FindBy(id = "submitButton")
    private WebElement issueCreateButton;

    @Override
    public NewIssuePage open() {
        return openPage();
    }

    @Override
    public NewIssuePage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "";
    }


    @Override
    protected void isLoaded() throws Error {

    }

    public void typeSubject(String subject) {
        WaitHelper.getWait().waitForElementToBeVisible(subjectInput).sendKeys(subject);
    }

    public void clickCreate() {
        issueCreateButton.click();
    }
}
