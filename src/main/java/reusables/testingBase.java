package reusables;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utilities.ListenerUtils;

@Listeners(ListenerUtils.class)
public class testingBase {
    static final String CHROME_DRIVER = "webdriver.chrome.driver";
    static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
    private static final Logger logger = LogManager.getLogger(testingBase.class);
    protected static WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeTest
    public WebDriver testDriver(String browser, String url) throws Exception {
        logger.info("Setting up Browser !!!");
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Unsupported browser: "+ browser);
        }
        logger.info("Opening Browser !!");
        driver.manage().window().maximize();
        driver.get(url);
        logger.info("Test Setup Done !");
        return  driver;
    }
    @AfterTest
    public void closeBrowser(){
        logger.info("Closing Browser !!!");
        if(driver != null){
            driver.quit();
        }
        logger.info("Test Completed !!!");
    }
    public WebDriver getDriver(){
        return driver;
    }
}
