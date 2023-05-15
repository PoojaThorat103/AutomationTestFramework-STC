package com.demo.utils;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseConfiguration {
    public static String remote_hub_url = "remote_hub_url";
    public static String browser = "browser";
    public static String execution = "execution";
    public static Logger log = LogManager.getLogger();

    public WebDriver getBrowserDriver(String browserName, String execution) throws MalformedURLException {
        WebDriver driver = null;
        switch (execution){
            case "docker" :
                driver = getRemoteDriver(browserName);
                break;

            case "local" :
                driver = getLocalDriver(browserName);
                break;

            default :
                log.error("Please select valid execution option");
        }
        return driver;
    }

    public WebDriver getLocalDriver(String browserName){
        WebDriver driver = null;

        switch (browserName){
            case "chrome" :
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge" :
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(edgeOptions);
                break;

            case "firefox" :
                driver = new FirefoxDriver();
                break;

            default :
                log.error("Please select valid browser name");
        }
        return driver;
    }

    public RemoteWebDriver getRemoteDriver(String browserName) throws MalformedURLException {
        RemoteWebDriver driver = null;
        Capabilities option = null;
        Util util = new Util();
        String remote_hub_url = util.getProperties("remote_hub_url");

        switch (browserName){
            case "chrome" :
                DesiredCapabilities capChrome = new DesiredCapabilities();
                option = new ChromeOptions();
                capChrome.setCapability(ChromeOptions.CAPABILITY, option);
                capChrome.setPlatform(Platform.WINDOWS);
                option.merge(capChrome);
                break;

            case "firefox" :
                DesiredCapabilities capFirefox = new DesiredCapabilities();
                option = new FirefoxOptions();
                capFirefox.setCapability(ChromeOptions.CAPABILITY, option);
                capFirefox.setPlatform(Platform.WINDOWS);
                option.merge(capFirefox);
                break;

            case "edge" :
                DesiredCapabilities capEdge = new DesiredCapabilities();
                option = new EdgeOptions();
                capEdge.setCapability(ChromeOptions.CAPABILITY, option);
                capEdge.setPlatform(Platform.WINDOWS);
                option.merge(capEdge);
                break;
            default :
                log.error("Please select valid browser name");
        }

        driver = new RemoteWebDriver(new URL(remote_hub_url), option);
        return driver;
    }

    public void initiateDriver() throws MalformedURLException, InterruptedException {
        WebDriver driver = null;
        Util util = new Util();
        driver = getBrowserDriver(util.getProperties(browser), util.getProperties(execution));
        driver.manage().window().maximize();
        driver.get(util.getProperties("url"));
        DriverFactory.getInstance().setDriver(driver);
        log.info("Driver is initialized");
    }

    public WebDriver driver(){
        return DriverFactory.getCurrentDriver();
    }

    public void getScreenshotOnFailure(Scenario scenario){
        if ((scenario.isFailed())) {
            final byte[] screenshot = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
    public void closeDriver() throws IOException {
        if(DriverFactory.getInstance() != null) {
            DriverFactory.getCurrentDriver().quit();
        }
    }

}
