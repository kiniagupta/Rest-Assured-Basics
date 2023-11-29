package Tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ValidateJSONSchema {

    @Test
    public void validateJSONTest() {
        baseURI = "https://reqres.in/api";
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log()
                .all()
                .body(matchesJsonSchemaInClasspath("schema.json"));

    }
}
