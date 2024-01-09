package Jarvis_API.Spree.spree.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class barertoken {
    static  String Access_Token;
    @Test
    public static  String AccessToken() throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        FileReader reader = new FileReader("src/test/TestData/Tokendata.json");

        Object obj = parser.parse(reader);

        JSONObject prodjsonobj=(JSONObject)obj;

        Response response=RestAssured.given()
                .contentType(ContentType.JSON)
                .body(prodjsonobj)
                .post("https://demo.spreecommerce.org/spree_oauth/token")
                .then()
                .extract()
                .response();
        response.getBody().prettyPrint();

        String responseBody=response.getBody().asString();
        System.out.println(responseBody);

        //jsp
        JsonPath jsonPath=new JsonPath(responseBody);

        Access_Token = jsonPath.getString("access_token");
        System.out.println("Token is==>"+Access_Token);
        return Access_Token;
    }

}
