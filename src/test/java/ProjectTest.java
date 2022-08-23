import org.testng.annotations.Test;
import pages.*;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */
public class ProjectTest extends SeleniumBase {

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
}
