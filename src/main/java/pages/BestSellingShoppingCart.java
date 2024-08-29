package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusables.basePage;

public class BestSellingShoppingCart extends basePage {
    private final By bestSellingTabLocator = By.xpath("//a[text()='Best Selling']");
    private final By squareFrameLinkLocator = By.xpath("(//h2[@class='woocommerce-loop-product__title'])[1]");
    private final By faddToCartButtonLocator = By.xpath("//button[@value='9292']");
    private final By faddToWishlistButtonLocator = By.xpath("(//span[text()='Add To Wishlist'])[6]");
    private final By kidsTeeLinkLocator = By.xpath("//h2[text()='Kids Comfortable Cotton Tee']");
    private final By ktaddToCartButtonLocator = By.xpath("//button[@class='single_add_to_cart_button button alt'][text()='Add to cart']");
    private final By ktaddToWishlistButtonLocator = By.xpath("(//span[text()='Add To Wishlist'])[1]");
    private final By viewCartButtonLocator= By.xpath("(//span[@class='ast-icon icon-bag'])[1]");
    private final By viewWishlistButtonLocator = By.xpath("(//span[@class = 'wlfmc-counter-number products-counter-number position-top-left'])[1]");

    private static final Logger logger = LogManager.getLogger(BestSellingShoppingCart.class);

    public BestSellingShoppingCart(WebDriver driver){
        super(driver);
    }
    public void clickBestSellinglink(){
        WebElement bestSellingLink = driver.findElement(bestSellingTabLocator);
        logger.info("Clicking on Best Selling Products page..");
        click(bestSellingLink);
    }
    public void clickSquareFrame(){
        WebElement productSquareFrame = driver.findElement(squareFrameLinkLocator);
        logger.info("Getting the Square Canvas Wraps ...");
        click(productSquareFrame);
    }
    public void clickfAddtoWishlist(){
        WebElement faddToWishlist = driver.findElement(faddToWishlistButtonLocator);
        logger.info("Adding the square frame to cart ...");
        click(faddToWishlist);
    }
    public void clickfAddToCartButton(){
        WebElement faddToCart = driver.findElement(faddToCartButtonLocator);
        logger.info("Adding the square frame to cart ...");
        click(faddToCart);
    }

    public void clickKidsTee(){
        WebElement productKidsTee = driver.findElement(kidsTeeLinkLocator);
        logger.info("Getting the Kids Tee ...");
        click(productKidsTee);
    }

    public void clicktAddToCartButton(){
        WebElement ktaddToCart = driver.findElement(ktaddToCartButtonLocator);
        logger.info("Adding the square frame to cart ...");
        click(ktaddToCart);
    }
    public void clickShoppingCartButton(){
        WebElement viewShoppingCart = driver.findElement(viewCartButtonLocator);
        logger.info("Showing the items in the cart ...");
        click(viewShoppingCart);
    }
    public void clickAddToWishlistButton(){
        WebElement ktAddWishlist = driver.findElement(ktaddToWishlistButtonLocator);
        logger.info("Adding item to wishlist..");
        click(ktAddWishlist);
    }
    public void clickWishlistButton(){
        WebElement viewWishlist = driver.findElement(viewWishlistButtonLocator);
        logger.info("Showing the items in the wishlist ...");
        click(viewWishlist);
    }


}
