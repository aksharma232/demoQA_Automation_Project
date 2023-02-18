package org.Automation_Project.demoQA;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class demoQA_BaseClass {
  
	public WebDriver d;

@BeforeClass
  public void launchBrowser() 
  {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions option = new ChromeOptions();
	  d = new ChromeDriver(option);
	  d.manage().window().maximize();
	 // d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));  
	  d.get("https://demoqa.com/");
		  	  
   }
	public demoQA_MainPage launchingpage() throws IOException
	{
		demoQA_MainPage mp = new demoQA_MainPage(d);
		return mp;
	}


}
