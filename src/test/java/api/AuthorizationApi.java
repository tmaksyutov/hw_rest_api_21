package api;

import static io.restassured.RestAssured.given;

public class AuthorizationApi {
    public final static String ALLURE_TESTOPS_SESSION = "ALLURE_TESTOPS_SESSION";

    public String getXsrfToken(String token) {
        return given()
                .formParam("grant_type", "apitoken")
                .formParam("scope", "openid")
                .formParam("token", token)
                .when()
                .post("/api/uaa/oauth/token")
                .then()
                .statusCode(200)
                .extract()
                .path("jti");
    }

    public String getAuthorizationCookie(String token, String userName, String password) {
        String xsrfToken = getXsrfToken(token);

        return given()
                .header("X-XSRF-TOKEN", xsrfToken)
                .header("Cookie", "XSRF-TOKEN=" + xsrfToken)
                .formParam("username", userName)
                .formParam("password", password)
                .when()
                .post("/api/login/system")
                .then()
                .statusCode(200).extract().response()
                .getCookie(ALLURE_TESTOPS_SESSION);
    }
}
