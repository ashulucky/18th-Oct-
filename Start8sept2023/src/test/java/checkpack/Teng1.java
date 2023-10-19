package checkpack;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Teng1 {
	static int a=0;
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite13");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test19");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class31");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method1919");
	}
	
	@Test(groups = {"High priority","Sanity"})
	public void test1() {
		System.out.println("Test10");
	}
	@Test(groups = "Low Priority")
	public void test2() {
		System.out.println("Test11");
	}
	@Test(groups = {"Low Priority","Sanity"})
	public void test3() {
		System.out.println("Test12");
	}
	@Test(groups = "Sanity")
	public void test4() {
		System.out.println("Test13");
		}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method31");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class19");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test19");
	}	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite31");
	}
	
	
}
