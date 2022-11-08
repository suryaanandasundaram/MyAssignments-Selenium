package week6.day2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LearnAnnotations {
@BeforeSuite
public void bs()
{
	System.out.println("@BeforeSuite");
}
@BeforeTest
public void bt()
{
	System.out.println("@BeforeTest");
}
@BeforeClass
public void bc()
{
	System.out.println("@BeforeClass");
}

@BeforeMethod
public void bm1()
{
	System.out.println("@BeforeMethod1");
}
@BeforeMethod
public void bm2()
{
	System.out.println("@BeforeMethod2");
}
@Test
public void test1()
{
	System.out.println("Test1");
}

@Test
public void test2()
{
	System.out.println("Test2");
}
@AfterMethod
public void am()
{
	System.out.println("@AfterMethod");
}
@AfterClass
public void ac()
{
	System.out.println("@AfterClass");
}



@AfterTest
public void at()
{
	System.out.println("@AfterTest");
}
@AfterSuite
public void as()
{
	System.out.println("@AfterSuite");
}



}
