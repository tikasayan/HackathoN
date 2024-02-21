package utilityFiles;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import org.apache.poi.sl.draw.geom.Context;
import org.testng.ITestContext;
 
import org.testng.ITestListener;
 
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
 
import com.aventstack.extentreports.ExtentTest;
 
import com.aventstack.extentreports.Status;
 
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
import com.aventstack.extentreports.reporter.configuration.Theme;
 
import testBase.BaseClass;
public class ExtentReportManager extends BaseClass implements ITestListener{
 
	public ExtentSparkReporter sparkReporter;  // UI of the report
 
	public ExtentReports extent;  //populate common info on the report
 
	public ExtentTest test; // creating test case entries in the report and update status of the test methods
	String reportName;
 

	public void onStart(ITestContext context) {
 
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName);
 
		sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
 
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
 
		sparkReporter.config().setTheme(Theme.DARK);				// Theme of the report
 
		extent=new ExtentReports();
 
		extent.attachReporter(sparkReporter);
 
		extent.setSystemInfo("Computer Name","HP ELITEBOOK");
 
		extent.setSystemInfo("Environment","Coursera Automation");
 
		extent.setSystemInfo("Tester Name","Sayantika Dholey(2303453)");
 
		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("operating System", os);
 
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("operating System", browser);
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
 
	}

	public void onTestSuccess(ITestResult result) {
 
		test = extent.createTest(result.getName()); // create a new enty in the report
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		try {
			String imagePath = new ScreenShots(driver).screenshot(result.getName());
			test.addScreenCaptureFromPath(imagePath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
 
	}
	public void onTestFailure(ITestResult result) {
 
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
 
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
 
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
 
	}
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
 
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
 
	}

 
	public void onFinish(ITestContext testContext) {
 
		    	extent.flush();
 
		    	String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+reportName;
 
		    	File extentReport = new File(pathOfExtentReport);
 
		    	try {
 
		    		Desktop.getDesktop().browse(extentReport.toURI());
 
		    	}catch(IOException e) {
 
		    		e.printStackTrace();
 
		    	}
 
		    }
 
}