package pages;

import base.BasePage;
import base.WaitHelper;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */
public class IssuePage extends BasePage<IssuePage> {
    private String projectId ="";

    @FindBy(css = ".detail-status-inner")
    private WebElement issueStatus;

    @FindBy(css = ".user-list-single")
    private WebElement assignee;

    JsonObject issue;
    public IssuePage(JsonObject issue) throws IOException {
        this.issue = issue;
        WaitHelper.getWait().waitForElementToBeVisible(By.cssSelector(".detail-title-text"));
    }

    @Override
    public IssuePage open() {
        return openPage();
    }

    @Override
    public IssuePage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "/project/" + projectId + "/issues" ;
    }

    public String getIssueInnerStatus() {
        return issueStatus.getText();
    }

    public String getIssueAssignee() {
        return assignee.getText();
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
