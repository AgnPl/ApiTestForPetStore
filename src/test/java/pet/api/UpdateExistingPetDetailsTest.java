package pet.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateExistingPetDetailsTest {

    private static final String UPDATE_EXISTING_PET_API = "https://petstore.swagger.io/v2/pet";

    @Test
    public void updateExistingPetDetailsTest() {

        String requestBody = """
                {
                  "id": "0",
                  "category": {
                    "id": 0,
                    "name": "Max"
                  },
                  "name": "The Dog",
                  "photoUrls": [
                    "string"
                  ],
                  "tags": [
                    {
                      "id": 0,
                      "name": "York Breed"
                    }
                  ],
                  "status": "available"
                }""";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(UPDATE_EXISTING_PET_API);

        response.then().statusCode(200);
        Assertions.assertEquals(200, response.statusCode(), "Something went wrong!");
    }

    @Test
    public void updateExistingPetDetailsWithIncorrectIdTest() {

        //sending update for not existing pet

        String requestBody = """
                {
                  "id": "TEST",
                  "category": {
                    "id": 0,
                    "name": "Mike"
                  },
                  "name": "The Puddle",
                  "photoUrls": [
                    "string"
                  ],
                  "tags": [
                    {
                      "id": 0,
                      "name": "Chow-Chow"
                    }
                  ],
                  "status": "available"
                }""";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(UPDATE_EXISTING_PET_API);

        response.then().statusCode(500);
        Assertions.assertEquals(500, response.statusCode(), "Something went wrong!");
    }
}
