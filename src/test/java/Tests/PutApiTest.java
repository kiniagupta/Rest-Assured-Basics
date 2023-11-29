package Tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
// we cannot update the record partially using put method, to partially update we have to use patch method

public class PutApiTest {

    @Test
    public void putTest()
    {
        baseURI="https://reqres.in/api/users/2";
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","Kinia");
        jsonObject.put("job","Tester Profile");

        given()
                .header("Content-Type","application/json")
                .body(jsonObject.toString())
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
