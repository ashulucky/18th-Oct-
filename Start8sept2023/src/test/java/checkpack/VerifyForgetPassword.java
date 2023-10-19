package checkpack;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ForgetPasswordpage;
import pages.LoginOrsignuppage;

public class VerifyForgetPassword {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		// System.setProperty("webdriver.chromedriver.driver","C:\Users\rekha\OneDrive\Documents\Ashwini
		// mahajan\chromedriver.ex");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		// 1.POM class object create
		// 2.POM class non static (WebElement)variable declared
		// 3.constructor code execute - Initialization of variable/Initialization
		// (Find)of WebElement
		LoginOrsignuppage loginOrsignuppage = new LoginOrsignuppage(driver);
		loginOrsignuppage.sendUserName();
		loginOrsignuppage.sendpassword();
		loginOrsignuppage.clickOnloginButton();
		loginOrsignuppage.clickOnCreateNewAcc();
		ForgetPasswordpage forgetPasswordpage = new ForgetPasswordpage(driver);

		String msg = forgetPasswordpage.getForgetMessage();
		if (msg.equals("Text msg")) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		forgetPasswordpage.enteremail();
		forgetPasswordpage.searchButton();
		forgetPasswordpage.cancelButton();

	}

}
