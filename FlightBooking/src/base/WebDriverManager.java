package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import config.ConfigManager;

public class WebDriverManager {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver intializeDriver()
	{
		System.setProperty("webdriver.chrome.driver", ConfigManager.getDriverpath());
		driver = new ChromeDriver();
		driver.get(ConfigManager.getURL());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
		
	}

}
