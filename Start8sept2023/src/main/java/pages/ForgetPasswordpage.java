package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordpage {
	@FindBy(xpath = "//div[contains(text(),'Please enter your email address')]")
	private WebElement textMessage;
	@FindBy(xpath = "//input[@id='identify_email']")
	private WebElement enteremail;
	@FindBy(xpath = "//a[text( )='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath = "//button[text( )='Search']")
	private WebElement searchButton;
	
	//constructor - public
	public ForgetPasswordpage(WebDriver driver345)
	{
		//To find Element
		PageFactory.initElements(driver345, this);
	}
	//method
	public String getForgetMessage()
	{
            String msg = textMessage.getText();
            return(msg);
	}
	public void enteremail()
	{
		enteremail.sendKeys("");
	}
	public void cancelButton()
	{
	 cancelButton.click();
	}
	public String searchButton()
	{
		String text = searchButton.getText();
		return(text);
	}
	
	
	

}
