package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Tests_PATCH {

    @Test
    public void test_1() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Bayram-1");
        jsonObject.put("job", "Job-1");

        baseURI = "https://reqres.in";

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .patch("/api/users/2")
                .then()
                .statusCode(200).log().all();

    }
}
