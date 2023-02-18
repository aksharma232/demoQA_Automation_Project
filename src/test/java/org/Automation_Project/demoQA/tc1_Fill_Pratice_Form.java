package org.Automation_Project.demoQA;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class tc1_Fill_Pratice_Form extends demoQA_BaseClass
{
  
	WebDriver d;
  @Test
  public void fill_Pratice_Form() throws IOException, InterruptedException 
  {
	  
	  demoQA_FormPage fp =  launchingpage().Forms();
	  fp.fill_PraticeForm_Details();
	  
	 
  
  }
}
