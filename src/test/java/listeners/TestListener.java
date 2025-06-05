package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportManager;
import scripts.BaseTest;
import utils.LoggerUtil;
import utils.ScreenshotUtil;

import java.util.logging.Logger;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerUtil.getLogger("SimpleListener");
    private static final ExtentReports extent = ExtentReportManager.getInstance();
    private static final ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);
        logger.info("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().pass("Test Passed");
        logger.info("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);

        Throwable throwable = result.getThrowable();
        logger.severe("Test failed: " + result.getMethod().getMethodName());
        if (throwable != null) {
            logger.severe("Reason: " + throwable.getMessage());
            test.fail("Test Failed: " + (throwable != null ? throwable.toString() : "No exception message"));
        } else {
            test.fail("Test Failed: No exception message.");
        }

        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
        try {
            testThread.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            logger.warning("Failed to attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        logger.info("Extent report flushed.");
    }
}
