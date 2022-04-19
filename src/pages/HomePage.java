package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    By lodgedInPageBy = By.xpath("//*[@id='center_column']/h1");
    By signOutButton = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[2]/a");
    By numberOfItemsPopular = By.xpath("//*[@id='homefeatured']/li");
    By numberOfItemsBestSeller = By.xpath("//*[@id='homefeatured']/li");
    By homePageButton = By.xpath("//*[@id='header_logo']/a/img");
    By tshirtsButton = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");
    By tshirtAddToCartButton = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]");
    By itemInCartMessageBy = By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2");
    By totalPriceBy = By.id("total_price_container");
    By productPriceBy = By.id("total_product");
    By shippingPriceBy = By.id("total_shipping");
    By taxPriceBy = By.id("total_tax");
    By proceedToCheckoutButton = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span");
    By mouseOverBy = By.xpath("//*[@id='center_column']/ul/li/div");
    By addToCartBy = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]");
    

    public HomePage verifySucsessfullLogin(String expectedText){
        String actualTitle = readText(lodgedInPageBy);
        assertTextEquals(expectedText, actualTitle);
        return this;
    }
    public HomePage clickOnSignOutButton(){
        click(signOutButton);
        return this;
    }
    public HomePage numberOfProductsPopular(int expectedNumberOfProducts){
        int actualNumberOFProducts = countItems(numberOfItemsPopular);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOFProducts);
        return this;
    }
    public HomePage clickOnHomePageButton(){
        click(homePageButton);
        return this;
    }
    public HomePage numberOfProductsBestSeller(int expectedNumberOfProducts){
        int actualNumberOFProducts = countItems(numberOfItemsBestSeller);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOFProducts);
        return this;
    }
    public HomePage clickOnTshirtsButton(){
        click(tshirtsButton);
        return this;
    }
    public HomePage clickOnAddToCartButton(){
        WebElement mouseOver = driver.findElement(mouseOverBy);
        WebElement addToCart = driver.findElement(addToCartBy);
        
        Actions action = new Actions(driver);
        driver.manage().window().setSize(new Dimension(1024, 2600));
        action.moveToElement(mouseOver).click(addToCart).build().perform();
        return this;
    }
    public HomePage verifyProductInCart(String expectedTextProductInCart){
        String itemInCartMessage = readText(itemInCartMessageBy);
        assertTextEquals(expectedTextProductInCart, itemInCartMessage);
        return this;
    }
    public HomePage verifyTotalPrice(By totalPrice){
        String productPrice = readText(productPriceBy);
        productPrice = productPrice.substring(1);
        String shippingPrice = readText(shippingPriceBy);
        shippingPrice = shippingPrice.substring(1);
        String taxPrice = readText(taxPriceBy);
        taxPrice = taxPrice.substring(1);
        String finalPrice = readText(totalPriceBy);
        finalPrice = finalPrice.substring(1);
        Double a = Double.parseDouble(productPrice);
        Double b = Double.parseDouble(shippingPrice);
        Double c = Double.parseDouble(taxPrice);
        Double d = Double.parseDouble(finalPrice);
        Double abc = a + b + c;
        
        assertDoubleEquals(abc, d);
        return this;
    }
    public HomePage clickOnProceedToCheckoutButton(){
        click(proceedToCheckoutButton);
        return this;
    }
    
}
