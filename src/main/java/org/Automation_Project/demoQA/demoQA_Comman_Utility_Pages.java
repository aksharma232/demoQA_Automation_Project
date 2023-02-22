package org.Automation_Project.demoQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class demoQA_Comman_Utility_Pages 
{
  WebDriver d;
	
  public demoQA_Comman_Utility_Pages(WebDriver d) 
  {
	  this.d  = d;
	 
	
	  
  }

	public void waitForElementVisibility(WebElement e)
	{
		
		WebDriverWait exwait = new WebDriverWait(d, Duration.ofSeconds(20));
		exwait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public Actions actionClass()
	{
		Actions act = new Actions(d);
		return act;
	}
  
  /*
 public void select_Dropdown_Value(WebElement e)
{
	 WebElement select_dropdown = e;
	 Select slt = new Select(select_dropdown);
	 slt.selectByValue(value);
}
 */
  
  
 







}
