package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.WebDriverManager;

public class FlightResults extends WebDriverManager{
	
	public FlightResults()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="(//li[@id='PRICE'])[1]")
	WebElement lnk_start_price;
	
	@FindBy(xpath ="(//li[@id='PRICE'])[2]")
	WebElement lnk_ret_price;
	
	@FindBy(xpath ="//div[@class='fltHpyOnwrdWrp']//span[@class='custRad']")
	WebElement radio_start_price;
	
	@FindBy(xpath ="//div[@class='fltHpyRtrnWrp']//span[@class='custRad']")
	WebElement radio_ret_price;
	
	@FindBy(xpath ="//input[@value ='BOOK']")
	WebElement btn_book;

	public FareSummary bookCostliestFlight()
	{
		lnk_start_price.click();
		radio_start_price.click();
		lnk_ret_price.click();
		radio_ret_price.click();
		btn_book.click();
		return new FareSummary();
	}
	
	
	
}
