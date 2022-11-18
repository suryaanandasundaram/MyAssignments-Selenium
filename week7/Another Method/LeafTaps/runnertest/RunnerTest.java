package runnertest;

import hookstest.BaseClassTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions

(features ="src/test/java/featuretest",
glue={"stepstest","hookstest"},monochrome=true,publish=true,tags="@Smoke"
)
public class RunnerTest extends BaseClassTest  {

}
