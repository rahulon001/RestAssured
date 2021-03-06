package RestAssuredTest;


import Utils.BaseClass;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static RestAssuredTest.F004_LoginToCMS.sessionFilter;
import static io.restassured.RestAssured.given;

public class F006_CreateCoupons extends BaseClass {
    public String xAntiForgery = F004_LoginToCMS.TC001_test_loginToCMS();

    @Test
    public void TC001_test_createCoupons(){
        RestAssured.baseURI = baseURI;

        given().
                filter(sessionFilter).
                header("Content-Type","multipart/form-data").
                header("x-anti-forgery", xAntiForgery).
                multiPart("M.jpg", "images/M.jpg","image/jpg").
        when().
                post("/v1/cms/merchant/581/coupon").
        then().
                assertThat().statusCode(200);

        F005_LogoutFromCMS.TC001_test_logoutFromCMS(xAntiForgery);
    }
}
