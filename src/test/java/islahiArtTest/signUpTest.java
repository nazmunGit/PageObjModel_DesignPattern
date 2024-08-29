package islahiArtTest;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;
import reusables.testingBase;

public class signUpTest extends testingBase {
    HomePage homePage;
    SignUpPage signUp;

    @Test
    public void verifySignup() throws InterruptedException {
        homePage = new HomePage(getDriver());
        homePage.clickAccountButton();
        signUp = new SignUpPage(getDriver());
        signUp.clickSignUpTab();
        signUp.enterEmail("sarkernazmun@gmail.com");
        signUp.enterFirstName("Nazmun");
        signUp.enterLastName("Sarker");
        signUp.enterPasswoed("aBc123456!");
        signUp.enterCofirmPassword("aBc123456!");
        signUp.clickCheckBox();
        signUp.clickSignUpButton();

        Thread.sleep(5000);
    }

}
