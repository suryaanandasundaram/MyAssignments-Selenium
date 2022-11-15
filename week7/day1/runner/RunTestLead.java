package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions

(features ="src/test/java/feature",
glue={"steps","hooks"},monochrome=true,publish=true,tags="@Smoke or @Sanity"
)

public class RunTestLead extends AbstractTestNGCucumberTests{

}
