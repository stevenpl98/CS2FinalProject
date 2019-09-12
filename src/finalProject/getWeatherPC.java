package finalProject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class getWeatherPC implements PCImageSpecsAdd
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		start();
	}

	public static void start() throws InterruptedException, IOException 
	{
		// TODO Auto-generated method stub
		
/***************************************************************************************************************************************************
 * DO NOT CHANGE DIRECTORIES
 *** COMMENT OUT THE PRESENT LINE OF CODE
 *** COPY, PASTE, AND ADJUST DIRECTORY AS NEEDED ONTO A NEW LINE
***************************************************************************************************************************************************/
		
		// Windows
		// System.setProperty("webdriver.gecko.driver","C:\\\\Users\\perezs4\\Downloads\\geckodriver-v0.13.0-win64\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\\\Users\\techg\\Downloads\\Programs\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\perezs4\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver cdriver = new ChromeDriver();
		// WebDriver fdriver= new FirefoxDriver();

		cdriver.manage().window().setPosition(new Point(0, 0));
		cdriver.get("http://www.bing.com/weather");
		WebElement ele = cdriver.findElement(By.className("wtr_gradient"));

		Thread.sleep(1000);
		// Get entire page screenshot
		File screenshot = ((TakesScreenshot) cdriver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

//		int xc = point.getX() + 30;
//		int yc = point.getY() + 40;
//		int w = eleWidth + 130;
//		int h = eleHeight + 105;
		
		int xc = point.getX() + PCAddxc;
		int yc = point.getY() + PCAddyc;
		int w = eleWidth + PCAddw;
		int h = eleHeight + PCAddh;

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage(xc, yc, w, h);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		// Windows
		//File screenshotLocation = new File("C:\\Users\\techg\\Downloads\\weather.png");
		File screenshotLocation = new File("C:\\Users\\perezs4\\Downloads\\weather.png");

		FileUtils.copyFile(screenshot, screenshotLocation);

		Thread.sleep(400);
		cdriver.close();
	}
}