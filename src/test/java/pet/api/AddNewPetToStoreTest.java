package pet.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddNewPetToStoreTest {

    public static final String POST_API_URL = "https://petstore.swagger.io/v2/pet";

    @Test
    public void addNewPetToStoreApiTest() {

        String requestBody = """
                {
                  "id": 11,
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
                .post(POST_API_URL);

        response.then().statusCode(200);
        Assertions.assertEquals(200, response.getStatusCode(), "Something went wrong!");
    }

    @Test
    public void addNewPetToStoreWithoutRequiredId() {

        //sending empty id when int required

        String requestBody = """
                {
                  "id": "''",
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

        responseOperation(requestBody);
    }

    @Test
    public void addNewPetToStoreWithIncorrectId() {

        //sending string as id when int required

        String requestBody = """
                {
                  "id": "TestId",
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

        responseOperation(requestBody);
    }

    @Test
    public void addNewPetToStoreWithIncorrectTypeInNameTest() {

        //sending empty id when int required

        String requestBody = """
                {
                  "id": "''",
                  "category": {
                    "id": 0,
                    "name": "Max"
                  },
                  "name": "123",
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

        responseOperation(requestBody);
    }

    private void responseOperation(String requestBody) {
        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post(POST_API_URL);
        response.then().statusCode(500);
        Assertions.assertEquals(500, response.getStatusCode(), "Didn't get expected error!");
    }
}


