package org.bank.utils.reporter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reporter class to configure and customize log information
 * @author joan.zorovich
 */

public class Reporter {
    /**
     * Constructor method for reporter object
     */
    public Reporter() {}


    /**
     * gets the logger according to the parameterized class
     * @author joan.zorovich
     * @return logger
     */
    private static Logger getLogger(){
        return LoggerFactory.getLogger(Reporter.class);
    }

    /**
     * Display information in the console about the test
     * @author joan.zorovich
     * @param text: string according to test message
     */
    public static void info(String text){
        getLogger().info(text);
    }

    /**
     * Display error messages in the console about the test
     * @author joan.zorovich
     * @param text: string according to error message
     */
    public static void error(String text){
        getLogger().error(text);
    }


    /**
     * Display warning messages in the console about the test
     * @author joan.zorovich
     * @param text: string according to warning message
     */
    public static void warning(String text){
        getLogger().warn(text);
    }

}
