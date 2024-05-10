package tests;

import listeners.TestListener;

import pages.LoginPage;
import pages.UserMenuPage;
import pages.CheckEmailPage;
import pages.ForgotPasswordPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import constants.FileConstants;
import utils.CommonUtils;
import utils.DataUtils;

@Listeners(TestListener.class)

public class LoginPageTest extends BaseTest{
	
	public WebDriver driver;
	
	@BeforeMethod()
	public void preConditions()
	{
		
		BaseTest.setDriver("chrome", false);
	}
	
	@AfterMethod()
	public void postConditions()
	{
		BaseTest.getDriver().close();
		//driver.quit();
	}
	
	/*@Test
	public void verifyLoginErrorMessage()throws Exception
	{
		this.driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		
		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		//lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		CommonUtils.captureScreenShot(driver);
		lp.loginButton.click();
		Thread.sleep(1000);
		Assert.assertTrue(lp.errorMessage.isDisplayed());
				
	}	
	
	@Test
	public void verifyLoginWithCorrectCredentials()throws Exception
	{
		this.driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		
		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		CommonUtils.captureScreenShot(driver);
		lp.loginButton.click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("forcecomHomepage"));
				
	}*/
	
	@Test
	public void verifyLoginWithCorrectCredentials1() throws Exception
	{
		//BaseTest.test = BaseTest.extent.createTest("verifyLoginWithCorrectCredentials1");	
		
		ExtentTest test = BaseTest.threadExtentTest.get();
		
		this.driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		
		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		
		test.log(Status.INFO, "username is entered");
		
		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		
		test.log(Status.INFO, "password is entered");
		
		lp.rememberMe.click();
		CommonUtils.captureScreenShot(driver);
		lp.loginButton.click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("forcecomHomepage"));
		
		Thread.sleep(5000);
		
		UserMenuPage um = new UserMenuPage(driver);
		um.userMenu.click();
		Thread.sleep(2000);
		
		um.logout.click();
		Thread.sleep(1000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://tekarch55-dev-ed.develop.my.salesforce.com/"));
		
		Assert.assertTrue(lp.username.getText()!=null);
		Assert.assertTrue(lp.password.getText().isEmpty());
		Assert.assertTrue(lp.rememberMe.isSelected());		
				
	}
	
	/*@Test
	public void verifyForgotPassword()throws Exception
	{
		
		this.driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		
		Thread.sleep(3000);
		
		lp.forgotPassword.click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("forgotpassword"));
		
		
		ForgotPasswordPage forgotPassword = new ForgotPasswordPage(driver);
		forgotPassword.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		forgotPassword.continueButton.click();
		
		
		CheckEmailPage checkEmail = new CheckEmailPage(driver);
				checkEmail.returnLoginButton.click();
				
		Assert.assertTrue(driver.getCurrentUrl().contains("	https://tekarch55-dev-ed.develop.my.salesforce.com"));
		
	}*/
	
	@Test
	public void verifyWrongCrendentials()throws Exception
	{
		this.driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		
		lp.username.sendKeys("wrong username");
		lp.password.sendKeys("wrong password");
		CommonUtils.captureScreenShot(driver);
		lp.loginButton.click();
		Thread.sleep(1000);
		
		lp.errorMessage.isDisplayed();
		
		Thread.sleep(1000);
	}
	
	

}
