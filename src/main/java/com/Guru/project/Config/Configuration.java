package com.Guru.project.Config;

import org.openqa.selenium.WebDriver;

public class Configuration {
	
	public static WebDriver driver;
	
	public static String CURRENT_TESTCASE=null;
	
	public static String DEV_URL ="";
	
	public static String APP_URL="https://demo.guru99.com/v4/";
	
	public static String BROWSER_NAME="CHROME";
	
	public static String PROJECTNAME="Guru99";
	
	public static String RELEASENAME="First Release";
	
	public static String ENVIRONMENT ="QA";
	
	public static String TESTDATA_PATH=System.getProperty("user.dir") + "\\TestData\\";
	public static String TESTDATA_FILE="\\Guru99BankTestDataSheet.xlsx";
	
	public static String RESULTS_PATH =System.getProperty("user.dir") + "\\Reports\\";
	
	public static String RESULTS_FILE="\\Guru99BankAPPReport.html";
	
	public static  int MAX_WAIT_TIME=10;
	
	public static  int MID_WAIT_TIME=5;
	
	public static  int MIN_WAIT_TIME=2;
	
}
