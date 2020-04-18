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

//    @AfterTest
//    public void endReport(){
//        extent.flush();
//    }

//    @Test
//    public void doLogin(){
//        test = extent.createTest("Login Test");
//        System.out.println("Executing login test");
//    }
//    @Test
//    public void doUserReg(){
//        test = extent.createTest("User registration test");
//        Assert.fail("User reg failed." );
//    }
//    @Test
//    public void isSkippedTest(){
//        test = extent.createTest("Skip test");
//        throw new SkipException("Skip Test");
//    }

//    @AfterMethod
//    public void tearDownMethod(ITestResult result){
//        if (result.getStatus() == ITestResult.FAILURE){
//            String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
//            test.fail("<details>"+"<summary>"+"<b>"+"<font color="+"red>"+"Exception occurred:Click to see"
//                    +"</font>"+ "</b>"+"</summary>"+exceptionMessage.replaceAll(",","<br>")+
//                    "</details>"+"\n");
//            String failureLogs = "TEST CASE FAILED";
//            Markup m = MarkupHelper.createLabel(failureLogs, ExtentColor.RED);
//            test.log(Status.FAIL, m);
//
//        }else if (result.getStatus() == ITestResult.SKIP){
//            String methodName = result.getMethod().getMethodName();
//
//            String logText = "<b>"+"Test Case: -"+methodName+" SKIPPED"+"</b>";
//            Markup m = MarkupHelper.createLabel(logText, ExtentColor.BLUE);
//            test.skip(m);
//
//        }else if (result.getStatus() == ITestResult.SUCCESS){
//            String methodName = result.getMethod().getMethodName();
//
//            String logText = "<b>"+"Test Case: -"+methodName+" PASSED"+"</b>";
//            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//            test.pass(m);
//
//        }


