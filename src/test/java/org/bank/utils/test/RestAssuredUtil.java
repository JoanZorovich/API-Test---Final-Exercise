package org.bank.utils.test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.bank.model.User;

import java.util.Map;

public class RestAssuredUtil {
    //Sets Base URI
    public static void setBaseURI() {
        RestAssured.baseURI = "https://637bd29d72f3ce38ea95f584.mockapi.io/api/v1/";
    }

    //Sets base path
    public static void setBasePath(String basePathTerm) {
        RestAssured.basePath = basePathTerm;
    }

    //Reset Base URI (after test)
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    //Reset base path
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

    //Sets ContentType
    public static void setContentType(ContentType Type) {
        given().contentType(Type);
    }

    //Returns response by given path
    public static Response getResponse(String path) {
        return given().get(path);
    }

    //Returns response
    public static Response getResponse() {
        return given().when().get();
    }

    public static Response deleteRequest(User user) {
        return given().when().delete("/" + user.getId());
    }

    public static Response postRequest(User user) {
        return given().contentType(JSON).body(user).when().post();
    }

    public static Response putRequest(Map dataChange, User user){
        return given().contentType(JSON).body(dataChange).when().put("/" + user.getId());
    }



    //Returns JsonPath object
    public static JsonPath getJsonPath(Response res) {
        String json = res.asString();
        return new JsonPath(json);
    }
}
