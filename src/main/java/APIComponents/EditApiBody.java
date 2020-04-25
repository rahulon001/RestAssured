package APIComponents;

import Utils.HelperClass;
import org.json.simple.JSONObject;

import static Utils.BaseClass.getRandomBoolean;
import static Utils.BaseClass.getRandomNumber;

public class EditApiBody {
    static JSONObject json = HelperClass.apiBody();
    static long randomNumber = getRandomNumber();

    public static JSONObject merchantBody(){
        JSONObject merchantBody = (JSONObject) json.get("create_merchants");
        merchantBody.put("masID", Long.toString(randomNumber));
        merchantBody.put("name","AutomatedMerchant"+randomNumber);
        merchantBody.put("traits",getRandomBoolean());
        merchantBody.put("isRRMerchant",getRandomBoolean());

        return merchantBody;
    }

}
