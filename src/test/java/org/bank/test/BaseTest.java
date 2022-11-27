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

/**
 * Base class for all API tests
 * @author joan.zorovich
 */

public class BaseTest {

    public Response res = null; //Response
    public JsonPath jp  = null; //JsonPath

    private int userAmount = 10;

    /**
     * Set up of before and after tests
     */

    @BeforeTest
    /**
     * Set up the Base URI, Base Path and Content Type before every test
     * @author joan.zorovich
     */
    public void setup() {
        RestAssuredUtil.setBaseURI();
        RestAssuredUtil.setBasePath("users");
        RestAssuredUtil.setContentType(ContentType.JSON);
    }

    @AfterTest
    public void afterTest() {
        /**
         * Reset the Base URI and Base Path and after every test
         * @author joan.zorovich
         */
        RestAssuredUtil.resetBaseURI();
        RestAssuredUtil.resetBasePath();
    }

    /**
     *Check the status code response
     * @author joan.zorovich
     * @return integer with the status code
     *
     */
    protected int checkGetStatus(){
        res = RestAssuredUtil.getResponse();
        return res.getStatusCode();
    }

    /**
     * Get all users of the end point
     * @author joan.zorovich
     * @return a list with all users
     *
     */
    protected List<User> getAllUsers(){
        res = RestAssuredUtil.getResponse();
        jp = RestAssuredUtil.getJsonPath(res);
        return jp.getList("", User.class);
    }

    /**
     * Delete each user from the end point
     * @author joan.zorovich
     * @return true if the end point is empty, otherwise false.
     *
     */
    protected boolean emptyTheEndpoint(){
        List<User> users = getAllUsers();
        users.forEach(user -> {
            RestAssuredUtil.deleteRequest(user);
        });
        return getAllUsers().size()==0;
    }

    /**
     *Create users using fake information
     * @author joan.zorovich
     * @param usersAmount: number of users to create
     * @return a list of fake users created
     */
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

    /**
     * create the user in the end point only if his/her email is unique
     * @author joan.zorovich
     * @return true if all users were successfully created, otherwise false.
     */
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

    /**
     * @author joan.zorovich
     * @return if no email in the endpoint is repeated, otherwise false.
     */
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

    /**
     * Create a random index in order to pick a ransom user
     * @author joan.zorovich
     * @return a random user of the end point
     */
    protected User pickRandomUser(){
        List<User> users = getAllUsers();
        Random randomIndex = new Random();
        int index = randomIndex.nextInt(users.size());
        return users.get(index);
    }

    /**
     * Create a fake number using javaFaker
     * @author joan.zorovich
     * @return a fake account number
     */
    protected int randomAccountNumber(){
        Faker fake = Faker.instance(Locale.forLanguageTag("en-US"));
        return fake.number().numberBetween(1,999999);
    }

    /**
     * Update the account number of a user that is already created in the endpoint
     * @author joan.zorovich
     * @param randomUser: user randomly obtained from endpoint
     * @param newAccountNumber: fake number obtained from javaFaker
     */
    protected void updateAccountNumber(User randomUser, int newAccountNumber){
        Map<String, Integer> user = new HashMap<>();
        user.put("accountNumber", newAccountNumber);
        res = RestAssuredUtil.putRequest(user,randomUser);
    }

    /**
     * Searches for the user whose account number was modified and compares
     * whether the current account number is equal to the new account number
     * @author joan.zorovich
     * @return true if the new account number is actually present in the chosen user, otherwise false.
     */
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
