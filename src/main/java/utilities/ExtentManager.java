package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    public static ExtentReports extent;
    public static ExtentSparkReporter htmlReporter;
    //to create unique report
    public static ExtentReports createInstance() throws IOException {
        String repname="TestReport-"+ getTimeStamp() +".html";
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+repname);
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\extent-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //optional..the following 4 lines.
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Host Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Nexxvali");
        return extent;
    }
    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }

}
