package RestAssuredTest;

import Utils.BaseClass;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class F001_GetCoupon extends BaseClass {

    @Test(dataProvider = "get_coupon")
    public static void TC001_test_getCouponAPI(String version, String clientType){
        RestAssured.baseURI = baseURI;

        given().
                param("version", version).param("start", 0).param("end", 1000).param("lat",19.1275).param("lng", 73.0076).
                header("x-client-type",clientType).header("x-loginid", "7021150333").
        when().
                get("/coupons/v1/coupons/").
        then().
                assertThat().statusCode(200).body(matchesJsonSchemaInClasspath("json-schemas/GetCouponResponseSchemas.json")).log().all();

    }

    @Test(dataProvider = "get_applicable_coupon")
    public static void TC002_test_getApplicableCouponsForMerchant(String path, int status){
        RestAssured.baseURI = baseURI;

        given().

        when().
                get(path).
        then().
                assertThat().statusCode(status).log().all();

    }

    @Test(dataProvider = "searchCoupons")
    public static void TC003_test_searchCoupons(String query, String version, String clientType){
        RestAssured.baseURI = baseURI;

        given().
                param("version", version).param("source", "all").param("start", 1).
                param("end", 1000).param("lat",19.1275).param("lng", 73.0076).
                param("format", "group").param("categoryId", "1").
                param("reductionType", "2").param("query", query).
                header("x-client-type",clientType).header("x-loginid", "7021150333").
        when().
                get("/coupons/v1/coupons/").
        then().
                assertThat().statusCode(200).body(matchesJsonSchemaInClasspath("json-schemas/GetCouponResponseSchemas.json")).log().all();
//        extract()
//        extract the response
    }

    @DataProvider(name = "get_coupon")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { "v5", "myjio" },
                { "v4", "microsite"},
                { "v4", "jiomoney"},
                { "v5", "RJIL_JioKart"}
        };
    }

    @DataProvider(name = "get_applicable_coupon")
    public Object[][] dataProviderMethod1() {
        return new Object[][] {
                { "/coupons/v1/coupons/merchant/1901000067818", 200 },
                { "/coupons/v1/coupons/merchant/", 404},
                { "/coupons/v1/coupons/1901000067818", 404},
                { "/coupons/v1/coupons/test", 404}
        };
    }

    @DataProvider(name = "searchCoupons")
    public Object[][] dataProviderMethod2() {
        return new Object[][] {
                { "off", "v5", "myjio"},
                { "off", "v4", "microsite"}
        };
    }


}
