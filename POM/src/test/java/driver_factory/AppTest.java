package driver_factory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import application_layer.CustomerPage;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil
{
  String Inputpath="C:\\Users\\ACER\\OneDrive\\Documents\\Sheet.xlsx";
  String Outputpath="./FileOutput/POMresult.xlsx";
  ExtentReports report;
  ExtentTest logger;
  String sheetName = "Sheet1";
 @Test
 public  void startTest() throws Throwable
 {
//	 report = new ExtentReports("./target/ExtentReports/Customer.html");
//	//create obejct for excel file util class
//		ExcelFileUtil xl = new ExcelFileUtil(Inputpath);
//		int rc = xl.rowCount(sheetName);
//		Reporter.log("No of rows are::"+rc,true);
//		for(int i=1;i<=rc;i++)
//		{
//			logger = report.startTest("Customer Validation");
//			//read all cells from CustomerData sheet
//			String CustomerName = xl.getCellData(sheetName, i, 0);
//			String Address = xl.getCellData(sheetName, i, 1);
//			String City = xl.getCellData(sheetName, i, 2);
//			String Country = xl.getCellData(sheetName, i, 3);
//			String Cperson = xl.getCellData(sheetName, i, 4);
//			String Pnumber = xl.getCellData(sheetName, i, 5);
//			String Email = xl.getCellData(sheetName, i, 6);
//			String Mnumber = xl.getCellData(sheetName, i, 7);
//			String Notes = xl.getCellData(sheetName, i, 8);
//			logger.log(LogStatus.INFO, CustomerName+"----"+Address+"---"+City+"---"+Country+"----"+Cperson+"----"+Pnumber+"----"+Email+"----"+Mnumber+"----"+Notes);
//			CustomerPage cus =PageFactory.initElements(driver, CustomerPage.class);
//			boolean res =cus.add_customer(CustomerName, Address, City, Country, Cperson, Pnumber, Email, Mnumber, Notes);
//			if(res)
//			{
//				//if res is true write as pass into status cell
//				xl.setCellData(sheetName, i, 9, "Pass", Outputpath);
//				logger.log(LogStatus.PASS, "Add Customer Success");
//			}
//			else
//			{
//				//if res is false write as Fail into status cell
//				xl.setCellData(sheetName, i, 9, "Fail", Outputpath);
//				logger.log(LogStatus.FAIL, "Add Customer Fail");
//			}
//			report.endTest(logger);
//			report.flush();
	 
		//}
	 report = new ExtentReports("./target/ExtentReports/Customer.html");
	//create obejct for excel file util class
		ExcelFileUtil xl = new ExcelFileUtil(Inputpath);
		int rc = xl.rowCount(sheetName);
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			logger = report.startTest("Customer Validation");
			//read all cells from CustomerData sheet
			
			String CustomerName = xl.getCellData(sheetName, i, 0);
			String Address = xl.getCellData(sheetName, i, 1);
			String City = xl.getCellData(sheetName, i, 2);
			String Country = xl.getCellData(sheetName, i, 3);
			String Cperson = xl.getCellData(sheetName, i, 4);
			String Pnumber = xl.getCellData(sheetName, i, 5);
			String Email = xl.getCellData(sheetName, i, 6);
			String Mnumber = xl.getCellData(sheetName, i, 7);
			String Notes = xl.getCellData(sheetName, i, 8);
			
			logger.log(LogStatus.INFO, CustomerName+"----"+Address+"---"+City+"---"+Country+"----"+Cperson+"----"+Pnumber+"----"+Email+"----"+Mnumber+"----"+Notes);
			CustomerPage cus =PageFactory.initElements(driver, CustomerPage.class);
			boolean res =cus.add_Customer(CustomerName, Address, City, Country, Cperson, Pnumber, Email, Mnumber, Notes);
			if(res)
			{
				//if res is true write as pass into status cell
				xl.setCellData(sheetName, i, 9, "Pass", Outputpath);
				logger.log(LogStatus.PASS, "Add Customer Success");
			}
			else
			{
				//if res is false write as Fail into status cell
				xl.setCellData(sheetName, i, 9, "Fail", Outputpath);
				logger.log(LogStatus.FAIL, "Add Customer Fail");
			}
			report.endTest(logger);
			report.flush();
		}
 }
}
