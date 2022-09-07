package api;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import utils.TestUtils;

import java.io.IOException;

/**
 * @author sargis on 9/7/22
 * @project testwarez-2022-workshop
 */
public class BaseService {
    private static final String BASE_URL = "http://localhost:9000/api/v1";
    private static String authToken = null;

    public static JsonObject login(String username, String password) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        JsonObject bodyJson = new JsonObject();
        bodyJson.addProperty("username", username);
        bodyJson.addProperty("password", password);
        bodyJson.addProperty("type", "normal");
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, bodyJson.toString());
        Request request = new Request.Builder()
                .url(BASE_URL + "/auth")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = null;
        JsonObject responseJson = null;
        try {
            response = client.newCall(request).execute();
            String jsonString = response.body().string();
            responseJson = JsonParser.parseString(jsonString).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        authToken = responseJson.get("auth_token").getAsString();
        return responseJson;
    }

    public static JsonObject register(String name, String email, String username, String password) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        JsonObject bodyJson = new JsonObject();
        bodyJson.addProperty("email", email);
        bodyJson.addProperty("username", username);
        bodyJson.addProperty("password", password);
        bodyJson.addProperty("accepted_terms", "true");
        bodyJson.addProperty("type", "public");
        bodyJson.addProperty("full_name", name);
        RequestBody body = RequestBody.create(mediaType, bodyJson.toString());
        Request request = new Request.Builder()
                .url(BASE_URL + "/auth/register")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = null;
        JsonObject responseJson = null;
        try {
            response = client.newCall(request).execute();
            String jsonString = response.body().string();
            responseJson = JsonParser.parseString(jsonString).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        authToken = responseJson.get("auth_token").getAsString();
        return responseJson;
    }

    public static Response post(String url, JsonObject jsonObject) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonObject.toString());
        Request request = new Request.Builder()
                .url(BASE_URL + url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + authToken)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert response!= null;
        if (!response.isSuccessful()) {
            throw new Error("HTTP error code " + response.code());
        }
        return response;
    }

    public static Response patch(String url, JsonObject jsonObject) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonObject.toString());
        Request request = new Request.Builder()
                .url(BASE_URL + url)
                .patch(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + authToken)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert response!= null;
        if (!response.isSuccessful()) {
            throw new Error("HTTP error code " + response.code());
        }
        return response;
    }

    public static void delete(String url, JsonObject jsonObject) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_URL + url + jsonObject.get("id").getAsString())
                .delete()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + authToken)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert response!= null;
        if (!response.isSuccessful()) {
            throw new Error("HTTP error code " + response.code());
        }
    }

    protected static String getJsonStringFromResponse(Response response) {
        String jsonString =null;
        try {
            jsonString= response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
