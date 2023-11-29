package Tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

// we can update the record partially using patch method
public class PatchApiTest {

    @Test
    public void patchTest()
    {
        baseURI="https://reqres.in/api/users/2";
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","KiniaGupta");

        given()
                .header("Content-Type","application/json")
                .body(jsonObject.toString())
                .when()
                .patch("/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
