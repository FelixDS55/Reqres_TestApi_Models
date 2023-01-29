package tests;

import config.BaseTest;
import config.Spec;
import io.restassured.http.ContentType;
import models.UserResponseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetUserTest extends BaseTest {
    @Test
    void getUserTest(){
        UserResponseModel userResponseModel = new UserResponseModel();
        String firstName = "Janet";
        String lastName = "Weaver";
        Integer id = 2;
        UserResponseModel data = Spec.request
                .when()
                .get("users/2")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(UserResponseModel.class);

        Assertions.assertEquals(id, data.getId());
        Assertions.assertEquals(firstName, data.getFirstName());
        Assertions.assertEquals(lastName, data.getLastName());
    }
}
