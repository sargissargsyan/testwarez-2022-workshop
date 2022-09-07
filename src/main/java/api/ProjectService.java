package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.Response;
import utils.TestUtils;

/**
 * @author sargis on 9/7/22
 * @project testwarez-2022-workshop
 */
public class ProjectService extends BaseService {
    public static JsonObject createProject(JsonObject projectJson) {
        Response response = post("/projects", projectJson);
        String jsonString = getJsonStringFromResponse(response);
        return JsonParser.parseString(jsonString).getAsJsonObject();
    }

    public static JsonObject createProject() {
        JsonObject projectJsonObject = new JsonObject();
        projectJsonObject.addProperty("name", "Test Project " + TestUtils.randomString(5));
        projectJsonObject.addProperty("description", "Test Project description" + TestUtils.randomString(5));
        projectJsonObject.addProperty("creation_template", "1");
        projectJsonObject.addProperty("is_private", "false");
        return createProject(projectJsonObject);
    }

    public static JsonObject editProject(JsonObject project, JsonObject editJsonObject) {
        JsonObject projectJsonObject = new JsonObject();
        projectJsonObject.addProperty("name", "Test Project " + TestUtils.randomString(5));
        projectJsonObject.addProperty("description", "Test Project description" + TestUtils.randomString(5));
        projectJsonObject.addProperty("creation_template", "1");
        projectJsonObject.addProperty("is_private", "false");
        Response response =  patch("/projects/" + project.get("id").getAsString(), editJsonObject);
        String jsonString = getJsonStringFromResponse(response);
        return JsonParser.parseString(jsonString).getAsJsonObject();
    }

    public static void deleteProject(JsonObject project) {
        delete("/projects/", project);
    }
}
