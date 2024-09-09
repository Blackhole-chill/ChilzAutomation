package Day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListenerClass implements ITestListener{
	
	//main 3 classes of Extent Report
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; //populates common information on the report

	public ExtentTest test; //creating test case entries in report & updating the status in the report


	
	
	public void onStart(ITestContext context) { //trigger, starts execution
		
		
		//UI of the report
		sparkReporter =new ExtentSparkReporter(System.getProperty("user.dir")+"reports/myReport.html"); //location of the report
		
		sparkReporter.config().setDocumentTitle("Automation Report"); // Title of the report
		sparkReporter.config().setReportName("Functional Testing");   // Name of the Report
		sparkReporter.config().setTheme(Theme.DARK); // Theme of the Report
		
		
		//populates common information on the report
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Compurt Name", "localhost");
		extent.setSystemInfo("Enviornment", "QA");
		extent.setSystemInfo("Tester Name", "Pavan");
		extent.setSystemInfo("os", "Windows10");
		extent.setSystemInfo("Browser", "Chrome");
		
	}
		
		public void onTestSuccess(ITestResult result) { //whenever a test() is passed, then onTestSuccess() is triggered
		    
			test = extent.createTest(result.getName()); //creating a new entry in report through extent
			test.log(Status.PASS, "Test case PASSED is:"+result.getName()); //update status - passed/failed/skip
			
		  }
		
		public void onTestFailure(ITestResult result) {

			test= extent.createTest(result.getName());
			test.log(Status.FAIL, "Test case failed is: "+ result.getName());
			test.log(Status.FAIL, "Test case failed cause is: "+ result.getThrowable());

		}
		
		public void onTestSkippec(ITestResult result) {
		    
			test = extent.createTest(result.getName());
			test.log(Status.SKIP, "Test case Skipped is:"+result.getName());
			
		  }
		
		public void onFinish(ITestContext context) {
		    
			extent.flush(); // will update whole thing in the report
			
		  }
		
	}
	

