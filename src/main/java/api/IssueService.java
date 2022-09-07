package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.Response;
import utils.TestUtils;

/**
 * @author sargis on 9/7/22
 * @project testwarez-2022-workshop
 */
public class IssueService extends BaseService {

    public static JsonObject createIssue(JsonObject project) {
        JsonObject issueJsonObject = new JsonObject();
        issueJsonObject.addProperty("subject", "Issue subject " + TestUtils.randomString(5));
        issueJsonObject.addProperty("project", project.get("id").getAsString());
        Response response = post("/issues", issueJsonObject);
        String jsonString = getJsonStringFromResponse(response);
        return JsonParser.parseString(jsonString).getAsJsonObject();
    }
}
