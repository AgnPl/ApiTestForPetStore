package store.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlacingAnOrderTest {

    private final static String PLACING_ORDER_APi = "https://petstore.swagger.io/v2/store/order";

    @Test
    public void placingAnOrderTest() {

        String requestBody = """
                {
                  "id": 11,
                  "petId": 2,
                  "quantity": 1,
                  "shipDate": "2023-10-28T21:27:35.699Z",
                  "status": "placed",
                  "complete": true
                }""";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(PLACING_ORDER_APi);

        response.then().statusCode(200);
        Assertions.assertEquals(200, response.statusCode(), "Something went wrong!");
    }

    @Test
    public void placingAnOrderWithoutBodyTest() {

        String requestBody = "";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(PLACING_ORDER_APi);

        response.then().statusCode(400);
        Assertions.assertEquals(400, response.statusCode(), "Something went wrong!");
    }
}
