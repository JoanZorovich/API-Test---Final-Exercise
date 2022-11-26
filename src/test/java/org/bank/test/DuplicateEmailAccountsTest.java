package org.bank.test;

import org.bank.utils.reporter.Reporter;
import org.testng.annotations.Test;

public class DuplicateEmailAccountsTest {
    @Test
    public void avoidDuplicateEmailsTest(){
        Reporter.info("Validate that there are no duplicate emails in the data");
        Reporter.info("Validate if there are more than 10 users created");
    }
}
