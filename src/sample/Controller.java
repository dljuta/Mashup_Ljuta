package sample;

import javafx.scene.control.TextField;
import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public TextField from;
    public TextField to;
    public TextField abfahrtszeit;
    public TextField ankunftszeit;

    public void getData() throws Exception {
        //2. Convert object to JSON string and save into a file directly
        String JsonString = getHTML("http://transport.opendata.ch/v1/connections?from=Winterthur&to=Stettbach").replace(" ", "");
        //JsonParser parser = new JsonParser();
        //JsonElement traindata = parser.parse(JsonString);
        //JsonArray responseData = traindata.getAsJsonArray();
        JSONObject myjson;
        try
        {
            myjson = new JSONObject(JsonString);
            JSONObject jsonObj1 = myjson.getJSONObject("station");
            System.out.println(jsonObj1.getJSONObject("name"));
            System.out.println("here ===>>>"+jsonObj1.getJSONObject("name").get("$t").toString());
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        //JsonArray arr = new JsonArray(traindata);
        //List<String> list = new ArrayList<String>();
        //for(int i = 0; i < arr.size(); i++){
        //    list.add(arr.getJsonObject(i).getString("from"));
        //}



    }
        public String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

}
