package tests;

import org.junit.Test;
import org.openqa.selenium.By;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTests extends BaseTest{
    
    public LoginPage loginPage;
    public HomePage homePage;
    
    String email = "nemanjaindjic@gmail.com";
    String password = "comtrade";
    String expectedTextItemInCart = "Product successfully added to your shopping cart";
    int numberOfAllItems = 7;
    By totalPriceBy = By.id("total_price_container");

    @Test
    public void numberOfItemsPopular(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(email, password);
        homePage.clickOnHomePageButton();
        homePage.numberOfProductsPopular(numberOfAllItems);
    }

    @Test
    public void numberOfItemsBestSeller(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(email, password);
        homePage.clickOnHomePageButton();
        homePage.numberOfProductsBestSeller(numberOfAllItems);
    }

    @Test
    public void addProductInCart(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(email, password);
        homePage.clickOnTshirtsButton();
        homePage.clickOnAddToCartButton();
        homePage.verifyProductInCart(expectedTextItemInCart);
    }

    @Test
    public void totalPriceAssert(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(email, password);
        homePage.clickOnTshirtsButton();
        homePage.clickOnAddToCartButton();
        homePage.clickOnProceedToCheckoutButton();
        homePage.verifyTotalPrice(totalPriceBy);
    }
}
