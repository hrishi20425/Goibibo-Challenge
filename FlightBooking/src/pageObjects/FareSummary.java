package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.WebDriverManager;

public class FareSummary extends WebDriverManager {

	public FareSummary() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='ico18 padLR10']/span")
	WebElement lbl_fare;

	@FindBy(id = "get_sign_up")
	WebElement lnk_sign_up;

	@FindBy(id = "Adulttitle1")
	WebElement drpdwn_title;

	@FindBy(id = "AdultfirstName1")
	WebElement txtbx_firstname;

	@FindBy(id = "AdultmiddleName1")
	WebElement txtbx_middlename;

	@FindBy(id = "AdultlastName1")
	WebElement txtbx_lastname;

	@FindBy(name = "email")
	WebElement txtbx_email;

	@FindBy(name = "mobile")
	WebElement txtbx_mobile;
	
	@FindBy(xpath = "//button[@class ='button orange col-md-3 fr large dF justifyCenter min37']")
	WebElement btn_proceed;
	
	@FindBy(id = "risk-trip")
	WebElement rdo_btn_risk_trip;

	@FindBy(xpath = "//button[@class='button blue large fb padLR30']")
	WebElement pop_up_btn_OK; 
	
	@FindBy(css = "span[class= 'ico16 quicks f700']")
	WebElement btn_proceed_payment;
	
	@FindBy(xpath = "//div[@id='nb']//span[@class='ico18 fmed fl']")
	WebElement lbl_payment_method;
	
	@FindBy(id = "ICICI")
	WebElement rdo_btn_bankname;
	
	@FindBy(xpath = "//div[@id='nbPayNow']//button[@class='button green large citipatBtn btn payNowBtn']")
	WebElement btn_pay;
	
	public void addPersonalDetails(String Title, String fname, String mname,
			String lname, String email, String mobile) {
		
		Select title = new Select(drpdwn_title);
		title.selectByVisibleText(Title);
		txtbx_firstname.sendKeys(fname);
		txtbx_middlename.sendKeys(mname);
		txtbx_lastname.sendKeys(lname);
		txtbx_email.sendKeys(email);
		txtbx_mobile.sendKeys(mobile);
		rdo_btn_risk_trip.click();
		btn_proceed.click();
		WebDriverWait w1 = new WebDriverWait(driver, 12000);
		w1.until(ExpectedConditions.visibilityOf(pop_up_btn_OK));
		pop_up_btn_OK.click();
		btn_proceed_payment.click();
	}
	
	public void addPaymentDetails()
	{
		WebDriverWait w = new WebDriverWait(driver, 7000);
		w.until(ExpectedConditions.visibilityOf(lbl_payment_method));
		lbl_payment_method.click();
		rdo_btn_bankname.click();
		btn_pay.click();
	}
	
}
