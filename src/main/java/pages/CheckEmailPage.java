package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckEmailPage extends BasePage{
	
	public CheckEmailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//a[@href='/']")
	public WebElement returnLoginButton;	

}
