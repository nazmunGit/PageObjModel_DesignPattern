package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusables.basePage;

public class AccountPage extends basePage {
    private final By usernameTextBoxLocator = By.xpath("(//input[(@placeholder='Username / Email')])[1]");
    private final By passwordTextBoxLocator = By.xpath("(//input[(@placeholder='Password')])[1]");
    private final By signInButtonLocator = By.xpath("(//button[(text() ='Sign in')])[3]");

    private static final Logger logger = LogManager.getLogger(AccountPage.class);
    public AccountPage(WebDriver driver){
        super(driver);
    }
    public void enterUsername(String username){
        WebElement usernameTextBox = driver.findElement(usernameTextBoxLocator);
        logger.info("Inserting username");
        sendKeys(usernameTextBox, username);

    }
    public void enterPassword(String password){
        WebElement passwordTextBox = driver.findElement(passwordTextBoxLocator);
        logger.info("Inserting password");
        sendKeys(passwordTextBox, password);

    }
    public void clickSignInButton(){
        WebElement signInButton = driver.findElement(signInButtonLocator);
        logger.info("Clicking on sign in button");
        click(signInButton);
    }

}
