package ReportGenerator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtantManager {

    public static ExtentReports createInstance(String filename){

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Rest_Assured_Automation_Report");
        htmlReporter.config().setReportName("Automation_Test_Results");
        htmlReporter.config().setTheme(Theme.DARK);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Environment", "SIT");
        extent.setSystemInfo("Automation Tester", "Rahul Ranjan");
        extent.setSystemInfo("organization", "Reliance");
        extent.setSystemInfo("Automation Project", "Coupon management system");

        return extent;
    }
}

