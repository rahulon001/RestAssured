package RestAssuredTest;

import Utils.BaseClass;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static RestAssuredTest.F004_LoginToCMS.sessionFilter;
import static io.restassured.RestAssured.given;

public class F003_CreateBrand extends BaseClass {

    public static String xAntiForgery = F004_LoginToCMS.TC001_test_loginToCMS();

    @Test
    public static void TC001_test_createBrand(){
        RestAssured.baseURI = baseURI;
        given().
                filter(sessionFilter).
                header("Content-Type","multipart/form-data").
                header("x-anti-forgery", xAntiForgery).
                multiPart("M.jpg", "../java/Utils/images/M.jpg","image/jpg").
                multiPart("name", "test_brand").multiPart("desc", "Test_DESC").
                multiPart("externalId", "Test183234_ID").multiPart("userGroup","42").
        when().
                post("/v1/cms/brands/").
        then().
                assertThat().statusCode(200).log().all();

        F005_LogoutFromCMS.TC001_test_logoutFromCMS(xAntiForgery);
    }
}
