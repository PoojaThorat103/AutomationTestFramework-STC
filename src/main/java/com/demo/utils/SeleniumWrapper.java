package com.demo.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumWrapper extends BaseConfiguration{

    public void userClick(WebElement we) {
        try{
            if(isElementDisplayed(we)){
                we.click();
                log.info("User successfully clicked on WebElement - " +we);
            }else{
                verifyTest(false,"User couldn't click on WebElement - " + we);
            }
        }catch(Exception e){
            verifyTest(false, "Exception while clicking on webElement "+we+" with error message - "+ e.getMessage() );
        }
    }

    public void userType(WebElement we, String text) {
        try {
            if (isElementDisplayed(we)) {
                we.sendKeys(text);
                log.info("user has entered the value : "+text +" for WebElement - "+ we);
            }else{
                verifyTest(false,"User not able to pass value to " + we);
            }
        }catch(Exception e){
            verifyTest(false,"Exception while entering the text for WebElement - "+ we +", Error message - "+ e.getMessage());
        }
    }

    public boolean isElementDisplayed(WebElement we) {
        try{
            waitForElement(we);
            we.isDisplayed();
            log.info("WebElement is successfully displayed - "+ we);
            return true;
        }catch(Exception e){
            log.info("Element is not displayed "+ we);
            return false;
        }
    }

    public void waitForElement(WebElement we) {
        try{
            WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(we));
        }catch(Exception e){
            verifyTest(false, "Exception while waiting for WebElement "+ we +", exception message - "+ e.getMessage() );
        }
    }

    public void verifyTestEquals(String actualString, String expectedString, String message) {
            log.info("Comparing string = actual : "+actualString+ ", expected - "+expectedString);
            Assert.assertEquals(actualString, expectedString, message);
    }

    public void verifyTestContains(String actualString, String containsString, String message) {
        log.info("ActualString : "+actualString+ ", should contains - "+containsString);
        Assert.assertTrue(actualString.contains(containsString), message);
    }
    public void verifyTest(boolean isDisplayed, String message) {
        log.info(message);
        Assert.assertTrue(isDisplayed, message);
    }

}
