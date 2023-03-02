package org.sampleframework;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runclasses {

	public static void main(String[] args) {
		Result runClasses = JUnitCore.runClasses(FacebookLogin.class);
       List<Failure> failures = runClasses.getFailures();
       for(Failure f:failures) {
    	   String message = f.getMessage();
    	   System.out.println(message);
       }
       boolean wasSuccessful = runClasses.wasSuccessful();
       System.out.println("Success: " +wasSuccessful);
	}

}
