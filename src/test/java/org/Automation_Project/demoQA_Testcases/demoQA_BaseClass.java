package org.Automation_Project.demoQA_Testcases;

import java.io.IOException;

import org.Automation_Project.demoQA.demoQA_MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class demoQA_BaseClass {
  
	public WebDriver d;

	@BeforeMethod
  public void launchBrowser() throws Throwable 
  {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options = new ChromeOptions();
	  options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	  d = new ChromeDriver(options);
	  d.manage().window().maximize();
	  d.get("https://demoqa.com/");	  	
	 
   }
	public demoQA_MainPage launchingpage() throws IOException
	{
		demoQA_MainPage mp = new demoQA_MainPage(d);
		return mp;
	}

@AfterMethod
public void closedBrowser() throws InterruptedException
{
		d.close();
}

}
