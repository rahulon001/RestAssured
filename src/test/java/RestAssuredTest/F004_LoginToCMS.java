package RestAssuredTest;

import Utils.BaseClass;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class F004_LoginToCMS extends BaseClass {
    static SessionFilter sessionFilter = new SessionFilter();


    @Test
    public static String TC004_test_loginToCMS() {
        RestAssured.baseURI = baseURI;
        System.out.println("**** Logging in****");
        Response res =
                 given().urlEncodingEnabled(true).
                        param("username", "super5").
                        param("password", "foobar").
                        header("Content-Type", "application/x-www-form-urlencoded").
                        filter(sessionFilter).
                 when().
                       post("/legacy/login").
                 then().
                        assertThat().statusCode(200).
                 extract().
                         response();
                         return res.getHeader("x-anti-forgery");
    }
}
