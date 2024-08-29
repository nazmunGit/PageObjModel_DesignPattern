package islahiArtTest;

import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import reusables.testingBase;

public class loginPageTest extends testingBase {
    HomePage homePage;
    AccountPage accountPage;

    @Test
    public void verifyLogin() throws InterruptedException {
        homePage = new HomePage(getDriver());
        homePage.clickAccountButton();
        accountPage = new AccountPage(getDriver());
        accountPage.enterUsername("sarkernazmun@gmail.com");
        accountPage.enterPassword("aBc123456!");
        accountPage.clickSignInButton();

        Thread.sleep(4000);
    }
}
