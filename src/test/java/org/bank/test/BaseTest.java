package org.bank.test;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.bank.model.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.bank.utils.test.RestAssuredUtil;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class BaseTest {

    public Response res = null; //Response
    public JsonPath jp  = null; //JsonPath


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

    protected int checkStatus(){
        res = RestAssuredUtil.getResponse();
        return res.getStatusCode();
    }

    protected List<User> getAllUsers(){
        res = RestAssuredUtil.getResponse();
        jp = RestAssuredUtil.getJsonPath(res);
        return jp.getList("", User.class);
    }

    protected boolean emptyTheEndpoint(){
        List<User> users = getAllUsers();
        users.forEach(user -> {
            RestAssuredUtil.deleteRequest(user);
        });
        return getAllUsers().size()==0;
    }


    protected ArrayList<User> createFakeUsers(int usersAmount){
        ArrayList<User> fakeUsers= new ArrayList<>();
        Faker fake = Faker.instance(Locale.forLanguageTag("en-US"));

        for (int i = 0; i < usersAmount; i++) {
            fakeUsers.add(new User(
                    fake.name().firstName(),
                    fake.name().lastName(),
                    fake.number().numberBetween(1,999999),
                    fake.number().randomDouble(2, 10, 100000000),
                    fake.options().option("invoice","withdrawal","deposit","payment"),
                    fake.internet().emailAddress(),
                    fake.random().nextBoolean(),
                    fake.country().name(),
                    fake.phoneNumber().phoneNumber()
            ));
        }
        return fakeUsers;
    }

    protected void postUsers(int usersAmount){
        ArrayList<User> users = createFakeUsers(usersAmount);
        users.forEach(RestAssuredUtil::postRequest);
    }

    protected void postUsers(){
        ArrayList<User> users = createFakeUsers(10);
        users.forEach(user -> {
            System.out.println(user);
            RestAssuredUtil.postRequest(user);
        });
    }

}
