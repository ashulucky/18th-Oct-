package checkpack;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utils.Utility;
import base.Browser;
import pages.ForgetPasswordpage;
import pages.LoginOrsignuppage;


public class VerifyFacbookLogin1  {
private WebDriver driver;
private LoginOrsignuppage loginOrsignuppage;
private ForgetPasswordpage forgetPasswordpage;
private String testID;
@Parameters("browser")
 @BeforeTest
 public void launchBrowser(@Optional String browserName)
 {
 if(browserName.equals("Chrome"))
 {
	
System.setProperty("webdriver.chromedriver.driver","src\\test\\resources\\Browserfiles\\chromedriver.exe");
 driver = Browser.launchChrome();
	 
	
 }
 if(browserName.equals("Edge"))
 {
	
 driver = Browser.launchEdge();

    

	
	//WebDriverManager.chromedriver().setup();
	 
	 System.out.println("Before class");
 }
 
 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
}
 
 
	
 @BeforeClass
	public void creatingPOMOject() {
	 loginOrsignuppage = new LoginOrsignuppage(driver);
	 forgetPasswordpage = new ForgetPasswordpage(driver);
	 
 }

@BeforeMethod
public void  VerifyLoginbutton() throws EncryptedDocumentException, IOException
{
driver.get("https://www.facebook.com/");
//driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
LoginOrsignuppage loginOrsignuppage = new LoginOrsignuppage(driver);

loginOrsignuppage.sendUserName();

loginOrsignuppage.sendpassword();
//String password = loginOrsignuppage.sendpassword();
//if(password.equals("ashulucky1931"));
//System.out.println("pass");
	//System.out.println("fail");

//loginOrsignuppage.clickOnloginButton();
} 


	 
 @Test
	 public void openLoginPage() throws InterruptedException, EncryptedDocumentException, IOException
	 {      testID= "T201";
	    
	       System.out.println("Test -1");
            driver.get("https://www.facebook.com/");
	       // driver.manage().window().maximize();
	      //  SoftAssert softAssert = new SoftAssert();
	       // String expectedurl = "https://www.facebook.com/";
	       // String actualurl = "https://www.facebook.com/";
	       // Assert.assertEquals(actualurl ,expectedurl );
	       // softAssert.assertEquals(actualurl ,expectedurl );
	        
	        Thread.sleep(3000);
 		    LoginOrsignuppage loginOrsignuppage = new LoginOrsignuppage(driver);
			loginOrsignuppage.sendUserName();
			loginOrsignuppage.sendpassword();
			loginOrsignuppage.clickOnloginButton();
			//loginOrsignuppage.clickOnforgetPassword();
		 // String expectedtitle = "facebook" ;
	       // String actualtitle = "facebook";
		//Assert.assertEquals(driver.getTitle(),"(12) Facebook");	
		//Assert.assertNotEquals(driver.getTitle()," Facebook","failure msg");
		//softAssert.assertEquals(driver.getTitle(),"(12) Facebook");	
		//softAssert.assertNotEquals(driver.getTitle(),"(11) Facebook","failure msg");
			System.out.println("open Login TestPage");
			
      }
   
        
 @Test
		 public void VerifyForgetButton () throws InterruptedException, EncryptedDocumentException, IOException
		 {
	     System.out.println("Test -2");
		 driver.get("https://www.facebook.com/");
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		  LoginOrsignuppage loginOrsignuppage = new LoginOrsignuppage(driver);
			loginOrsignuppage.sendUserName();
			loginOrsignuppage.sendpassword();
			//loginOrsignuppage.clickOnloginButton();
			loginOrsignuppage.clickOnforgetPassword();
			ForgetPasswordpage forgetPasswordpage = new ForgetPasswordpage(driver);
			SoftAssert softAssert = new SoftAssert();
			String actualresult = forgetPasswordpage.getForgetMessage();
			System.out.println("actualresult");
			forgetPasswordpage.enteremail();
			String expectedresult = forgetPasswordpage.searchButton();
			System.out.println("expectedresult");
		 boolean result = expectedresult.contains(actualresult);
		 System.out.println("verify Test  ForgoteButton");
		// softAssert.assertTrue(result);
		//softAssert.assertFalse(result);
		// softAssert.assertAll();
		 }
			
			
			
		/*	if (actualresult.equals("Text msg")) {
				softAssert.fail();
				
			} else {
				
			}
			if (actualresult.equals("Text msg")) {
				System.out.println("pass");
			} else {
		         softAssert.fail();
			}
		 }
			
		
/*		 
 @Test
public void  VerifyLoginbutton()
 {
	 driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	  LoginOrsignuppage loginOrsignuppage = new LoginOrsignuppage(driver);
		loginOrsignuppage.sendUserName();
		loginOrsignuppage.sendpassword();
		String password = loginOrsignuppage.sendpassword();
		if(password.equals("ashulucky1931"));
		
			System.out.println("pass");
			
		
	

			System.out.println("fail");
		
		loginOrsignuppage.clickOnloginButton();
 }*/ 
 
 
 @AfterMethod
		 public void logoutFromApplication(ITestResult result) throws IOException, InterruptedException
		 {
			 System.out.println(ITestResult.FAILURE==result.getStatus());
			 if(ITestResult.FAILURE==result.getStatus())
			 {
				 Utility.capturefailScreenshot(driver, testID);
			 }
			 System.out.println("Logout");
		 }
 
 @AfterClass
		 public void clearObject()
		 {
			 loginOrsignuppage = null;
			 forgetPasswordpage = null;
		 }
 @AfterTest
 public void closeBrowser()
 {
	 driver.quit();
	 driver = null;
	 System.gc();
	System.out.println(" After Test Class31"); 
 }
 
		 
}
		 

