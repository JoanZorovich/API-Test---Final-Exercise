package org.bank.test;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.bank.utils.test.TestUtil;
import org.bank.utils.test.RestAssuredUtil;



public class BaseTest {

    public Response res = null; //Response
    public JsonPath jp  = null; //JsonPath

    //Instantiate a Helper Test Methods (testUtils) Object
    TestUtil testUtil = new TestUtil();

    @BeforeTest
    public void setup() {
        //Test Setup
        RestAssuredUtil.setBaseURI(); //Setup Base URI
        RestAssuredUtil.setBasePath("users"); //Setup Base Path
        RestAssuredUtil.setContentType(ContentType.JSON); //Setup Content Type
    }

    @AfterTest
    public void afterTest() {
        //Reset Values
        RestAssuredUtil.resetBaseURI();
        RestAssuredUtil.resetBasePath();
    }
}
