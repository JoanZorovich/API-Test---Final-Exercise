package org.bank.test;

import org.bank.utils.reporter.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyEndpointTest extends BaseTest{
    @Test
    public void emptyEndpointTest(){

        Reporter.info("------------ TEST 1 -----------------");

        Reporter.info("Validate a successful response from the endpoint");
        Assert.assertEquals(checkGetStatus(), 200, "Status Check Failed!");

        Reporter.info("Validate that endpoint is empty - delete existing data");
        Assert.assertTrue(emptyTheEndpoint(),"The endpoint is not empty");


    }
}
