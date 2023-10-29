package pet.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindPetIdTest {

    private static final String FIND_PET_ID_API = "https://petstore.swagger.io/v2/pet/";

    @Test
    public void findPetIdTest() {

        int petId = 11;

        responseOperationById(petId);
    }

    @Test
    public void findPetIdTestWithNotExistingId() {

        int petId = 5;

        responseOperationById(petId);
    }

    private void responseOperationById(int petId) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(FIND_PET_ID_API + petId);

        response.then().statusCode(200);
        Assertions.assertEquals(200, response.statusCode(), "Something went wrong!");
    }
}
