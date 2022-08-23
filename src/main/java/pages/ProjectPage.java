package pages;

import base.BasePage;
import com.google.gson.JsonObject;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */
public class ProjectPage extends BasePage<ProjectPage> {
    JsonObject project;
    public ProjectPage(JsonObject project) {
        this.project = project;
    }

    @Override
    public ProjectPage open() {
        return openPage();
    }

    @Override
    public ProjectPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/project/" + project.get("slug").getAsString();
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
