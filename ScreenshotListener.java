package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((TestBase) currentClass).driver;

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String testName = result.getName();
            String filePath = "screenshots/" + testName + "_" + timestamp + ".png";

            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(src.toPath(), Paths.get(filePath));
            System.out.println("Screenshot saved: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
