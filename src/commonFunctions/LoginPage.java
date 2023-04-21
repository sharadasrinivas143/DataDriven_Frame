package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	//define repository for login
	@FindBy(name ="txtUsername" )
	WebElement EnterUser;
	@FindBy(name="txtPassword")
	WebElement Enterpass;
	@FindBy(name ="Submit")
	WebElement clickLogin;
	//method for login
	public void verify_Login(String username,String password)
	{
		EnterUser.sendKeys(username);
		Enterpass.sendKeys(password);
		clickLogin.click();
	}
}





