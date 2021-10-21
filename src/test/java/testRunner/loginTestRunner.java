package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/features",
                glue = {"stepDefinations"},
                monochrome = true,
                plugin = {"pretty","html:target/HtmlReports"})
public class loginTestRunner {
}
