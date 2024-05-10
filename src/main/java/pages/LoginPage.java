package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="Login")
	public WebElement loginButton;
	
	@FindBy(id = "error")
	public WebElement errorMessage;
	
	@FindBy(xpath="//a[@id='forgot_password_link']")
	public WebElement forgotPassword;
	
	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;

	@FindBy(id = "un")
	public WebElement forgotUsername;
	
	public void loginToSFDC(String userEmail, String passWord) {
		logger.info("Siging in to application");
		this.username.sendKeys(userEmail);
		this.password.sendKeys(passWord);
		this.loginButton.click();
		logger.info("Siging in to application is done");
	}

}
