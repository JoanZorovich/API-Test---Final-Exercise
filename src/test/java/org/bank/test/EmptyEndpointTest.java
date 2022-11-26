package org.bank.test;

import org.bank.utils.test.RestAssuredUtil;
import org.bank.utils.reporter.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyEndpointTest extends BaseTest{
    @Test
    public void emptyEndpointTest(){

        Reporter.info("Validate a successful response from the endpoint");
        Assert.assertEquals(checkStatus(), 200, "Status Check Failed!");

        Reporter.info("Validate that endpoint is empty - delete existing data");
        Assert.assertTrue(emptyTheEndpoint(),"The endpoint is not empty");
    }
}
