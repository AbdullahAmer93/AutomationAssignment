package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)  // This tells JUnit to run Cucumber
@CucumberOptions(
        features = "src/test/resources/features",  // Path to the feature files
        glue = "StepDefinition",                 // Path to the step definition package
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true,  // To make console output more readable
        tags = "@smoke"  // Optional
)
public class TestRunner {
    // This class will be used to run the tests
}

