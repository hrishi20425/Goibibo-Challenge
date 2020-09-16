package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader {
	static String filepath = "C:\\Users\\163278\\OneDrive - Cognizant\\Hrishi\\Automation projects\\FlightBooking\\test data\\Flight_TestData.xls";
	HashMap<String, String> data_record;
	public ArrayList<HashMap<String,String>> readData(String testdatasheet, String testcasename) {
		FileInputStream input = null;
		Workbook w = null;
		try {
			input = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			w = new HSSFWorkbook(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet testdatsheet = w.getSheet(testdatasheet);
		int maxrow = testdatsheet.getLastRowNum();
		int maxcol = testdatsheet.getRow(0).getLastCellNum();
		ArrayList<HashMap<String, String>> list_data = new ArrayList<HashMap<String, String>>();
		for (int i = 1; i <= maxrow; i++) {
			String tc = testdatsheet.getRow(i).getCell(0).getStringCellValue();
			
			if (tc.equalsIgnoreCase(testcasename)) {
				data_record = new HashMap<String, String>();
				for (int j = 1; j < maxcol; j++) {
					Cell c = testdatsheet.getRow(i).getCell(j);
					if (c.getCellType() == CellType.STRING)
						data_record.put(testdatsheet.getRow(0).getCell(j)
								.getStringCellValue(), c.getStringCellValue());
					if (c.getCellType() == CellType.NUMERIC)
						data_record.put(testdatsheet.getRow(0).getCell(j)
								.getStringCellValue(),
								String.valueOf(c.getNumericCellValue()));
				}
				list_data.add(data_record);
			}
			
		}
		try {
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_data;

	}

	public static void main(String[] args)
	{
		ExcelReader e = new ExcelReader();
		ArrayList<HashMap<String, String>> a = e.readData(
				"FlightBooking", "FlightBooking_TC001");
		for(HashMap<String,String> h: a)
		{
			System.out.println(h);
		}
	}
}
