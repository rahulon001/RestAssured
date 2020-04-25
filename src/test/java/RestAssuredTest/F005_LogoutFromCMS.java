package RestAssuredTest;

import Utils.BaseClass;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static RestAssuredTest.F004_LoginToCMS.sessionFilter;
import static io.restassured.RestAssured.given;

public class F005_LogoutFromCMS extends BaseClass {
    static Logger log = Logger.getLogger(F005_LogoutFromCMS.class);
//    openssl s_client -showcerts -connect server.edu:443 </dev/null 2>/dev/null|openssl x509 -outform PEM >mycertfile.pem

    @Test
    public void TC001_test_logoutFromCMS(){
        String xAntiForgery = F004_LoginToCMS.TC001_test_loginToCMS();
        System.out.println(xAntiForgery);
        log.info("*************logout from CMS*************");
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

    public static void TC001_test_logoutFromCMS(String xAntiForgery){
        RestAssured.baseURI = baseURI;
        log.info("*************logout from CMS*************");
        given().relaxedHTTPSValidation().
                filter(sessionFilter).
                header("x-anti-forgery", xAntiForgery).
        when().
                get("/v1/cms/logout").
        then().
                assertThat().statusCode(200);
    }

}
