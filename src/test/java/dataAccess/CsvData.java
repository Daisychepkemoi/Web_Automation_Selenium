package dataAccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.*;
import org.apache.poi.xssf.usermodel.*;

 

public class CsvData

{
	
	private static XSSFSheet ExcelWSheet;
	   private XSSFWorkbook ExcelWBook;
	   
	   //Constructor to connect to the Excel with sheetname and Path
	   public CsvData(String Path, String SheetName) throws Exception {
	   
	      try {
	         // Open the Excel file
	         FileInputStream ExcelFile = new FileInputStream(Path);
	         
	         // Access the required test data sheet
	         ExcelWBook = new XSSFWorkbook(ExcelFile);
	         ExcelWSheet = ExcelWBook.getSheet(SheetName);
	      } catch (Exception e) {
	         throw (e);
	      }
	   }
	      
	   //This method is to set the rowcount of the excel.
	   public static int excel_get_rows() throws Exception {
	   
	      try {
	         return ExcelWSheet.getPhysicalNumberOfRows();
	      } catch (Exception e) {
	         throw (e);
	      }
	   }
	   
	   //This method to get the data and get the value as strings.
	   public static String getCellDataasstring(int RowNum, int ColNum) throws Exception {
	   
	      try {
	         String CellData =
	            ExcelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
	         System.out.println("The value of CellData " + CellData);
	         return CellData;
	      } catch (Exception e) {
	         return "";
	      }
	   }
	   
	   //This method to get the data and get the value as number.
	   public static double getCellDataasnumber(int RowNum, int ColNum) throws Exception {
	   
	      try {
	         double CellData =
	            ExcelWSheet.getRow(RowNum).getCell(ColNum).getNumericCellValue();
	         System.out.println("The value of CellData " + CellData);
	         return CellData;
	      } catch (Exception e) {
	         return 000.00;
	      }
	   }
	}
//
//     public static void  exec() {
//try {
//CsvData  dd = new CsvData ("C:\\Users\\dchepkemoi\\eclipse-workspace2\\Automation\\testData.xlsx","Sheet1");
//System.out.println("The Row count is " + dd.excel_get_rows());
//int rowCount = CsvData.excel_get_rows();
//for (int i=1;i<rowCount;i++){
//
//  	   fname=CsvData.getCellDataasstring(i, 0);
//
//      lname=CsvData.getCellDataasstring(i, 1);
//      pcode=CsvData.getCellDataasstring(i, 2);
//      successMsg = CsvData.getCellDataasstring(i, 3);
//      
//      System.out.println(fname + "this is the first name");
//      System.out.println(lname + "this is the  last");
//      System.out.println(pcode + "this is the  pcode");
//      System.out.println(successMsg + "this is the  message");
//      
//   	WebElement firstNameInput = driver.findElement(By.xpath("//*[@ng-model='fName']"));
//   	firstNameInput.sendKeys(fname);
//   	WebElement lastNameInput = driver.findElement(By.xpath("//*[@ng-model='lName']"));
//   	lastNameInput.sendKeys(lname);
//   	WebElement postCodeInput = driver.findElement(By.xpath("//*[@ng-model='postCd']"));
//   	postCodeInput.sendKeys(pcode);
//   	WebElement submitCustomerDetailsBtn = driver.findElement(By.xpath("//*[text() = 'Add Customer']"));
//   	submitCustomerDetailsBtn.click();
//   	wait = new WebDriverWait(driver, 3);
//   	firstNameRequiredAttribute = driver.findElement(By.xpath("//*[@ng-model='fName']")).getAttribute("validationMessage");
//   	lastNameRequiredAttribute= driver.findElement(By.xpath("//*[@ng-model='lName']")).getAttribute("validationMessage");
//   	postCodeRequiredAttribute = driver.findElement(By.xpath("//*[@ng-model='postCd']")).getAttribute("validationMessage");
//   	System.out.println("Fist name   " +firstNameRequiredAttribute );
//   	System.out.println("Last name   " +lastNameRequiredAttribute );
//   	System.out.println("PostCode    " +postCodeRequiredAttribute );
//   	
//   	System.out.println("Fname   " +fname );
//   	System.out.println("lname   " +lname );
//   	System.out.println("pcode    " +pcode );
//   	
//   	if(firstNameRequiredAttribute.length() >0) {
//   		System.out.println("I am here");
//   		Assert.assertTrue(firstNameRequiredAttribute.contains(successMsg));
//   	}
//   	else if(firstNameRequiredAttribute.length() <=0 && lastNameRequiredAttribute.length() >0){
//   		System.out.println("I am here again");
//   		Assert.assertTrue(lastNameRequiredAttribute.contains(successMsg));
//   	}
//   	else if(firstNameRequiredAttribute.length() <=0 && lastNameRequiredAttribute.length()<=0 && postCodeRequiredAttribute.length()>0) {
//   		System.out.println("and i am here");
//   		Assert.assertTrue(postCodeRequiredAttribute.contains(successMsg));
//   	}
//   	else {
////   		Alert alert = driver.switchTo().alert();
////	Thread.sleep(5);
//	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//	String CustomerCreatedSuccessfullyAlertText = alert.getText();
//	System.out.println("this is my response" + CustomerCreatedSuccessfullyAlertText);
//	Thread.sleep(5);
//	alert.accept();
////	Assert.assertEquals(CustomerCreatedSuccessfullyAlertText,Message);
//   		
//       }
//}
//}
//catch(Exception e) {
//	e.printStackTrace();
//}
//}