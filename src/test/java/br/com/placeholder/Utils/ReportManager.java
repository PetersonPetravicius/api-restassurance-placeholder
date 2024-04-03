package br.com.placeholder.Utils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void init(String filePath) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(filePath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void flush() {
        extent.flush();
    }
}