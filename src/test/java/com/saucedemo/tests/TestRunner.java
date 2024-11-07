package com.saucedemo.tests;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
        ,glue={"com.saucedemo.StepDefinition"},    // Path to the step definition classes
        plugin = {
                "pretty",  // Prints the output of the test to the console in a readable format
                "html:target/cucumber-reports/cucumber.html",  // Generates an HTML report
                "json:target/cucumber-reports/cucumber.json"   // Generates a JSON report
        },
        monochrome = true,
        tags = "@SmokeTest"

)

public class TestRunner {

}
