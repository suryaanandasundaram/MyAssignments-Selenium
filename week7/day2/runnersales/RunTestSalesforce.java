package runnersales;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions

(features ="src/test/java/featuresalesforce",
glue={"stepssales","hooks"},monochrome=true,publish=true,tags="@Smoke or @Sanity"
)
public class RunTestSalesforce extends AbstractTestNGCucumberTests{

}
