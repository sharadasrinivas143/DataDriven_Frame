package driverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.Functionlibrary;
import config.AppUtilPom;
import utilities.ExcelFileUtil;

   public class DriverScript extends AppUtilPom {
	
        String inputpath ="D:\\11AM_Selenium\\DDT_Framework\\FileInput\\Employee.xlsx";

		String outputpath ="D:\\11AM_Selenium\\DDT_Framework\\FileInput\\EmpResult.xlsx";

		ExtentReports report;

		ExtentTest test;
		@Test

		public void satrtTest()throws Throwable

		{

		//create object for excel file util

		ExcelFileUtil xl = new ExcelFileUtil(inputpath);

		//count no of rows in login sheet

		int rc =xl.rowcount("Login");
		report= new ExtentReports("./ExtenReports/Login.html");

		Reporter.log("No of rows are::"+rc,true);

		for(int i=1;i<=rc;i++)

		{

		test=report.startTest("Validate Login");

		test.assignAuthor("sharu");

		//read user name and password cell data

		String username =xl.getCellData("Login", i, 0);

		String password = xl.getCellData("Login", i, 1);

		//calling login method

		boolean res =Functionlibrary.verify_Login(username, password);

		if(res)

		{

		//if res is true write as login success into results cell

		xl.setcelldata("Login", i, 2, "Login success", outputpath);

		xl.setcelldata("Login", i, 3, "Pass", outputpath);

	test.log(LogStatus.PASS, "Login Success");

		}

		else 

		{

		File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screen, new File("./Screenshot/iteration/"+i+"Loginpage.png"));

		//if res is true write as login Fail into results cell
		xl.setcelldata("Login", i, 2, "Login Fail", outputpath);

		xl.setcelldata("Login", i, 3, "Fail", outputpath);

		test.log(LogStatus.FAIL, "Login Fail");

		}

		report.endTest(test);

		report.flush();

		}
		}
   }
		

		


		
		
		
		


