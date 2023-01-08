package com.Guru.project.Framework;


import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Guru.project.Config.Configuration;



public class BaseTestClass extends Configuration {
	
	//=========================================================================
	
	@BeforeSuite
	
	public void setupReport()
	{
		System.out.println("*************** Intializing Test Suite**************");
		Reporter.intializeReports(); 
		
		System.out.println("*************** Test Suite is initialized succefully**************");
		
	}
	//====================================================================
	
	@BeforeMethod
	
	public void launchBrowser(Method method)
	{
		CURRENT_TESTCASE=method.getName();
		
		Reporter.startTest(CURRENT_TESTCASE);
		
		System.out.println("<<TestStart>> TestCase Name " + CURRENT_TESTCASE + "<<TestStart>>");
		
		switch(BROWSER_NAME)
		{
		case "FF":
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir","//drivers//geckodriver.exe"));
		driver=new FirefoxDriver();
		break;
		
		
		case"IE":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir","//drivers//IEDriverServer.exe"));
			driver=new InternetExplorerDriver();
			break;
			
		case"CHROME":
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\eclipse-workspace\\RealTimeProject_2021_Dec\\Drivers\\chromedriver.exe");
			
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir","//Drivers//chromedriver.exe"));
			
		
			driver=new ChromeDriver();
			break;
			
		case"EDGE":
			System.setProperty("webdriver.gecko.driver","C:\\Users\\vinay\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
			driver=new EdgeDriver();
			break;
			
			default:System.out.println("Incorrect browser name ");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(APP_URL);
		
	}
	//=====================================================
	
	
	
	
	@AfterMethod
	public void closeBrowser() {
		
		System.out.println("Close Browser is initiated");
		
		Reporter.closeTest();
		driver.close();
		System.out.println("<<TestEnd>> TestCase Name " + CURRENT_TESTCASE + "<<TestEnd>>");
		System.out.println();
		
	}
	
	@AfterSuite
	
	public void flushReportsAndOpen() {
		
	
		
		
		  try { Reporter.flushReport(); Thread.sleep(2000);
		  
		  
		  }catch (Exception e) { e.printStackTrace();
		  
		  }
		  
		  System.setProperty("webdriver.chrome.driver",
		  "C:\\Users\\hp\\Desktop\\eclipse-workspace\\RealTimeProject_2021_Dec\\Drivers\\chromedriver.exe"
		  ); driver=new ChromeDriver(); driver.manage().window().maximize();
		  driver.get(Reporter.resultfile); driver.navigate().refresh();
		 
		
	}
	
	
	//===============================
	

}
