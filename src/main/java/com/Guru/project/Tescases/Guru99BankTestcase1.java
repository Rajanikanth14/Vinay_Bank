package com.Guru.project.Tescases;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Guru.project.Framework.BaseTestClass;
import com.Guru.project.Framework.EXcellib;
import com.Guru.project.Screenpages.Guru99BankAddCustomerPage;
import com.Guru.project.Screenpages.Guru99BankLoginPage;

public class Guru99BankTestcase1 extends BaseTestClass {
	
	
	@Test
	
	public static  void TC_001_Guru99_Bank_LoginTest() throws InterruptedException {
		
		
		//Fetching data from TestData Sheet and calling function From ScreenPages
		
		String filepath= TESTDATA_PATH + TESTDATA_FILE;
		
		HashMap<String, String> data=EXcellib.getRowData2(filepath, "LoginPage", CURRENT_TESTCASE);
		
		
		Guru99BankLoginPage glogin=PageFactory.initElements(driver, Guru99BankLoginPage.class);
		
		
		glogin.loginPage(data.get("Uname"), data.get("Password"));
		
		
		

		HashMap<String,String> data1 = EXcellib.getRowData2(filepath, "AddCustomerPage", "TC_002_Guru99_Bank_AddCustomerPage");
				
		com.Guru.project.Screenpages.Guru99BankAddCustomerPage add_cust_page = PageFactory.initElements(driver, Guru99BankAddCustomerPage.class);
		
	
		
		add_cust_page.addCustomerPage(data1.get("Cname"),data1.get("dob"),data1.get("addr"),data1.get("City"),data1.get("State"),data1.get("Pinno"),data1.get("Mobileno"),data1.get("emid"), data1.get("Password"));
		
	}
	
	
	
	

}
