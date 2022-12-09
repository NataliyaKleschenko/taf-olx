package by.itacademy.kleschenko.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class APITest {
    @Test
    void testGetLanguage() {
        String endPoint = "https://www.olx.pl/api/partner/languages";
        given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer 8916a7c267c3159641cdfb913d05d1064fe684fc")
                .header("Version", "2.0")
                .when()
                .get(endPoint)
                .then().statusCode(200)
                .body("data.code", is("pl"));
    }

    //{
    //"data": {
    //"id": 87,
    //"name": "Moda",
    //"parent_id": 0,
    //"photos_limit": 8,
    //"is_leaf": false
    //}
    //}
    @Test
    void testGetModa() {
        String endPoint = "https://www.olx.pl/api/partner/categories/87";
        String data = "";
        int id = 87;
        String name = "Moda";
        int parent_id = 0;
        int photos_limit = 8;
        boolean is_leaf = false;
        String request = String.format("{\"data\":\"%s\",\"id\":\"%s\",\"name\":\"%s\",\"parent_id\":\"%s\",\"photos_limit\":\"%s\",\"is_leaf\":\"%s\"}",data, id, name,parent_id,photos_limit,is_leaf);
     Response response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer 8916a7c267c3159641cdfb913d05d1064fe684fc")
                .header("Version", "2.0")
                .body(request)
                .when()
                .get(endPoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("id"), "8");
        Assert.assertEquals(response.jsonPath().getString("name"), "Moda");

    }
    @Test
    void testGetAttributes() {
        String endPoint = "https://www.olx.pl/api/partner/categories/87/attributes";
        given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer 8916a7c267c3159641cdfb913d05d1064fe684fc")
                .header("Version", "2.0")
                .when()
                .get(endPoint)
                .then().statusCode(200)
                .body("data.code", is("pl"));
    }

}
