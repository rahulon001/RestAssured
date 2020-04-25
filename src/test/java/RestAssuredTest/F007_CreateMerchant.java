package RestAssuredTest;

import APIComponents.EditApiBody;
import Utils.BaseClass;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static RestAssuredTest.F004_LoginToCMS.sessionFilter;
import static io.restassured.RestAssured.given;

//import org.json.simple.JSONObject;

public class F007_CreateMerchant extends BaseClass {
    public String xAntiForgery = F004_LoginToCMS.TC001_test_loginToCMS();
    JSONObject merchantBody = EditApiBody.merchantBody();

    @Test
    public void TC001_test_createMerchant(){
        RestAssured.baseURI = baseURI;
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2"+merchantBody);

        given().
                filter(sessionFilter).
                header("Content-Type","multipart/form-data").
                header("x-anti-forgery", xAntiForgery).
                multiPart("M.jpg", "images/M.jpg","image/jpg").
//                multiPart(merchantBody).
        when().
                post("/v1/cms/merchant /581/coupon").
        then().
                assertThat().statusCode(200);

        F005_LogoutFromCMS.TC001_test_logoutFromCMS(xAntiForgery);
    }
}
