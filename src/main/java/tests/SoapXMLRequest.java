package tests;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SoapXMLRequest {

    @Test
    public void validateSoapXml() throws IOException {
        File file = new File("./SoapRequest/add.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
        baseURI = "https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code";
        given()
                .contentType("text/xml")
                .accept(ContentType.XML)
                .body(requestBody)
                .when()
                .post("/calcWebService/Calc.asmx?WSDL").then().statusCode(200).log().all()
                .and().body("//*:AddResult.text()", equalTo("6"));

    }
}
