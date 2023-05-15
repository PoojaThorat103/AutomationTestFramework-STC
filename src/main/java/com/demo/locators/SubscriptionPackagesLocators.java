package com.demo.locators;

import com.demo.utils.DriverFactory;
import com.demo.utils.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionPackagesLocators extends SeleniumWrapper {

    public SubscriptionPackagesLocators(){
        PageFactory.initElements(driver(),this);
    }

    @FindBy(xpath = "//h2[text()='Choose Your Plan']")
    public WebElement subscriptionPage;
    @FindBy(xpath = "//div[@class='head-links']//a[contains(text(),'English')]")
    public WebElement englishTranslationBtn;
    @FindBy(id = "country-btn")
    public WebElement countryBtn;
    public WebElement chooseCountryByName(String countryName){
        return DriverFactory.getCurrentDriver().findElement(By.xpath("//a[@id='"+countryName+"']"));
    }
    @FindBy(id = "name-lite")
    public WebElement litePlan;
    @FindBy(id = "name-classic")
    public WebElement classicPlan;
    @FindBy(id = "name-premium")
    public WebElement premiumPlan;
    @FindBy(xpath = "//div[@id='currency-lite']/b")
    public WebElement litePlanPrice;
    @FindBy(xpath = "//div[@id='currency-classic']/b")
    public WebElement classicPlanPrice;
    @FindBy(xpath = "//div[@id='currency-premium']/b")
    public WebElement premiumPlanPrice;
    @FindBy(xpath = "//div[@id='currency-lite']/i")
    public WebElement litePlanCurrency;
    @FindBy(xpath = "//div[@id='currency-classic']/i")
    public WebElement classicPlanCurrency;
    @FindBy(xpath = "//div[@id='currency-premium']/i")
    public WebElement premiumPlanCurrency;
}
