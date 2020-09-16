package pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.WebDriverManager;

public class HomePage extends WebDriverManager {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gosuggest_inputSrc")
	WebElement drpdwn_from;

	@FindBy(id = "gosuggest_inputDest")
	WebElement drpdwn_dest;

	@FindBy(id = "returnCalendar")
	WebElement clndr_ret_option;

	@FindBy(id = "gi_search_btn")
	WebElement btn_search;

	@FindBy(id = "react-autosuggest-1")
	WebElement drpdwn_fromoptions;

	@FindBy(xpath = "//div[@class='DayPicker-Day DayPicker-Day--today DayPicker-Day--selected']")
	WebElement txtbx_today_day;

	@FindBy(xpath = "//div[@class='DayPicker-Caption']")
	WebElement lbl_month;

	@FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	WebElement nav_next_month;

	@FindBy(xpath = "//div[@class='DayPicker-Day']/div[@class='calDate']")
	List<WebElement> txtbx_day;

	public FlightResults searchFlight(String from_city, String to_city,
			String dep_date, String ret_date) {
		drpdwn_from.click();
		drpdwn_from.sendKeys(from_city);
		WebDriverWait w = new WebDriverWait(driver, 5000);
		w.until(ExpectedConditions.visibilityOf(drpdwn_fromoptions));
		drpdwn_from.sendKeys(Keys.ARROW_DOWN);
		drpdwn_from.sendKeys(Keys.ENTER);
		drpdwn_dest.sendKeys(to_city);
		w.until(ExpectedConditions.visibilityOf(drpdwn_fromoptions));
		drpdwn_dest.sendKeys(Keys.ARROW_DOWN);
		drpdwn_dest.sendKeys(Keys.ENTER);
		selectDate(dep_date);
		clndr_ret_option.click();
		selectDate(ret_date);
		btn_search.click();
		return new FlightResults();
	}

	public void selectDate(String date) {
		Date date_ip = null;
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
		try {
			date_ip = sd.parse(date);
		} catch (ParseException p) {
			System.out.println("Entered date cannot be parsed");
		}
		Date today = Calendar.getInstance().getTime();
		if (sd.format(date_ip).equals(sd.format(today))) {
			System.out.println("I am here");
			txtbx_today_day.click();
		} else if (sd.format(date_ip).compareTo(sd.format(today)) < 0) {
			System.out.println("Entered date is less than today's date");
		} else {
			SimpleDateFormat formatDay = new SimpleDateFormat("dd");
			SimpleDateFormat formatMonth = new SimpleDateFormat("MMMM");
			SimpleDateFormat formatYear = new SimpleDateFormat("YYYY");
			String month_ip = formatMonth.format(date_ip) + " "
					+ formatYear.format(date_ip);
			String month_tocheck = lbl_month.getText();
			while (!month_tocheck.equals(month_ip)) {
				nav_next_month.click();
				month_tocheck = lbl_month.getText();
			}
			SimpleDateFormat formatMonth_fordate = new SimpleDateFormat("MM");
			String date_tocheck = formatYear.format(date_ip)
					+ formatMonth_fordate.format(date_ip)
					+ formatDay.format(date_ip);
			for (int i = 0; i < txtbx_day.size(); i++) {
				String date_present = txtbx_day.get(i).getAttribute("id");
				if (date_present.contains(date_tocheck)) {
					txtbx_day.get(i).click();
					break;
				}

			}
		}
	}
}
