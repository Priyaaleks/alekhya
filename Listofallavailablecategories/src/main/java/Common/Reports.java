package Common;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {

	private static ExtentReports report;
	private static ExtentTest test;
	
	
	public static void initializereport() {
		report = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\report.html");
	}
	
	public static void AddTestToReport(String methodName) {
		test = report.startTest(methodName);
	}
	
	public static void closereport() {
		report.endTest(test);
	}
	
	public static void flushreport() {
		report.flush();
	}
	
	public static void PASS(String message) {
		test.log(LogStatus.PASS, message);
	}
	
	public static void FAIL(String message) {
		test.log(LogStatus.FAIL, message);
		
	}
	
	public static void INFO(String message) {
		test.log(LogStatus.INFO, message);
	}
	
public static String takesnapshot(WebDriver driver, String screenshotname) {
		
		
		TakesScreenshot scrshot = (TakesScreenshot) (driver);
		File srcfile = scrshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"//Screenshots//"+screenshotname+".png";
		File destfile = new File(destination);
		
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (Exception e) {
			System.out.println("screenshot capture is failed");
			e.printStackTrace();
		}
		
		return destination;
		
	}
}
