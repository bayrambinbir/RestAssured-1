package tests;

import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasItems;

public class JSONSchemaValidatorTests {
    @Test
    public void test_1() {
        baseURI = "https://reqres.in/api";
        given()
                .get("/users?page=2")
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200)
                .body("data.first_name", hasItems("Michael", "Lindsay"));
    }
}
