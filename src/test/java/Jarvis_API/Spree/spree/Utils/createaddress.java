package Jarvis_API.Spree.spree.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class createaddress {
@Test
    public static void createnewadress() throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        FileReader reader = new FileReader("src/test/TestData/Addresdetails.json");

        Object obj = parser.parse(reader);

        JSONObject prodjsonobj=(JSONObject)obj;



        Response response = RestAssured.given()
                .auth()
                .oauth2(barertoken.AccessToken())
                .contentType(ContentType.JSON)
                .body(prodjsonobj)
                .post("https://demo.spreecommerce.org/api/v2/storefront/account/addresses")
                .then()
                .extract()
                .response();

        // Conect body
        String responseBody=response.getBody().asString();
        System.out.println(responseBody);

        //jsp
        JsonPath jsonPath=new JsonPath(responseBody);

        String data = jsonPath.getString("data");
        System.out.println(data);




      /*  Map<String,String> content1=response.jsonPath().getJsonObject("data.attributes");

        String email1=content1.get("email");
        System.out.println(email1);
        Assert.assertEquals(email1,"jarvisapi1@spree.com");
        System.out.println("my email id="+email1);*/

    }
}
