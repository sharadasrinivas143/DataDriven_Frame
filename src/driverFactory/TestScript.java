package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.AddEmpPage;
import commonFunctions.LoginPage;
import config.AppUtilPom;
import utilities.ExcelFileUtil;

public class TestScript extends AppUtilPom {
	String inputpath ="D:\\11AM_Selenium\\DDT_Framework\\FileInput\\Employee.xlsx";
	String outputpath ="D:\\11AM_Selenium\\DDT_Framework\\FileInput\\EmpResults.xlsx";
	@Test
	public void startTest()throws Throwable
	{
    AddEmpPage emp =PageFactory.initElements(driver, AddEmpPage.class);
		//create object for Excel file util
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		//count no of rows in EmpData Sheet
		int rc =xl.rowcount("EmpData");
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String FirstName =xl.getCellData("EmpData", i, 0);
			String MiddleName =xl.getCellData("EmpData", i, 1);
			String Lastname =xl.getCellData("EmpData", i, 2);
			boolean res =emp.verify_Emp(FirstName, MiddleName, Lastname);
			if(res)
			{
				//write as pass into status cell
				xl.setcelldata("EmpData", i, 3, "PASS", outputpath);
			}
			else
			{
				xl.setcelldata("EmpData", i, 3, "FAIL", outputpath);

			}

		}
	}
}















