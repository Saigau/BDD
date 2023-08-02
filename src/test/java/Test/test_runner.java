package Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "Folder\\login1.feature",
		glue = "Test",
	
				plugin = {"pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"rerun:target/failedrun.txt"
				},
				
				dryRun = false,
		 tags = "@lead"
		 
		
		)
public class test_runner extends AbstractTestNGCucumberTests {

}
