package sample;

import javafx.scene.control.TextField;
import com.google.gson.*;

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
        JsonParser parser = new JsonParser();
        JsonElement traindata = parser.parse(JsonString);
        JsonArray responseData = traindata.getAsJsonArray();

        //JsonArray arr = new JsonArray(traindata);
        //List<String> list = new ArrayList<String>();
        //for(int i = 0; i < arr.size(); i++){
        //    list.add(arr.getJsonObject(i).getString("from"));
        //}

        JsonObject connections = new Gson().fromJson(responseData.get(0), JsonObject.class);
        JsonObject from = new Gson().fromJson(connections.get("arrival"), JsonObject.class);
        from.toString();
        System.out.println(from);



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
