package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.google.common.io.Files;

import base.WebDriverManager;

public class CaptureScreenshot extends WebDriverManager {

	public static String getscreenshot(String testcasename) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String date_fomat = ft.format(d);
		File dest = new File(System.getProperty("user.dir") + "//screenshot//"
				+ date_fomat + "_" + testcasename + ".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest.getPath();

	}

}
