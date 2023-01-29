package tests;

import config.BaseTest;
import config.Spec;
import io.restassured.http.ContentType;
import models.LoginRequestModel;
import models.LoginResponseModel;

import static io.restassured.RestAssured.baseURI;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

import static io.restassured.RestAssured.given;

public class LoginTest extends BaseTest {
    @Test
    void loginTest(){
        LoginRequestModel data = new LoginRequestModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");

        LoginResponseModel response = Spec.request
        .given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"))
                .extract().as(LoginResponseModel.class);

        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }
}
