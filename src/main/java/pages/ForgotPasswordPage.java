package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{
	
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id = 'un']")
	public WebElement username;
	
	
	@FindBy(xpath ="//input[@id = 'continue']")
	public WebElement continueButton;
	
	
	
	@FindBy(xpath ="//a[@href='/']")
	public WebElement checkEmail;	

}