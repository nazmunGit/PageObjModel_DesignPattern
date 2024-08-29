package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import reusables.basePage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CheckOutPage extends basePage {
    private final By viewShoppingCartLocator = By.xpath("//div[contains(text(),'Shopping Cart')]");
    //private final By viewCartButtonLocator= By.xpath("(//span[@class='ast-icon icon-bag'])[1]");
    private final By viewCartButtonLocator= By.xpath("//body/div[@id='page']/div[@id='astra-mobile-cart-drawer']/div[2]/div[1]/div[1]/p[2]/a[1]");
    private final By clickCheckOutButtonLocator = By.xpath(" /html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]");
   // private final By clickCheckOutButtonLocator = By.xpath("//div[@id='cpsw-payment-request-custom-button']");
    private final By fnameTextBoxLocator = By.xpath("//input[@id='billing_first_name']");
    private final By lnameTextBoxLocator = By.xpath("//input[@id = 'billing_last_name']");
    private final By addressTextBoxLocator = By.xpath("//input[@id = 'billing_address_1']");
    private final By cityTextBoxLocator = By.xpath("//input[@id = 'billing_city']");
    private final By dropDownLocator = By.xpath("(//span[@class='select2-selection__arrow'])[1]");
    private final By dropDownMenuLocator = By.xpath("//select[@id='billing_state']/option");
    private final By zipCodeTextBoxLocator= By.xpath("//input[@id='billing_postcode']");
    private final By phoneTextBoxLocator = By.xpath("//input[@id='billing_phone']");
    private final By emailTextBoxLocator = By.xpath("//input[@id='billing_email']");
    private final By clickCheckBoxLocator = By.xpath("//input[@id='terms']");
    private final By paynowButtonLocator = By.xpath("//button[@id='place_order']");
    //private final By cardNumberTextBoxLocator = By.xpath("//input[@name='cardnumber']");
    //private final By cardExpDateLocator = By.xpath("//input[@name='exp-date']");
   // private final By cvcLocator = By.xpath("//input[@name='cvc']");
    private final By radioButtonLocator= By.xpath("//input[@id ='payment_method_klarna_payments_pay_over_time']");
    private final By item1QuantityLocator= By.xpath("//tbody/tr[1]/td[1]/strong[1]");
    private final By item1PriceLocator = By.xpath("//tbody/tr[1]/td[2]/span[1]/bdi[1]");
    private final By item2QuantityLocator= By.xpath("//tbody/tr[2]/td[1]/strong[1]");
    private final By item2PriceLocator = By.xpath("//tbody/tr[2]/td[2]/span[1]/bdi[1]");
    private final By totalPriceLocator= By.xpath("(//span[@class='woocommerce-Price-amount amount'])[3]");
    private final By buttonContinueLocator = By.xpath("//button[@id='onContinue']");

    private static final Logger logger = LogManager.getLogger(BestSellingShoppingCart.class);

    public CheckOutPage(WebDriver driver){
        super(driver);
    }

    public void clickShoppingCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewShoppingCart = driver.findElement(viewCartButtonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewShoppingCart);
        logger.info("Showing the items in the cart ...");
        click(viewShoppingCart);
    }
    public void verifyShoppingCart(){
      assertEquals(driver.getTitle(),"Cart - Islahi Art");
    }
    public void clickCheckOutButton(){
        //Actions act = new Actions(driver);
        try{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewCheckOut = driver.findElement(clickCheckOutButtonLocator);
        // Scroll to the element
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCheckOut);
        logger.info("Going to check out items ...");
       //Actions act = new Actions(driver);
       //act.moveToElement(viewCheckOut).perform();
        click(viewCheckOut);
        take_screenshot();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void enterFirstname(String firstname){
        WebElement firstnameTextBox = driver.findElement(fnameTextBoxLocator);
        logger.info("Inserting firstname "+ firstname);
        sendKeys(firstnameTextBox, firstname);
    }
    public void enterLastname(String lastname){
        WebElement lastnameTextBox = driver.findElement(lnameTextBoxLocator);
        logger.info("Inserting lastname "+lastname);
        sendKeys(lastnameTextBox, lastname);
    }
    public void enterAddress(String address){
        WebElement addressTextBox = driver.findElement(addressTextBoxLocator);
        logger.info("Inserting address");
        sendKeys(addressTextBox, address);
    }
    public void enterCityname(String cityname){
        WebElement citynameTextBox = driver.findElement(cityTextBoxLocator);
        logger.info("Inserting cityname");
        sendKeys(citynameTextBox, cityname);
    }
    public void clickState(String statename){
        WebElement stateDropDown = driver.findElement(dropDownLocator);
        logger.info("selecting state from dropdown menu..");
        click(stateDropDown);
        List<WebElement> dropDownMenu =driver.findElements(dropDownMenuLocator);
        for(WebElement element :dropDownMenu){
            String innerHtml = element.getAttribute("innerHTML");
            if (innerHtml.contentEquals("Texas")){
                element.click();
                break;
            }
        }


    }
    public void enterZipcode(String zipcode){
        try {
            WebElement zipTextBox = driver.findElement(zipCodeTextBoxLocator);

            sendKeys(zipTextBox, zipcode);
            logger.info("Inserting zipcode");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void enterPhoneNum(String phonenum){
        WebElement phonenumTextBox = driver.findElement(phoneTextBoxLocator);
        logger.info("Inserting phone number.");
        sendKeys(phonenumTextBox,phonenum);
    }
    public void enterEmail(String email){
        WebElement emailTextBox = driver.findElement(emailTextBoxLocator);
        logger.info("Inserting email address: "+email);
        sendKeys(emailTextBox, email);
    }
    public void clickCheckBox(){
        WebElement checkBoxConsent = driver.findElement(clickCheckBoxLocator);
        checkBoxConsent.click();
    }
    public void radioButtonPaymentMethod(){
        WebElement paymentChoice = driver.findElement(radioButtonLocator);
        paymentChoice.click();
    }
    public void payNowButtonClick() throws InterruptedException {
        WebElement payNowButton= driver.findElement(paynowButtonLocator);
        payNowButton.click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("alert('Checkout is completed!')");
//        Thread.sleep(3000);
//        take_screenshot();
//        driver.switchTo().alert().accept();
        //driver.get("src/main/java/pages/msgPopupCheckoutTest.html");
        //driver.get("C:\\Users\\shimu\\IdeaProjects\\PageObjectModel_DesignPattern\\src\\main\\java\\pages");
        //Switch to the alert box
        //String alertText = driver.switchTo().alert().getText();
         //Verify the alert text
        //Assert.assertEquals(alertText, "alert('Checkout is completed!')");
        // Accept the alert to close it
       //driver.switchTo().alert().accept();
      // take_screenshot();
    }
    public void displayMsg(){
        try {
            //WebElement btnCont = driver.findElement(buttonContinueLocator);
            //Actions actions = new Actions(driver);
            //actions.doubleClick(btnCont).perform();
            //driver.get("./src/main/java/pages/msgPopupCheckoutTest.html");
            //driver.get("C:\\Users\\shimu\\IdeaProjects\\PageObjectModel_DesignPattern\\src\\main\\java\\pages\\msgPopupCheckoutTest.html");

            // Use JavaScript to display an alert box with a message
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('Checkout is completed!')");

            //take_screenshot();
            // Wait for a few seconds to see the alert (optional)
            Thread.sleep(3000);
            //take_screenshot();
            // Accept the alert (close it)
            driver.switchTo().alert().accept();
            //actions.doubleClick(btnCont).perform();
            //Switch to the alert box
//            String alertText = driver.switchTo().alert().getText();
//            //Verify the alert text
//            Assert.assertEquals(alertText, "Checkout is complete!!!");
//            //take_screenshot();
//            // Accept the alert to close it
//            driver.switchTo().alert().accept();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void verifyPrice1() {
        WebElement priceItem1 = driver.findElement(item1PriceLocator);
        //WebElement numItem1 = driver.findElement(item1QuantityLocator);
        Float item1 = Float.parseFloat(priceItem1.getText().substring(1));
        //double item1Total = item1 * numItem1.getText();
        WebElement priceItem2 = driver.findElement(item2PriceLocator);
        Float item2 = Float.parseFloat(priceItem2.getText().substring(1));
        Float totalItemPrice= item1+item2;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String foramtedExpectedTotalPrice= decimalFormat.format(totalItemPrice);
        WebElement total= driver.findElement(totalPriceLocator);
        Float totalPrice= Float.parseFloat(total.getText().substring(1));
        String foramtedActualTotalPrice= decimalFormat.format(totalPrice);
        Assert.assertEquals(foramtedExpectedTotalPrice, foramtedActualTotalPrice,"The total price is incorrect ");
    }

}
