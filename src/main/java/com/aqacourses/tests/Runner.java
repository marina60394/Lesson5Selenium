package com.aqacourses.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Marina on 10.02.2019.
 */
public class Runner {

    public static void main(String[] args) {

        // We can run test in that way
        Result result = JUnitCore.runClasses(SearchGoogleTest.class);

        // And then work with the result
        if (result.wasSuccessful()) {
            // Print some messages
            System.out.println("Success!");
        } else {
            // Or work with failures
            for (Failure failure : result.getFailures()) {
                System.err.println("Exception - " + failure.getException());
                System.err.println("Trace - " + failure.getTrace());
            }

        }

    }
}