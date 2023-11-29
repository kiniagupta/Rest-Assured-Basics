package Tests;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
public class GetApiTest {

    @Test(description = "Validate the status code of the get api")
    public void getApi()
    {
        baseURI="https://reqres.in/api";
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void validatePageNumber()
    {
        baseURI="https://reqres.in/api";
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log()
                .all()
                .body("page",equalTo(1));
    }

    @Test
    public void validateId()
    {
        baseURI="https://reqres.in/api";
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log()
                .all()
                .body("data[0].id",equalTo(1));
    }
}
