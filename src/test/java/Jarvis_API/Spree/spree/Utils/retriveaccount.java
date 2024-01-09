package Jarvis_API.Spree.spree.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class retriveaccount {
@Test
    public void retriveac() throws IOException, ParseException {
        Response response = RestAssured.given()
                .auth()
                .oauth2(barertoken.AccessToken())
                .get("https://demo.spreecommerce.org/api/v2/storefront/account")
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




    Map<String,String> content1=response.jsonPath().getJsonObject("data.attributes");

    String email1=content1.get("email");
    System.out.println(email1);
    Assert.assertEquals(email1,"jarvisapi1@spree.com");
    System.out.println("my email id="+email1);



    }
}
