package com.Guru.project.Screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Guru.project.Framework.Reporter;
import com.Guru.project.Webutilities.WebControls;

public class Guru99BankLoginPage extends WebControls {

	@FindBy(name = "uid")
	private static WebElement username;

	@FindBy(name = "password")
	private static WebElement password;

	@FindBy(name = "btnLogin")
	private static WebElement Loginbtn;

	public void loginPage(String Uname, String Password) throws InterruptedException {

		boolean retVal;

		retVal = setEditValue(username, Uname);

		Reporter.log(retVal, "User Id entered Succefully in Guru99 Bank Login page",
				"Failed to Enter User Id  in Guru99 Bank Login page");
		
		
		Thread.sleep(5000);

		retVal = setEditValue(password, Password);

		Reporter.log(retVal, "User Password entered Succefully in Guru99 Bank Login page",
				"Failed to Enter User Password  in Guru99 Bank Login page");
		
		Thread.sleep(MID_WAIT_TIME);

		retVal = clickElement(Loginbtn);

		Reporter.log(retVal, "Clicked on Login Button Succefully in Guru99 Bank Login page",
				"Failed to Click on Login Button in Guru99 Bank Login page");
		
		
		Thread.sleep(5000);

	}

}
