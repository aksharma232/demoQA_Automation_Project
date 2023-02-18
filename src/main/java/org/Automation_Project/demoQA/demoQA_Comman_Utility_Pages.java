package org.Automation_Project.demoQA;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class demoQA_Comman_Utility_Pages 
{
  WebDriver d;
	
  public demoQA_Comman_Utility_Pages(WebDriver d) 
  {
	  this.d  = d;
	  PageFactory.initElements(d, this);
	  
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
