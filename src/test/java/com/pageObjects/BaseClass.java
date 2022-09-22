package com.pageObjects;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Assignments.utilities.ReadConfig;

public class BaseClass {

	public static ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String userName = readConfig.getEmail();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeTest
	public void setup(String br) {
		logger = Logger.getLogger("Assignment");
		PropertyConfigurator.configure("log4j2.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readConfig.getEdgePath());
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		logger.info("URL is opened");

	}

	public void waitforElement(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		logger.info("Browser closed");
	}
	
//	public void captureScreen(WebDriver driver, String tname) throws IOException{
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//  	File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
//
//
//	}

}
