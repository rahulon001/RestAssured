package ReportGenerator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.Date;

public class ExtantListener implements ITestListener {
    static String fileName = "Extent_" + new Date().toString().replace(":","_")+".html";

    private static final ExtentReports extent = ExtantManager.createInstance(System.getProperty("user.dir")+"/reports/"+fileName);
    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result){
        ExtentTest test = extent.createTest(result.getTestClass().getName() + "  @TestCase: "+ result.getMethod().getMethodName());
        testReport.set(test);
    }

    public void onTestSuccess(ITestResult result){
        String methodName = result.getMethod().getMethodName();

        String logText = "<b>"+"Test Case:- "+methodName+" PASSED"+"</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(m);

    }

    public void onTestFailure(ITestResult result){
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        testReport.get().fail("<details>"+"<summary>"+"<b>"+"<font color="+"red>"+"Exception occurred:Click to see"
                +"</font>"+ "</b>"+"</summary>"+exceptionMessage.replaceAll(",","<br>")+
                "</details>"+"\n");
        String failureLogs = "TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLogs, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);
    }

    public void onTestSkipped(ITestResult result){
        String methodName = result.getMethod().getMethodName();

        String logText = "<b>"+"Test Case: -"+methodName+" SKIPPED"+"</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.BLUE);
        testReport.get().skip(m);
    }

    public void onFinish(ITestContext iTestContext) {
        extent.flush();
    }
}
