package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusables.basePage;

public class SignUpPage extends basePage {
    private final By signUpTabLocator = By.xpath("(//li[@data-tab = 'register'])[1]");
    private final By emailTextBoxLocator = By.xpath("(//input[@name = 'xoo_el_reg_email'])[1]");
    private final By firstNameTextBoxLocator = By.xpath("(//input[@name = 'xoo_el_reg_fname'])[1]");
    private final By lastNameTextBoxLocator = By.xpath("(//input[@name = 'xoo_el_reg_lname'])[1]");
    private final By pwdTextBoxLocator = By.xpath("(//input[@name = 'xoo_el_reg_pass'])[1]");
    private final By confirmPwdTextBoxLocator = By.xpath("(//input[@name = 'xoo_el_reg_pass_again'])[1]");
    private final By signUpButtonLocator = By.xpath("(//button[(text() ='Sign Up')])[1]");
    private final By checkBoxLocator = By.xpath("(//input[@name = 'xoo_el_reg_terms'])[1]");
    private static final Logger logger = LogManager.getLogger(SignUpPage.class);
    public SignUpPage(WebDriver driver){
        super(driver);
    }
    public void clickSignUpTab(){
        WebElement signUpTab = driver.findElement(signUpTabLocator);
        logger.info("Clicking on SIGN UP tab");
        click(signUpTab);
    }
    public void enterEmail(String email){
        WebElement emailTextBox = driver.findElement(emailTextBoxLocator);
        logger.info("Inserting email address!!1");
        sendKeys(emailTextBox, email);
    }
    public void enterFirstName(String fname){
        WebElement firstNameTextBox = driver.findElement(firstNameTextBoxLocator);
        logger.info("Inserting first name!!2");
        sendKeys(firstNameTextBox, fname);
    }
    public void enterLastName(String lname){
        WebElement lastNameTextBox = driver.findElement(lastNameTextBoxLocator);
        logger.info("Inserting last name!!3");
        sendKeys(lastNameTextBox, lname);
    }
    public void enterPasswoed(String pwd){
        WebElement pwdTextBox = driver.findElement(pwdTextBoxLocator);
        logger.info("Inserting password!!4");
        sendKeys(pwdTextBox, pwd);
    }
    public void enterCofirmPassword(String cpwd){
        WebElement pwdConfirmTextBox = driver.findElement(confirmPwdTextBoxLocator);
        logger.info("Inserting confirm password!!5");
        sendKeys(pwdConfirmTextBox, cpwd);
    }
    public void clickCheckBox(){
        WebElement checkBox = driver.findElement(checkBoxLocator);
        logger.info("Clicking terms and conditions..");
        click(checkBox);
    }
    public void clickSignUpButton(){
        WebElement signUpButton = driver.findElement(signUpButtonLocator);
        logger.info("Clicking on SIGN UP button");
        click(signUpButton);
    }
}
