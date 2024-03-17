package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Tests_POST {
    @Test
    public void test_1_post() {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", "Bayram");
        map.put("job", "Binbir");

        System.out.println("map " + map);

//        JSONObject request = new JSONObject();
//
//        request.put("name", "Bayram");
//        request.put("job", "King");
//
//        System.out.println("request " + request);
//        System.out.println(request.toJSONString());
//
//        given().
//                header("Content-Type", "application/json").
//                contentType(ContentType.JSON).
//                accept(ContentType.JSON).
//                body(request.toJSONString()).
//                when().
//                        post("https://reqres.in/api/users").
//                then().
//                statusCode(201).log().body();

        JSONObject request = new JSONObject();
        request.put("name", "Miray");
        request.put("job", "King");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201).log().body();
    }


    //@Test
    public void test_2_put() {

        JSONObject request = new JSONObject();

        request.put("name", "Bayram");
        request.put("job", "King");

        System.out.println("request " + request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users").
                then().
                statusCode(200);
    }

    //@Test
    public void test_3_patch() {

        JSONObject request = new JSONObject();

        request.put("name", "Bayram");
        request.put("job", "King");

        System.out.println("request " + request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("https://reqres.in/api/users").
                then().
                statusCode(200).
                log().all();
    }

    //  @Test
    public void test_4_delete() {
        when().
                delete("https://reqres.in/api/users/2").
                then().
                statusCode(204).
                log().all();
    }
}
