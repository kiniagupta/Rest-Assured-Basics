package Tests;

import POJO.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
public class PostApiTest {

    @Test(description = "using JsonObject")
    public void postTest1()
    {
        baseURI="https://reqres.in/api";
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","Kinia");
        jsonObject.put("job","QA");
        given()
                .header("Content-Type","application/json")
                .body(jsonObject.toString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log()
                .all();
    }

    @Test(description = "using HashMap")
    public void postTest2()
    {
        baseURI="https://reqres.in/api";
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("name","Kinia");
        hashMap.put("job","QA Automation Engineer");
        JSONObject jsonObject=new JSONObject(hashMap);
        given()
                .header("Content-Type","application/json")
                .body(jsonObject.toString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log()
                .all();
    }

    @Test(description = "using POJO")
    public void postTest3() throws JsonProcessingException {
        baseURI="https://reqres.in/api";
        User user=new User();
        user.setName("Kinia");
        user.setJob("Tester");

        //Use ObjectMapper
        ObjectMapper objectMapper=new ObjectMapper();
        String requestBody=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        given()
                .header("Content-Type","application/json")
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log()
                .all();

    }
}
