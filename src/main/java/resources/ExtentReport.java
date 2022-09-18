package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	static ExtentReports extent;
	public static ExtentReports getExtentReport() {
		
		String path = System.getProperty("user.dir")+"/report/"+"extentrport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Test");
		reporter.config().setDocumentTitle("Web Automation Test");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test", "Istiaq firoz");
		return extent;
	}
}
