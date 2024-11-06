package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)  // This tells JUnit to run Cucumber
@CucumberOptions(
        features = "src/test/resources/features",  // Path to the feature files
        glue = "StepDefinition",                 // Path to the step definition package
        plugin = {"pretty", "html:target/cucumber-reports"},  // Report options (pretty and HTML report)
        monochrome = true,  // To make console output more readable
        tags = "@smoke"  // Optional: Specify a tag to run specific tests (e.g., @smoke)
)
public class TestRunner {
    // This class will be used to run the tests
}

