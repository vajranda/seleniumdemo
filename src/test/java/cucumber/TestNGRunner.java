package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java", glue ="seleniumFrameworkDesign/stepdefination" ,
monochrome = true ,tags ="not @Regression" ,plugin = {"html:target/cucumber.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests {
	

	
	
	
	
	
	
	

}
