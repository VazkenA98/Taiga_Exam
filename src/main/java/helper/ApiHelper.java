package helper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class ApiHelper {

    public static JsonObject login(String username, String password)  {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"username\": \"" + username + ","+ "password:"+password+"\"\n}");
        Request request = new Request.Builder()
                .url(" https://tree.taiga.io/login?next=%252Fproject%252Fuxbox%252Ftimeline")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonParser.parseString(jsonString).getAsJsonObject();
    }
}
