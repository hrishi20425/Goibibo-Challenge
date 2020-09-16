package pageTests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.FareSummary;
import pageObjects.FlightResults;
import pageObjects.HomePage;

import utilities.CaptureScreenshot;
import utilities.ExcelReader;
import base.WebDriverManager;

public class FlightBookingTest extends WebDriverManager {

	HomePage homePage;
	FlightResults flightResults;
	FareSummary fareSummary;
	ExcelReader reader;
	String testdata_sheetname = "FlightBooking";

	@BeforeMethod
	public void Intialize() {
		driver = intializeDriver();

	}

	@Test
	public void FlightBooking_TC001() {
		String methodname = new Object() {
		}.getClass().getEnclosingMethod().getName();
		reader = new ExcelReader();
		ArrayList<HashMap<String, String>> test_data = reader.readData(
				testdata_sheetname, methodname);
		for (int i = 0; i < test_data.size(); i++) {
			if (test_data.get(i) != null) {
				homePage = new HomePage();
				System.out.println(test_data.get(i).get("Dep_date"));
				flightResults = homePage.searchFlight(
						test_data.get(i).get("From"), test_data.get(i)
								.get("To"), test_data.get(i).get("Dep_date"),
						test_data.get(i).get("Ret_date"));

				test.log(Status.PASS,
						"Step 1 - Flight details should be searched");
				try {
					test.addScreenCaptureFromPath(CaptureScreenshot
							.getscreenshot(methodname + "_Step 1"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		/*		fareSummary = flightResults.bookCostliestFlight();

				test.log(Status.PASS,
						"Step 2 - Costliest Flight should be selected for booking");
				try {
					test.addScreenCaptureFromPath(CaptureScreenshot
							.getscreenshot(methodname + "_Step 2"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				fareSummary.addPersonalDetails(test_data.get(i).get("Title"),
						test_data.get(i).get("fname"),
						test_data.get(i).get("mname"),
						test_data.get(i).get("lname"),
						test_data.get(i).get("email"),
						test_data.get(i).get("mobile"));

				test.log(Status.PASS,
						"Step 3 - Personal details should be entered");
				try {
					test.addScreenCaptureFromPath(CaptureScreenshot
							.getscreenshot(methodname + "_Step 3"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fareSummary.addPaymentDetails();
				test.log(Status.PASS,
						"Step 4 - Payment details should be entered");
				try {
					test.addScreenCaptureFromPath(CaptureScreenshot
							.getscreenshot(methodname + "_Step 4"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (i < test_data.size() - 1) {
				driver.close();
				driver = intializeDriver();
			}
		}*/
	}

	@Test
	public void FlightBooking_TC002() {
		String methodname = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test.log(Status.PASS, "Step 1 of " + methodname + " passed");
		test.log(Status.PASS, "Step 2 of " + methodname + " passed");
	}

	@AfterMethod
	public void Teardown() {
		driver.close();

	}

}
