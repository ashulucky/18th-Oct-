package checkpack;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ForgetPasswordpage;
import pages.LoginOrsignuppage;

public class VerifyLoginPage{

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.facebook.com/");
		LoginOrsignuppage loginOrsignuppage = new LoginOrsignuppage(driver);
		loginOrsignuppage.sendUserName();
		loginOrsignuppage.sendpassword();
		//loginOrsignuppage.clickOnforgetPassword();
		
		loginOrsignuppage.clickOnloginButton();
		/*loginOrsignuppage.clickOnCreateNewAcc(); 
		
       ForgetPasswordpage forgetPasswordpage = new ForgetPasswordpage(driver);
		
		String msg = forgetPasswordpage.getForgetMessage();
		
		if(msg.equals("Text msg"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		forgetPasswordpage.enteremail();
		Thread.sleep(2000);
		forgetPasswordpage.searchButton();
		forgetPasswordpage.cancelButton();*/ 
		

	}

}
