package Tests;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

// to create api locally we have to use json-server library of node
public class TestOnLocalAPIs {

    @Test
    public void get()
    {
        baseURI="http://localhost:3000";
        given().get("/users").then().statusCode(200).log().all();
    }

    @Test
    public void post()
    {
        baseURI="http://localhost:3000";
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstName","Thomas");
        jsonObject.put("lastName","Edison");
        jsonObject.put("subjectId",2);

        given()
                .header("content-type","application/json")
                .body(jsonObject.toString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log()
                .all();
    }

    @Test
    public void put()
    {
        baseURI="http://localhost:3000";
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstName","Albert");
        jsonObject.put("lastName","Einstein");
        jsonObject.put("subjectId",1);

        given()
                .header("content-type","application/json")
                .body(jsonObject.toString())
                .when()
                .put("/users/4")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void patch()
    {
        baseURI="http://localhost:3000";
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstName","Albert");
        jsonObject.put("lastName","Doe");
        jsonObject.put("subjectId",1);

        given()
                .header("content-type","application/json")
                .body(jsonObject.toString())
                .when()
                .patch("/users/4")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void delete()
    {
        baseURI="http://localhost:3000";
        given()
                .when()
                .delete("/users/4")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
