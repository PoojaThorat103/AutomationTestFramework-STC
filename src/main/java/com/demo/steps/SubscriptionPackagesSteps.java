package com.demo.steps;

import com.demo.actions.SubscriptionPackagesActions;
import com.demo.utils.BaseConfiguration;
import com.demo.utils.SeleniumWrapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class SubscriptionPackagesSteps extends SeleniumWrapper {
    SubscriptionPackagesActions subscriptionPackagesActions;

    public SubscriptionPackagesSteps(){
        subscriptionPackagesActions = new SubscriptionPackagesActions();
    }

    @Given("User is on subscription plan page")
    public void user_is_on_subscription_plan_page() {
        subscriptionPackagesActions.checkSubscriptionPage();
    }
    @When("User selects {string} country")
    public void user_selects_country(String countryName) {
        subscriptionPackagesActions.selectCountry(countryName);
    }
    @Then("User check subscription details - plan types, price, and currency details")
    public void user_check_subscription_details_plan_types_price_and_currency_details(DataTable dataTable) {
        List<Map<String, String>> subscriptionDetails = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> subscription : subscriptionDetails) {
            String planType = subscription.get("Plans");
            String planPrice = subscription.get("Price");
            String planCurrency = subscription.get("Currency");
            subscriptionPackagesActions.checkSubscriptionDetails(planType, planPrice, planCurrency);
        }
    }
}
