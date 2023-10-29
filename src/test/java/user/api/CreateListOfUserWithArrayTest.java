package user.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateListOfUserWithArrayTest {

    private static final String GET_LIST_OF_USER = "https://petstore.swagger.io/v2/user/createWithArray";

    @Test
    public void createListOfUserWithArrayTest() {

        String requestBody = """
                [{
                    "id": 1,
                    "username": "Mike",
                    "firstName": "Mike",
                    "lastName": "Wazowski",
                    "email": "wazowski@emailhost.com",
                    "password": "password!",
                    "phone": "100200300",
                    "userStatus": 2
                  }]""";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(GET_LIST_OF_USER);

        response.then().statusCode(200);
        Assertions.assertEquals(200, response.statusCode(), "Something went wrong!");
    }
    @Test
    public void createListOfUserWithoutArrayTest() {

        String requestBody = "{}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(GET_LIST_OF_USER);

        response.then().statusCode(500);
        Assertions.assertEquals(500, response.statusCode(), "Something went wrong!");
    }
}
