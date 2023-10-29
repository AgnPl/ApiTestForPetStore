package pet.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdatePetIdTest {

    private static final String UPDATE_PET_ID_API = "https://petstore.swagger.io/v2/pet/";

    @Test
    public void updatePetIdTest() {

        String requestBody = """
                {
                  "id": "11",
                  "category": {
                    "id": 0,
                    "name": "Ciapek"
                  },
                  "name": "The Small Dog",
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
                .post(UPDATE_PET_ID_API);

        response.then().statusCode(200);
        Assertions.assertEquals(200, response.statusCode(), "Something went wrong!");
    }


    @Test
    public void updatePetIdWithIncorrectInputTest() {

        String requestBody = """
                {
                  "id": "TEST",
                  "category": {
                    "id": 0,
                    "name": "Ciapek"
                  },
                  "name": "The Small Dog",
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
                .post(UPDATE_PET_ID_API);

        response.then().statusCode(500);
        Assertions.assertEquals(500, response.statusCode(), "Something went wrong!");
    }
}

