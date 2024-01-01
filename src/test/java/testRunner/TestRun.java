package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"./src/test/java/features" },
		glue = "stepDefinitions",
		dryRun = false,    //To check every scenario in feature has stepDefinition
		monochrome = true, // To eliminate unreadable character from console
		plugin = {"pretty", "html:test-output", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		strict = false
		)
public class TestRun {

}
