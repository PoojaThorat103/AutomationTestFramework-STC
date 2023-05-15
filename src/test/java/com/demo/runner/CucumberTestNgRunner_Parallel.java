package com.demo.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"com.demo.steps"},
        monochrome = true,
        plugin = {"pretty",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CucumberTestNgRunner_Parallel extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
