package RestAssuredTest;

import Utils.BaseClass;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static RestAssuredTest.F004_LoginToCMS.sessionFilter;
import static io.restassured.RestAssured.given;

public class F005_LogoutFromCMS extends BaseClass {

//    openssl s_client -showcerts -connect server.edu:443 </dev/null 2>/dev/null|openssl x509 -outform PEM >mycertfile.pem

    @Test
    public static void TC005_test_logoutFromCMS(){
        String xAntiForgery = F004_LoginToCMS.TC004_test_loginToCMS();
        System.out.println(xAntiForgery);
        System.out.println("**** Logging out****");
        RestAssured.baseURI = baseURI;
        RestAssured.useRelaxedHTTPSValidation();
        given().
                filter(sessionFilter).relaxedHTTPSValidation().
                header("x-anti-forgery", xAntiForgery).
        when().
                get("/v1/cms/logout").
        then().
                assertThat().statusCode(200);
    }

    public static void TC005_test_logoutFromCMS(String xAntiForgery){
        RestAssured.baseURI = baseURI;
        System.out.println("**** Logging out****");
        given().relaxedHTTPSValidation().
                filter(sessionFilter).
                header("x-anti-forgery", xAntiForgery).
        when().
                get("/v1/cms/logout").
        then().
                assertThat().statusCode(200);
    }

}