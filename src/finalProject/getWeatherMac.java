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

public class getWeatherMac extends MACImageSpecsAdd
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
		

		// Mac
		// System.setProperty("webdriver.gecko.driver","/Users/path/path/geckodriver");
	    //System.setProperty("webdriver.chrome.driver","/Users/skaljica/Downloads/chromedriver");
	    System.setProperty("webdriver.chrome.driver","/Users/codycabral/Downloads/chromedriver 3");

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

//		int xc = point.getX()+100;
//		int yc = point.getY()+170;
//		int w = eleWidth+400;
//		int h = eleHeight+400;
		
		int xc = point.getX()+ MACAddxc;
		int yc = point.getY()+ MACAddyc;
		int w = eleWidth+ MACAddw;
		int h = eleHeight+ MACAddh;

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage(xc, yc, w + 155, h + 20);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		// Mac
		//File screenshotLocation = new File("/Users/skaljica/Downloads/weather.png");
		File screenshotLocation = new File("/Users/codycabral/Downloads/weather.png");
		
		FileUtils.copyFile(screenshot, screenshotLocation);

		Thread.sleep(400);
		cdriver.close();
	}
}