package pet.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindByStatusTest {

    private static final String FIND_BY_STATUS_API = "https://petstore.swagger.io/v2/pet/findByStatus?status=";

    @Test
    public void updateExistingPetDetailsForAvailableStatusTest() {

        String testingStatus = "available";

        responseOperationByStatus(testingStatus);
    }

    @Test
    public void updateExistingPetDetailsForDeleteStatusTest() {

        String testingStatus = "delete";

        responseOperationByStatus(testingStatus);
    }

    @Test
    public void updateExistingPetDetailsForSoldStatusTest() {

        String testingStatus = "sold";

        responseOperationByStatus(testingStatus);
    }

    private void responseOperationByStatus(String testingStatus) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(FIND_BY_STATUS_API + testingStatus);

        response.then().statusCode(200);
        Assertions.assertEquals(200, response.statusCode(), "Something went wrong!");
    }
}
