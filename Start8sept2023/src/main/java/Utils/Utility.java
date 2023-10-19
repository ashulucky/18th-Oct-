package Utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

		// 2 methods
		// 1 -> to get the data from excel sheet
       //  2 -> to capture the Screenshot

	public static String getDataFromExcelsheet(String filepath,String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		String data = "";
		String filepath1 ="src\\test\\resources\\Dataprovider\\Loginfile.xlsx";
		FileInputStream file = new FileInputStream(filepath1);
		 Workbook workbook=WorkbookFactory.create(file);
		 Sheet excelSheet = workbook.getSheet(sheet);
		 Row excelRow = excelSheet.getRow(row);
		 Cell excelCell = excelRow.getCell(cell);
		 try
		 {
			 data = excelCell.getStringCellValue();
		 }
		 catch(Exception e)
		 {
			 double value = excelCell.getNumericCellValue();
			 data=String.valueOf(value);	 
		 }
		 file.close();
		 return data;
		 
		 
		
	}
		
			
			
		public static void capturefailScreenshot(WebDriver driver,String testId) throws IOException, InterruptedException
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
			String currentDateTime = dateFormat.format(new Date());
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File dest = new File("test-output\\FailedScreenShot\\"+testId+currentDateTime+".png");
			FileHandler.copy(src, dest);
			Thread.sleep(2000);
		}
			
			
			
	}



