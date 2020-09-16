package utilities;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportManager {
	
	static ExtentHtmlReporter reporter;
	static final String report_path = System.getProperty("user.dir")+"//Report//index.html";
	static ExtentReports extent;
	
	public static ExtentReports getReport()
	{
		reporter = new ExtentHtmlReporter(report_path);
		reporter.config().setReportName("FlightBooking Automation");
		reporter.config().setDocumentTitle("Automation Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
