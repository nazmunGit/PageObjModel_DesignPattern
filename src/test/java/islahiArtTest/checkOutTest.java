package islahiArtTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import reusables.testingBase;

public class checkOutTest extends testingBase {
    CheckOutPage checkoutItems;
    //WebDriver driver;
    @Test
    public void verifyCheckOut() throws InterruptedException {
        checkoutItems = new CheckOutPage(getDriver());
        Thread.sleep(2000);
        checkoutItems.clickShoppingCartButton();

        checkoutItems.verifyShoppingCart();
        Thread.sleep(2000);
       // checkoutItems.take_screenshot();
        checkoutItems.clickCheckOutButton();
        //Thread.sleep(2000);
      // checkoutItems.take_screenshot();
       checkoutItems.enterFirstname("apple");
       checkoutItems.enterLastname("xyz");
       checkoutItems.enterAddress("2801 E Whitestone Blvd");
       checkoutItems.enterCityname("Cedar Park");
       //checkoutItems.clickState("Texas");

       checkoutItems.enterZipcode("78613");
       checkoutItems.enterPhoneNum("(512) 690-9340");
       checkoutItems.enterEmail("xyz@gmail.com");
       checkoutItems.radioButtonPaymentMethod();
       checkoutItems.clickCheckBox();
        checkoutItems.clickState("Texas");
        Thread.sleep(2000);
        checkoutItems.verifyPrice1();
        //checkoutItems.take_screenshot();

       checkoutItems.payNowButtonClick();

        //Thread.sleep(1000);
        checkoutItems.displayMsg();
        checkoutItems.take_screenshot();
        //Thread.sleep(2000);

       // Thread.sleep(2000);
        //checkoutItems.take_screenshot();






    }
}
