package runnersalestest;

import hookssalestest.BaseClassSalesTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features="src/test/java/featuresalesforcetest",
	glue={"stepssalestest","hookssalestest"},monochrome=true,publish=true,tags="@Smoke"
		
		)





public class Runner extends BaseClassSalesTest{

}
