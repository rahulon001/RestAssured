package APIComponents;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestCalls {
    public static Response GETRequest(String URI){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.get(URI);
    }

    public static Response POSTRequest(String URI, String strJson){
        RequestSpecification requestSpecification = RestAssured.given().body(strJson);
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.post(URI);
    }

    public static Response PUTRequest(String URI, String strJson){
        RequestSpecification requestSpecification = RestAssured.given().body(strJson);
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.put(URI);
    }

    public static Response DELETERequest(String URI, String strJson){
        RequestSpecification requestSpecification = RestAssured.given().body(strJson);
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.delete(URI);
    }
}
