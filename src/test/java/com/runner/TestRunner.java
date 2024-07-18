package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html", "json:target/cucumber-report/cucumber.json"},
        monochrome = true,
        tags = "@Employee"
)
public class TestRunner {

}
