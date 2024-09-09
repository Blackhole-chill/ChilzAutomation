package Day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListernerClass implements ITestListener{

	
	public void onStart(ITestContext context) {
	    // onStart() will execute only once before starting all the methods 
		
		System.out.println("Test excecution started");
	  }

	public void onTestStart(ITestResult result) {
	    // onTestStart will execute multiple times for multiple test
		
		System.out.println("Test all methods started");
	  }
	
	public void onTestSuccess(ITestResult result) {

		System.out.println("test passed");
	}
	
	public void onTestFailure(ITestResult result) {

		System.out.println("test failed");
	}
	
	public void onTestSkipped(ITestResult result) {

		System.out.println("test skipped");
	}
	
	public void onFinish(ITestContext context) {
		//onFinish() will execute when all the methods are tested

			System.err.println("test excecution completed");
	}
	
	
}
