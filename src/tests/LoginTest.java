package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    
    public LoginPage loginPage;
    public HomePage homePage;
    String email = "nemanjaindjic@gmail.com";
    String password = "comtrade";
    String expectedText = "MY ACCOUNT";

    @Test
    public void verifySucsessfullLogin(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(email, password);
        homePage.verifySucsessfullLogin(expectedText);
    }
    @Test
    public void verifySucsessfulLogout(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(email, password);
        homePage.clickOnSignOutButton();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='SubmitLogin']/span")));
        loginPage.verifySucsessfullLogout();
    }
}
