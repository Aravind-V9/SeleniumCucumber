package TestRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features/coursera.feature",
                 glue= {"StepDefinitions"},
                 plugin = { "pretty","html:target/cucumber-reports.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
                 monochrome=true
                 )
public class testRunerFile {
	

}
