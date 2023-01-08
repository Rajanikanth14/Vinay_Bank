package com.Guru.project.Screenpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Guru.project.Framework.Reporter;
import com.Guru.project.Webutilities.WebControls;

public class Guru99BankAddCustomerPage extends WebControls {
	
		@FindBy(xpath="//a[text()='New Customer']")
		private static WebElement newcustomer;
		
		@FindBy(name = "name")
		private static WebElement customername;
		
		@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")  
		private static WebElement gender;        
		@FindBy(id="dob")
		private static WebElement dateofbirth;
		
		@FindBy(name="addr")
		private static WebElement address;
		
		@FindBy(name="city")
		private static WebElement city;
		
		@FindBy(name="state")
		private static WebElement state;
		
		@FindBy(name="pinno")
		private static WebElement pinnumber;
		
		@FindBy(name="telephoneno")
		private static WebElement mobilenumber;
		
		@FindBy(name="emailid")
		private static WebElement emailid;
		
		@FindBy(name="password")
		private static WebElement password;
		
		@FindBy(name="sub")
		private static WebElement submit;
		
		public void addCustomerPage(String Cname, String dob, String addr, String City, String State, String Pinno,String Mobileno,String emid,String Password) throws InterruptedException {
			
			boolean retVal;
			
			retVal = clickElement(newcustomer);
			
			Reporter.log(retVal,"Clicked on New Customer Tab Succefully in Guru99 Bank Manager page",
					"Failed to Enter Customer name in Guru99 Bank Manager page");
			
			
			driver.navigate().refresh();
			
			//driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
			
			
			 clickElement(newcustomer);
			
			retVal= setEditValue(customername, Cname);
			
			Reporter.log(retVal,"Customer name entered Succefully in Guru99 Bank Add customer page",
					"Failed to Enter Customer name in Guru99 Bank Add customer page");
			
			retVal = clickElement(gender);

			Reporter.log(retVal, "Clicked on radio Button Succefully in Guru99 Bank Add customer page",
					"Failed to Click on radio Button in Guru99 Bank Add customer page");		
			
			retVal = setEditValue(dateofbirth, dob);
			
			Reporter.log(retVal,"Date of Birth entered Succefully in Guru99 Bank Add customer page",
					"Failed to Enter Date of Birth in Guru99 Bank Add customer page");
			
			retVal = setEditValue(address, addr);
			
			Reporter.log(retVal,"Address entered Succefully in Guru99 Bank Add customer page",
					"Failed to Enter Address in Guru99 Bank Add customer page");
			
			retVal = setEditValue(city, City);
			
			Reporter.log(retVal,"City entered Succefully in Guru99 Bank Add customer page",
					"Failed to Enter City in Guru99 Bank Add customer page");
			
			retVal = setEditValue(state, State);
			
			Reporter.log(retVal,"State entered Succefully in Guru99 Bank Add customer page",
					"Failed to Enter State in Guru99 Bank Add customer page");
			
			retVal = setEditValue(pinnumber, Pinno);
			
			Reporter.log(retVal,"Pinnumber entered Succefully in Guru99 Bank Add customer page",
					"Failed to Enter Pinnumber in Guru99 Bank Add customer page");
			
			retVal = setEditValue(mobilenumber, Mobileno);
			
			Reporter.log(retVal,"Mobilenumber entered Succefully in Guru99 Bank Add customer page",
					"Failed to Enter Mobilenumber in Guru99 Bank Add customer page");
			
			retVal = setEditValue(emailid, emid);
			
			Reporter.log(retVal,"Email Id entered Succefully in Guru99 Bank Add customer page",
					"Failed to Enter Email Id in Guru99 Bank Add customer page");
			
			retVal = setEditValue(password, Password);
			
			Reporter.log(retVal,"Password entered Succefully in Guru99 Bank Add customer page",
					"Failed to Enter Password in Guru99 Bank Add customer page");
			
			retVal = clickElement(submit);

			Reporter.log(retVal, "Clicked on submit Button Succefully in Guru99 Bank Add customer page",
					"Failed to Click on submit Button in Guru99 Bank Add customer page");
						
		}

	}

