package org.Automation_Project.demoQA_Testcases;

import org.Automation_Project.demoQA.demoQA_FormPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tc1_Fill_Pratice_Form extends demoQA_BaseClass
{
  
	WebDriver d;
  @Test
  public void fill_Pratice_Form() throws Throwable 
  {
	  
	  demoQA_FormPage fp =  launchingpage().Forms();	  
	  fp.fill_PraticeForm_Details("Ajay","Sharma","ajay@gmail.com","Male","9664213390","Maths","Sports","Delhi", "NCR","Noida");
	 // fp.fill_PraticeForm_Details("Prashant","Pokhriyal", "ppgmail.com", "Male", "123456789", "Commerce", "Readigg", "Navi Mumbai", "NCR", "Delhi");
	  if(fp.close_Button_AfterSubmitbmit().isDisplayed())
	  {
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  Assert.assertTrue(false);
	  }
	 //fp.close_Button_AfterSubmitbmit().click();
  }
}
