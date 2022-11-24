package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(features ="src/test/java/features",
glue={"steps","hooks"},monochrome=true,publish=true,tags="@Smoke")

public class Runner extends BaseClassIncident {

}
