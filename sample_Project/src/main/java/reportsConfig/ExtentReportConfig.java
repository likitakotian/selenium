package reportsConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.*;

public class ExtentReportConfig {
	
	static ExtentReports extentReports;
	
	public static ExtentReports getReportObjects() {
		
		String path = System.getProperty("user.dir")+"/reports/index1.html";
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(path);
		extentHtmlReporter.config().setReportName("Webautomation");
		extentHtmlReporter.config().setDocumentTitle("Test results");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("tester", "Likhitha");
		return extentReports;
		
	}

}
