package islahiArtTest;

import org.testng.annotations.Test;
import pages.BestSellingShoppingCart;
import reusables.testingBase;

public class addViewingCartTest extends testingBase {

    BestSellingShoppingCart bestSellingPage;

    @Test
    public void verifyAddToCart() throws InterruptedException {
        bestSellingPage = new BestSellingShoppingCart(getDriver());
        Thread.sleep(2000);
        bestSellingPage.clickBestSellinglink();
        Thread.sleep(2000);
        bestSellingPage.take_screenshot();
        bestSellingPage.clickSquareFrame();
        Thread.sleep(2000);
        bestSellingPage.take_screenshot();
        bestSellingPage.clickfAddToCartButton();
        bestSellingPage.take_screenshot();
        Thread.sleep(2000);
        bestSellingPage.clickBestSellinglink();
        bestSellingPage.clickKidsTee();
        // bestSellingPage.clickfAddtoWishlist();
        // bestSellingPage.clickWishlistButton();
        Thread.sleep(2000);
        bestSellingPage.take_screenshot();
        bestSellingPage.clicktAddToCartButton();
        bestSellingPage.clickShoppingCartButton();
        //bestSellingPage.take_screenshot();
        Thread.sleep(3000);
        bestSellingPage.take_screenshot();
    }
}
