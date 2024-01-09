package Jarvis_API.Spree.spree;


import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class createac {
@Test
    public void createaccount() throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        FileReader reader = new FileReader("src/test/TestData/Accountdetails.json");

        Object obj = parser.parse(reader);

         JSONObject prodjsonobj=(JSONObject)obj;

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(prodjsonobj)
                .post("https://demo.spreecommerce.org/api/v2/storefront/account")
                .then()
                .extract()
                .response();

        response.getBody().prettyPrint();

        // Conect body
        String responseBody=response.getBody().asString();
        System.out.println(responseBody);

        //jsp
        JsonPath jsonPath=new JsonPath(responseBody);

        String data = jsonPath.getString("data");
        System.out.println(data);




    }
}
