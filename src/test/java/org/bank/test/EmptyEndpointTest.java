package org.bank.test;

import org.bank.utils.test.RestAssuredUtil;
import org.bank.utils.reporter.Reporter;
import org.testng.annotations.Test;

public class EmptyEndpointTest extends BaseTest{
    @Test
    public void getUsersTest(){
        Reporter.info("Fist TEST: Empty Endpoint");
        res = RestAssuredUtil.getResponse();
        testUtil.checkStatusIs200(res);
        jp = RestAssuredUtil.getJsonPath(res);
        System.out.println(testUtil.getUsers(jp));
    }
}
