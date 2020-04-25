package RestAssuredTest;

import Utils.BaseClass;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Test
public class F004_LoginToCMS extends BaseClass {
    static Logger log = Logger.getLogger(F004_LoginToCMS.class);
    static SessionFilter sessionFilter = new SessionFilter();
    public static String TC001_test_loginToCMS() {
        RestAssured.baseURI = baseURI;
        log.info("*************logging into CMS*************");
        Response res =
                 given().
                         urlEncodingEnabled(true).
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
