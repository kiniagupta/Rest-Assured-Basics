package Tests;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class DeleteApiTest {

    @Test
    public void deleteTest()
    {
        baseURI="https://reqres.in/api";
        given()
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204)
                .log()
                .all();
    }
}
