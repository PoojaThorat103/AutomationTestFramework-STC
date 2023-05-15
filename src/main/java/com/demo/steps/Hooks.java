package com.demo.steps;

import com.demo.utils.BaseConfiguration;
import io.cucumber.java.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks extends BaseConfiguration {
    private Scenario scenario;

    @Before
    public void beforeScenario(Scenario scenario) throws MalformedURLException, InterruptedException {
        this.scenario = scenario;
        initiateDriver();
    }

    @AfterStep
    public void afterSteps(Scenario scenario){
        getScreenshotOnFailure(scenario);
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        closeDriver();
    }
}
