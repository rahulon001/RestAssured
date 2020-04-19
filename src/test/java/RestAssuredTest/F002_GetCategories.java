package RestAssuredTest;

import Utils.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class F002_GetCategories extends BaseClass {

    @Test
    public static void TC001_test_GetCategories(){
        RestAssured.baseURI = baseURI;
        Response res =
                given().
                        param("version", "v5").param("client", "myjio").
                        header("x-loginid", "7021150333").
                when().
                        get("/coupons/v1/coupons/categories").
                then().
                        assertThat().statusCode(200).
                extract().response();
        String response = res.asString();
        JsonPath jsonResponse = new JsonPath(response);
        String placeID = jsonResponse.getString("categories[0]");
        System.out.println(placeID);;
    }
}
