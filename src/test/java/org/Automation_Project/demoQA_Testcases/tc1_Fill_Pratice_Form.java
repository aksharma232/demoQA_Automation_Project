package org.Automation_Project.demoQA_Testcases;

import org.Automation_Project.demoQA.demoQA_FormPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tc1_Fill_Pratice_Form extends demoQA_BaseClass
{
  
	WebDriver d;
  @Test (dataProvider = "student_Form")
  public void fill_Pratice_Form(String student_FN,String student_LN, String student_EmailID,String student_Gender, String student_MobileNumber,String student_Subject, String student_Hobby, String student_Address, String student_State, String student_City) throws Throwable 
  {
	  
	  demoQA_FormPage fp =  launchingpage().Forms();	  
	  //fp.fill_PraticeForm_Details(student_FN,student_LN, student_EmailID, student_Gender, student_MobileNumber,student_Subject, student_Hobby, student_Address,student_State, student_City);
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
	fp.close_Button_AfterSubmitbmit().click();

  }

@DataProvider
public String[][] student_Form()
{
	String student_Data[][] = {{"Ajay","Sharma","ajay@gmail.com","Male","9664213390","Maths","Sports","Delhi","NCR","Noida"}};
	return student_Data;
}





}
