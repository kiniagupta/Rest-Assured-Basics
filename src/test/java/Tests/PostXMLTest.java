package Tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.*;
public class PostXMLTest {

    @Test
    public void postTest() throws IOException {
        baseURI="https://ecs.syr.edu";
        File file=new File("./src/test/java/SOAPRequest/Add.xml");
        FileInputStream fileInputStream=new FileInputStream(file);
        String requestBody= IOUtils.toString(fileInputStream,"UTF-8");
        given()
                .header("Content-Type","text/xml")
                .body(requestBody)
                .when()
                .post("/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx?op=Add")
                .then()
                .statusCode(200)
                .log()
                .all()
                .body("//AddResult.text()",equalTo("5"));
    }
}
