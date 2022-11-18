package hookstest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class RunHooksTest {

	@Before
	public void before(Scenario sc)
	{
		//System.out.println(sc.getId());
		System.out.println(sc.getName());
	}
	
	@After
	public void after(Scenario sc)
	{
		System.out.println(sc.getStatus());

	}
	
	
}
