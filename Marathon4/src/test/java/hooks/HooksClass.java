package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass {

@Before
public void before(Scenario sc)
{
	System.out.println(sc.getName());
}

@After
public void After(Scenario sc)
{
	System.out.println(sc.getStatus());
}
	
}
