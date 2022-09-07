import api.BaseService;
import api.ProjectService;
import com.google.gson.JsonObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.TestUtils;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */
public class ProjectTest extends SeleniumBase {
    private String name;
    private String username;
    private String email ;
    private String password = "testwarez2022";
    private JsonObject newUser;

    @BeforeMethod
    public void setup() {
        name = TestUtils.randomString(5);
        username = TestUtils.randomString(7);
        email = TestUtils.randomEmail(username);
        newUser = BaseService.register(name, email, username, password);
    }

    @AfterMethod
    public void cleanup() {

    }


    @Test
    public void projectPage() {
        LoginPage loginPage = new LoginPage().open();
        loginPage.login("testwarez-2022@user.test", "Testwarez2022");

        ProjectsPage projectsPage = new ProjectsPage().open();
        NewProjectPage newProjectPage = projectsPage.clickNewProjectButton();
        NewScrumProjectPage newScrumProjectPage = newProjectPage.selectScrum();
        newScrumProjectPage.typeProjectName("project name x");
        newScrumProjectPage.typeProjectDescription("project name x");
        ProjectBacklogPage projectBacklogPage = newScrumProjectPage.clickCreateProject();

        //do checks
    }

    @Test
    public void projectPageWithData() {
        JsonObject newProject = ProjectService.createProject();
        login(newUser);

        ProjectPage projectsPage = new ProjectPage(newProject).open();

        ProjectService.deleteProject(newProject);



    }
}
