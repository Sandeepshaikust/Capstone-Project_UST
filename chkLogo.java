package WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.CaptureScreenShot;
import utils.openChromeBrowser;

public class chkLogo {
	
	static WebDriver driver;
	 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  
		openChromeBrowser ob = new openChromeBrowser();
		
		driver = ob.openChrome();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com/");
		
		driver.manage().window().maximize();
		
		WebElement logo=driver.findElement(By.xpath("/html/body/div[3]/div/header/table/tbody/tr/td[1]/h1/a"));
		
		System.out.println(logo.isDisplayed());
		
		CaptureScreenShot cs=new CaptureScreenShot();
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		//Saving the screenshot in desired location
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		
		//Path to the location to save screenshot
		FileUtils.copyFile(source, new File("./SeleniumScreenshots/Screen.png"));
		
		System.out.println("Screenshot is captured");
		
		driver.quit();
		}
		
	

}


