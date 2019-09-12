package finalProject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyController {
	@FXML
	TextField MyTextField;
	
	@FXML
	Label msg;
	
	@FXML
	TextArea MyLinkField;

	public void myOwnSearch() {
		// TODO Auto-generated method stub
		/***************************************************************************************************************************************************
		 * DO NOT CHANGE DIRECTORIES COMMENT OUT THE PRESENT LINE OF CODE BASED
		 * ON YOUR OS: COPY, PASTE, AND ADJUST DIRECTORY AS NEEDED ON A NEW LINE
		 ***************************************************************************************************************************************************/

		// Windows
		// System.setProperty("webdriver.gecko.driver","C:\\\\Users\\perezs4\\Downloads\\geckodriver-v0.13.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\perezs4\\Downloads\\chromedriver_win32\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver","C:\\\\Users\\techg\\Downloads\\Programs\\chromedriver_win32\\chromedriver.exe");

		// Mac
		// System.setProperty("webdriver.chrome.driver","/Users/path/path/chromedriver");
		// System.setProperty("webdriver.chrome.driver","/Users/skaljica/Downloads/chromedriver");
		// System.setProperty("webdriver.chrome.driver","/Users/codycabral/Downloads/chromedriver
		// 3");

		WebDriver cdriver = new ChromeDriver();
		// WebDriver fdriver= new FirefoxDriver();

		cdriver.get("http://www.google.com");
		WebElement searchBar = cdriver.findElement(By.name("q"));
		searchBar.sendKeys(MyTextField.getText() + "\n"); // Make string what
															// the user inputs
		// searchBar.submit();

		// fdriver.get("http://www.google.com");
		// WebElement searchBar = fdriver.findElement(By.name("q"));
		// searchBar.sendKeys("MyTextField.getText()"+ "\n);
		// searchBar.submit();
		printLinks(cdriver);
	}

	public void onKeyReleased(KeyEvent e) {
		if (e.getCode() == KeyCode.ENTER) {
			myOwnSearch();
		}
	}

	public void printLinks(WebDriver cdriver) {
		WebElement myDynamicElement = (new WebDriverWait(cdriver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
		List<WebElement> findElements = cdriver.findElements(By.xpath("//*[@id='rso']//h3/a"));

		String output = "";
		for (WebElement webElement : findElements) {
			//System.out.println(webElement.getAttribute("href"));
			output += webElement.getAttribute("href") + "\n";
		}
		
		MyLinkField.setText(output);
	}

}
