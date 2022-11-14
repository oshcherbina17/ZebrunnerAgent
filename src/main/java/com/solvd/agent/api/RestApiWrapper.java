package com.solvd.agent.api;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.json.JSONObject;

import java.io.IOException;

public class RestApiWrapper {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private static Response postJson(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }

    public static String getAuthToken (String url, String access_token){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("refreshToken", access_token);

        try {
            return new JSONObject(postJson(url, jsonObject.toString()).body().string()).getString("authToken");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
