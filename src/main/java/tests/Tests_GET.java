package tests;


import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Tests_GET {

    // @Test
    public void test_1() {
        baseURI = "https://reqres.in/api";
        given()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7));
    }

    @Test
    public void test_2() {
        baseURI = "https://reqres.in/api";
        given()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data.first_name[1]", equalTo("Lindsay"));
    }

    @Test
    public void test_3() {

        given()
                .param("Key", "values")
                .header("key", "value")
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log().all()
                .body("data.first_name", hasItems("Michael", "Lindsay"));
    }
}
