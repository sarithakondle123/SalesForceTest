package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import constants.FileConstants;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;


public class CommonUtils {
	
	public static String captureScreenShot(WebDriver driver)
	{
		String filePath = FileConstants.SCREENSHOTS_FOLDER_PATH;
		TakesScreenshot page = (TakesScreenshot)driver;
		File screenshotsrc=page.getScreenshotAs(OutputType.FILE);
		screenshotsrc.renameTo(new File(filePath));
		return filePath;
		
	}
	public static String getTimeStamp()
	{
		return new SimpleDateFormat("yyyymmdd").format(new Date());
	}
	
	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	

}
