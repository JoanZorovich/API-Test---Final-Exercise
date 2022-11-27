package org.bank.test;

import org.bank.utils.reporter.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostUsersTest extends BaseTest{
    @Test
    public void createTenUsersTest(){
        Reporter.info("------------ TEST 2 -----------------");

        Reporter.info("validate that all users are created successfully");
        Assert.assertTrue(postUsers(),"User post fails!");



    }
}
