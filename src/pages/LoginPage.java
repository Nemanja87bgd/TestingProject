package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    By emailBy = By.id("email");
    By passwordBy = By.id("passwd");
    By signInButtonBy = By.xpath("//*[@id='SubmitLogin']/span");
    By signInPageBy = By.className("login");

    String baseURL = "http://automationpractice.com/";

    public LoginPage basePage(){
    driver.get(baseURL);
    return this;
    }

    public LoginPage login(String email, String password){
        click(signInPageBy);
        writeText(emailBy, email);
        writeText(passwordBy, password);
        click(signInButtonBy);
        return this;
    }
    public LoginPage verifySucsessfullLogout(){
        assertElementVisible(signInButtonBy);
        return this;
    }
}
    

