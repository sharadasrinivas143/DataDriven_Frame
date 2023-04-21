package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmpPage {
	WebDriver driver;
	//constructor
	public AddEmpPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	//define repository
	@FindBy(xpath = "//b[normalize-space()='PIM']")
	WebElement clickpim;
	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement clickAddbtn;
	@FindBy(name ="firstName" )
	WebElement EnterFname;
	@FindBy(name ="middleName")
	WebElement EnterMname;
	@FindBy(name ="lastName" )
	WebElement EnterLname;
	@FindBy(xpath = "//input[@id='employeeId']")
	WebElement BeforeEid;
	@FindBy(id ="btnSave")
	WebElement clicksaveBtn;
	@FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
	WebElement AfterEid;
	public boolean verify_Emp(String fname,String mname,String lname)  
	{
		Actions ac =new Actions(driver);
		ac.moveToElement(this.clickpim).click().perform();
		ac.moveToElement(this.clickAddbtn).click().perform();
		this.EnterFname.sendKeys(fname);
		this.EnterMname.sendKeys(mname);
		this.EnterLname.sendKeys(lname);
		//capture eid
		String ExpectedEid =this.BeforeEid.getAttribute("value");
		ac.moveToElement(this.clicksaveBtn).click().perform();
		String ActualEid =this.AfterEid.getAttribute("value");
		
//		clickpim.click();
//		Thread.sleep(2000);
//		clickAddbtn.click();
//		EnterFname.sendKeys(fname);
//		EnterMname.sendKeys(mname);
//		EnterLname.sendKeys(lname);
//		String ExpectedEid =this.BeforeEid.getAttribute("value");
//		clicksaveBtn.click();
//		String ActualEid =this.AfterEid.getAttribute("value");
		
		if (ExpectedEid.equals(ActualEid)) 
		{
			Reporter.log("Add Employee Success::"+ExpectedEid+"  "+ActualEid,true);
			return true;
		}
		else
		{
			Reporter.log("Add Employee Success::"+ExpectedEid+"  "+ActualEid,true);
			return false;
		}
	}

}

