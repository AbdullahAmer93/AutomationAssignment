package com.saucedemo.tests;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
        ,glue={"com.saucedemo.StepDefinition"},    // Path to the step definition classes
        plugin = {
                "pretty",  // Prints the output of the test to the console in a readable format
                "html:target/cucumber-reports/cucumber.html",  // Generates an HTML report
                "json:target/cucumber-reports/cucumber.json"   // Generates a JSON report
        },
        monochrome = true,  // Ensures that console output is more readable (no escape characters)
        tags = "@SmokeTest",  // If you want to run tests with a specific tag, for example, @SmokeTest
        strict = true
)

public class TestRunner {

}
