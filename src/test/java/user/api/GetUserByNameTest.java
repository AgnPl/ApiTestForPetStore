package user.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetUserByNameTest {
    private static final String GET_USER_BY_NAME = "https://petstore.swagger.io/v2/user/";
    @Test
    public void getUserByName() {

        String requestBody = "Legolas";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .get(GET_USER_BY_NAME + requestBody);

        response.then().statusCode(200);
        Assertions.assertEquals(200, response.statusCode(), "Something went wrong!");
    }

    @Test
    public void getUserByNotExistingName() {

        String requestBody = "Gimli";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .get(GET_USER_BY_NAME + requestBody);

        response.then().statusCode(404);
        Assertions.assertEquals(404, response.statusCode(), "Something went wrong!");
    }
}
