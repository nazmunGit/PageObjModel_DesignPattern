package reusables;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;


public class basePage {
    static String ssLocation = "screenshots/ss"+ System.currentTimeMillis()+".png";

    private static final Logger logger = LogManager.getLogger(basePage.class);
    protected WebDriver driver;

    public basePage (WebDriver driver){
        this.driver = driver;
    }
    public void take_screenshot(){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE), new File(ssLocation));
        } catch (Exception e) {
           // throw new RuntimeException(e);
            logger.error(e.getMessage());
        }

    }
    public void sendKeys (WebElement element, String text) {
        try {
            element.sendKeys(text);
        } catch (Exception e){
            take_screenshot();
            logger.error(e.getMessage());
        }

    }
    public void click (WebElement element) {
        try {
            take_screenshot();
            element.click();
            logger.info("Screenshot taken...");

        } catch (Exception e){
            take_screenshot();
            logger.error(e.getMessage());
        }

    }
}
