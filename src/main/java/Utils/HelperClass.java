package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class HelperClass {
    static JSONParser parser = new JSONParser();
    static JSONObject json;

    public static JSONObject apiBody()  {
        try {
            json = (JSONObject) parser.parse(new FileReader("src/main/java/Utils/APIBodyTemplates.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(json.get("couponCampaignCreation"));
        return json;
    }

    public static void main(String[] args) {
        apiBody();
    }
}
