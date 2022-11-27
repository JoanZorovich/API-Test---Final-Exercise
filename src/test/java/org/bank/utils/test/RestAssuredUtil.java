package org.bank.utils.test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.bank.model.User;

import java.util.Map;

/**
 * class to configure and define rest assured requests, path and URI
 * @author joan.zorovich
 */

public class RestAssuredUtil {


    /**
     * Sets Base URI
     * @author joan.zorovich
     */
    public static void setBaseURI() {
        RestAssured.baseURI = "https://637bd29d72f3ce38ea95f584.mockapi.io/api/v1/";
    }

    /**
     * Sets Base path
     * @author joan.zorovich
     */
    public static void setBasePath(String basePathTerm) {
        RestAssured.basePath = basePathTerm;
    }

    /**
     * Sets Base URI (after test)
     * @author joan.zorovich
     */
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    /**
     * Reset base path
     * @author joan.zorovich
     */
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

    /**
     * Sets ContentType
     * @author joan.zorovich
     */
    public static void setContentType(ContentType Type) {
        given().contentType(Type);
    }

    /**
     * @author joan.zorovich
     * @param path: end point path
     * @return response by given path
     */
    public static Response getResponse(String path) {
        return given().get(path);
    }

    /**
     * @author joan.zorovich
     * @return get response
     */
    public static Response getResponse() {
        return given().when().get();
    }

    /**
     * @author joan.zorovich
     * @param user: current bank user
     * @return get response
     */
    public static Response deleteRequest(User user) {
        return given().when().delete("/" + user.getId());
    }

    /**
     * @author joan.zorovich
     * @param user: current bank user
     * @return post response
     */
    public static Response postRequest(User user) {
        return given().contentType(JSON).body(user).when().post();
    }

    /**
     * @author joan.zorovich
     * @param dataChange: map with the data to change
     * @param user: user whose data is modified
     * @return put response
     */
    public static Response putRequest(Map dataChange, User user){
        return given().contentType(JSON).body(dataChange).when().put("/" + user.getId());
    }



    /**
     * @author joan.zorovich
     * @param res: response
     * @return JsonPath object
     */
    public static JsonPath getJsonPath(Response res) {
        String json = res.asString();
        return new JsonPath(json);
    }
}
