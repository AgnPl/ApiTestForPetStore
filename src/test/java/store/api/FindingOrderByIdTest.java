package store.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindingOrderByIdTest {

    private final static String FINDING_ORDER_BY_ID = "https://petstore.swagger.io/v2/store/order/";

    @Test
    public void findingOrderById() {

        int orderId = 8;

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(FINDING_ORDER_BY_ID + orderId);

        response.then().statusCode(200);
        Assertions.assertEquals(200, response.statusCode(), "Something went wrong!");
    }
}
