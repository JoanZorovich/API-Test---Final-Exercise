package org.bank.test;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.bank.model.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.bank.utils.test.RestAssuredUtil;
import com.github.javafaker.Faker;

import java.util.*;


public class BaseTest {

    public Response res = null; //Response
    public JsonPath jp  = null; //JsonPath

    private int userAmount = 10;


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

    protected int checkGetStatus(){
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


    protected boolean postUsers(){
        List<String> emailAccounts = new ArrayList<>();
        List<Integer> userPostStatus = new  ArrayList<>();
        List<User> users = createFakeUsers(userAmount);
        users.forEach(user -> {
            if(!emailAccounts.contains(user.getEmail())){
                emailAccounts.add(user.getEmail());
                userPostStatus.add(RestAssuredUtil.postRequest(user).getStatusCode());
            }
        });
        return !userPostStatus.contains(400);
    }

    protected boolean checkDuplicateUsersEmail(){
        List<String> emailAccounts = new ArrayList<>();
        List<User> users = getAllUsers();
        users.forEach(user -> {
            if(!emailAccounts.contains(user.getEmail())){
                emailAccounts.add(user.getEmail());
            }
        });
        return emailAccounts.size() == users.size();
    }


    protected User pickRandomUser(){
        List<User> users = getAllUsers();
        Random randomIndex = new Random();
        int index = randomIndex.nextInt(users.size());
        return users.get(index);
    }

    protected int randomAccountNumber(){
        Faker fake = Faker.instance(Locale.forLanguageTag("en-US"));
        return fake.number().numberBetween(1,999999);
    }

    protected void updateAccountNumber(User randomUser, int newAccountNumber){
        Map<String, Integer> user = new HashMap<>();
        user.put("accountNumber", newAccountNumber);
        res = RestAssuredUtil.putRequest(user,randomUser);
    }

    protected boolean isAnUpdatedAccountNumber(){
        User randomUser= pickRandomUser();
        int newAccountNumber = randomAccountNumber();
        updateAccountNumber(randomUser,newAccountNumber);

        List<User> allUser = getAllUsers();
        int index = allUser.indexOf(randomUser);
        User userToValidate = allUser.get(index);

        return userToValidate.getAccountNumber() == newAccountNumber;
    }

}
