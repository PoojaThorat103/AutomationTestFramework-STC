package com.demo.actions;

import com.demo.locators.SubscriptionPackagesLocators;
import com.demo.utils.SeleniumWrapper;

public class SubscriptionPackagesActions extends SeleniumWrapper {
    SubscriptionPackagesLocators subscriptionPackagesLocators;
    public SubscriptionPackagesActions(){
        subscriptionPackagesLocators = new SubscriptionPackagesLocators();
    }

    public void checkSubscriptionPage(){
        userClick(subscriptionPackagesLocators.englishTranslationBtn);
        isElementDisplayed(subscriptionPackagesLocators.subscriptionPage);
    }

    public void selectCountry(String countryName){
        userClick(subscriptionPackagesLocators.countryBtn);
        userClick(subscriptionPackagesLocators.chooseCountryByName(countryName));
    }

    public void checkSubscriptionDetails(String planType, String planPrice, String planCurrency){
        switch (planType){
            case "LITE" :
                checkLitePlan(planType, planPrice, planCurrency);
                break;
            case "CLASSIC" :
                checkClassicPlan(planType, planPrice, planCurrency);
                break;
            case "PREMIUM" :
                checkPremiumPlan(planType, planPrice, planCurrency);
                break;
            default:verifyTest(false, "Please select valid plan type");
        }
    }

    public void checkLitePlan(String planType, String planPrice, String planCurrency){
        String actualPlanType =subscriptionPackagesLocators.litePlan.getText();
        String actualPlanPrice =subscriptionPackagesLocators.litePlanPrice.getText();
        String actualPlanCurrency =subscriptionPackagesLocators.litePlanCurrency.getText();

        verifyTestEquals(actualPlanType, planType, "Lite Plan type did not match");
        verifyTestEquals(actualPlanPrice, planPrice, "Lite Plan price did not match");
        verifyTestContains(actualPlanCurrency, planCurrency, "Lite Plan currency did not match");
    }

    public void checkClassicPlan(String planType, String planPrice, String planCurrency){
        String actualPlanType =subscriptionPackagesLocators.classicPlan.getText();
        String actualPlanPrice =subscriptionPackagesLocators.classicPlanPrice.getText();
        String actualPlanCurrency =subscriptionPackagesLocators.classicPlanCurrency.getText();

        verifyTestEquals(actualPlanType, planType, "Classic Plan type did not match");
        verifyTestEquals(actualPlanPrice, planPrice, "Classic Plan price did not match");
        verifyTestContains(actualPlanCurrency, planCurrency, "Classic Plan currency did not match");
    }

    public void checkPremiumPlan(String planType, String planPrice, String planCurrency){
        String actualPlanType =subscriptionPackagesLocators.premiumPlan.getText();
        String actualPlanPrice =subscriptionPackagesLocators.premiumPlanPrice.getText();
        String actualPlanCurrency =subscriptionPackagesLocators.premiumPlanCurrency.getText();

        verifyTestEquals(actualPlanType, planType, "Premium Plan type did not match");
        verifyTestEquals(actualPlanPrice, planPrice, "Premium Plan price did not match");
        verifyTestContains(actualPlanCurrency, planCurrency, "Premium Plan currency did not match");
    }

}
