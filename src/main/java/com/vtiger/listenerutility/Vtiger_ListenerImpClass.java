package com.vtiger.listenerutility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.threadutility.UtilityClassObject;
import com.vtiger.webdriver_java_listener_utility.VtigerBaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Date;

public class Vtiger_ListenerImpClass implements ITestListener, ISuiteListener {
    public ExtentSparkReporter spark;
    public static ExtentReports report;
    public ExtentTest test;
    @Override
    public void onTestFailure(ITestResult result) {
        //WebDriver sdriver= UtilityClassObject.getDriver();
        WebDriver sdriver= VtigerBaseClass.sdriver;
        String testName = result.getName();
        if (sdriver!=null) {
            TakesScreenshot ts = (TakesScreenshot) sdriver;
            String src = ts.getScreenshotAs(OutputType.BASE64);
            String time = new Date().toString().replace(" ", "_").replace(":", "_");
            test.addScreenCaptureFromBase64String(src, testName + time);
        }
        else System.out.println("sdriver is null");
    }

    @Override
    public void onStart(ISuite suite) {
        String suitename=suite.getName();
        spark=new ExtentSparkReporter("./AdvanceReports/"+suitename+".html");
        spark.config().setDocumentTitle("Vtiger Suite Report");
        spark.config().setTheme(Theme.STANDARD);
        report=new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("OS","Windows-11");
        report.setSystemInfo("Browser","Chrome-113");

    }

    @Override
    public void onFinish(ISuite suite) {
        report.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getName();
        test=report.createTest(methodName);
    }
}
