package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
    }
    public void waitVisability (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void writeText(By elementBy, String text){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }
    public void click(By elemenetBy){
        wait.until(ExpectedConditions.elementToBeClickable(elemenetBy));
        driver.findElement(elemenetBy).click();
    }
    public String readText(By elementBy){
        waitVisability(elementBy);
        return driver.findElement(elementBy).getText();
    }
    public void assertTextEquals(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }
    public void assertElementVisible(By elementBy){
        boolean isVisible = driver.findElement(elementBy).isDisplayed();
        Assert.assertTrue(isVisible);
    }
    public int countItems(By elementBy){
        waitVisability(elementBy);
        return driver.findElements(elementBy).size();
    }
    public void assertIntegerEquals(int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }
    public void assertDoubleEquals(Double expectedNumber, Double actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }
    
}
