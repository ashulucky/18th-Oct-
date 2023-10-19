package pages;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Utility;

public class LoginOrsignuppage {

	//variable - private
			@FindBy(xpath = "//input[@id='email']")
			private WebElement userName;
			@FindBy(xpath = "//input[@id='pass']")
			private WebElement passwrd ;
			@FindBy(xpath = "//button[text() = 'Log in']")
			private WebElement loginButton;
			@FindBy(xpath = "//a[text() ='Forgotten password?']")
			private WebElement forgetPassword;
			@FindBy(xpath = "//a[text( )='Create new account']")
			private WebElement CreateNewAcc;
            private WebDriver driver;
			//constructor public
			public LoginOrsignuppage(WebDriver driver)//driver123=driver
			{
				//To find Element
				PageFactory.initElements(driver, this);
				this.driver = driver;
			}
			//methods - public
			public void sendUserName() throws EncryptedDocumentException, IOException
			{
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOf(userName));
				String userNamedata =Utility.getDataFromExcelsheet("src\\test\\resources\\Dataprovider\\Loginfile.xlsx","Sheet1",2,0);
				userName.sendKeys(userNamedata);
				
			}
			public void sendpassword() throws EncryptedDocumentException, IOException
			
			{
				String passwordData = Utility.getDataFromExcelsheet("src\\test\\resources\\Dataprovider\\Loginfile.xlsx","Sheet1",2,1);
				passwrd.sendKeys(passwordData);
			
				//return(password);
			
			}
			public void clickOnloginButton()
			{
				loginButton.click();
			}
			public void clickOnforgetPassword()
			{
				forgetPassword.click();
			}
			public void clickOnCreateNewAcc()
			{
				CreateNewAcc.click();
			}
		}
	
	


