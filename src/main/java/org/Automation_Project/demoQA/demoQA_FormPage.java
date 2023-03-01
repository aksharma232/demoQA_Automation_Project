package org.Automation_Project.demoQA;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;

public class demoQA_FormPage extends demoQA_Comman_Utility_Pages
{
	WebDriver d;
	Pattern p;
	Matcher m;
	
	public demoQA_FormPage(WebDriver d)
	{
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath = "//div[contains(@class,'header-text')][normalize-space()='Forms']")
	private WebElement openForms;
	
	@FindBy(xpath = "//span[normalize-space()='Practice Form']")	
	private WebElement practiceForm;
	
	@FindBy(id = "firstName")
	private WebElement firstName;
	
	@FindBy(id = "lastName")
	private WebElement lastName;
	
	@FindBy(id = "userEmail")
	private WebElement userEmail;
	
	@FindBy(xpath = "//label[normalize-space()='Female']")
	private WebElement female_gender;
	
	@FindBy(xpath = "//label[normalize-space()='Male']")
	private WebElement male_gender;
	
	@FindBy(xpath = "//label[normalize-space()='Other']")
	private WebElement other_gender;
	
	@FindBy(id = "userNumber")
	private WebElement userNumber;
	
	@FindBy(id = "dateOfBirthInput")
	private WebElement dateOfBirthInput;
	
	@FindBy(xpath = "//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")
	private WebElement subject;
	
	@FindBy(id = "react-select-2-option-0")
	private WebElement subjectSelection; 
	
	@FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class = 'custom-control-label']")	
	private List <WebElement> hobbiesWrapper;	
	
	@FindBy(id = "currentAddress")
	private WebElement currentAddress;
	
	@FindBy(xpath = "//div[contains(text(),'Select State')]")
	private WebElement state;
	
	//@FindBy(xpath = "//div[@class =\" css-11unzgr\"]//div")
	@FindBy(xpath = "//div[@class = \" css-1i1mafy\"]/div")
	private List<WebElement> stateList;
	
	
	@FindBy(xpath = "//div[@class=' css-1wa3eu0-placeholder']")
	private WebElement city;
	
	@FindBy(xpath = "//div[@class=\" css-11unzgr\"]//div")
	private List<WebElement> cityList;
	
	@FindBy(id = "submit")
	private WebElement submit;	
	
	@FindBy(id = "closeLargeModal")
	private WebElement close_Button_AfterSubmitbmit;	
	
	public void fill_PraticeForm_Details(String student_FN,String student_LN, String student_EmailID,String student_Gender, String student_MobileNumber,String student_Subject, String student_Hobby, String student_Address, String student_State, String student_City) throws Throwable
	{
		//openForms.click();
		practiceForm.click();
		firstName.sendKeys(student_FN);
		lastName.sendKeys(student_LN);
		verified_emailId(student_EmailID);
		genderSelection(student_Gender);		
		studentMobile(student_MobileNumber);
		dateOfBirthInput.click();
		dobSelection("22","5","1992");
		subject(student_Subject);
		hobbies_Selection(student_Hobby);
		currentAddress.sendKeys(student_Address);
		select_State(student_State);
		select_City(student_City);
		submit.click();
	}
	
	
//EmailID verification - 	
	/*
	public boolean student_EmailId(String email)
	{
		 //String email1 = email;
	     String regexPattern1 =  "[a-zA-Z0-9\\-\\.\\_]+[@][a-z]+[\\.][a-z]{1,10}";
	     p = Pattern.compile(regexPattern1);
	     m = p.matcher(email);
	     return m.matches();
	}     
	*/
	public void verified_emailId(String email)
	{
		//boolean a  = student_EmailId(email);
		String regexPattern1 =  "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		p = Pattern.compile(regexPattern1);
	    m = p.matcher(email);	    
		if(m.matches())
	    {
			userEmail.sendKeys(email);
		}
		else
		{
			System.out.println("Invalid email ID");
			userEmail.sendKeys("Recevied Invalid email ID");
		}
	}
	
//Gender Selection -

	public void genderSelection(String stud_gender)
	{
		if(stud_gender.equalsIgnoreCase("Male"))
		{
			male_gender.click();
		}
		else if(stud_gender.equalsIgnoreCase("female"))
		{
			female_gender.click();
		}
		else
		{
			other_gender.click();
		}
	}	
	
//Mobile Verification -
	
	public void studentMobile(String mobileNumber)
	{
		String regexMobilePattern = "\\d*";
		 p = Pattern.compile(regexMobilePattern);	
		 m = p.matcher(mobileNumber); 
		boolean matches = m.matches();
		if(matches)
		{
			userNumber.sendKeys(mobileNumber);
		}
		else
		{
			System.out.println("Invalid Mobile Number");
		}
		
   	}

//Date of Birth Selection -
	
	public void dobSelection(String date,String month, String year )
	{
		Select months = new Select(d.findElement(By.xpath("//*[@class=\"react-datepicker__month-select\"]")));
		months.selectByValue(month);
		
		Select birthyear = new Select(d.findElement(By.xpath("//*[@class=\"react-datepicker__year-select\"]")));
		birthyear.selectByValue(year);
		
		WebElement birthdate = d.findElement(By.xpath("//div[contains(text(),'"+date+"')]"));
		birthdate.click();		
	}

//Hobbies Selection -
	
	public void hobbies_Selection(String hobbyList)
	{
		for(int i=0; i< hobbiesWrapper.size();i++)
		{
			String hobby = hobbiesWrapper.get(i).getText();
			if(hobbyList.equalsIgnoreCase(hobby))
			{
				hobbiesWrapper.get(i).click();
			}
		}
	}
	
//Subject Selection - 	
	
	public void subject(String selectedSubject)
	{
		actionClass().moveToElement(subject).click().build().perform();
		actionClass().moveToElement(subject).sendKeys("Maths").build().perform();
		actionClass().moveToElement(subjectSelection).click().build().perform();
		
	}
	
//State Selection
	
	public void select_State(String student_State) throws Throwable
	{
		boolean e = false;
		state.click();
		for(int i =0;i< stateList.size();i++)
			{
				if(stateList.get(i).getText().equalsIgnoreCase(student_State))
					{
						stateList.get(i).click();
						System.out.println(stateList.get(i).getText());
						e = d.findElement(By.xpath("//div[@class =\" css-1uccc91-singleValue\"]")).isDisplayed(); 
						//e = stateList.get(i).isDisplayed();
					}
		}
		if(e)
		{
			System.out.println("State selected");
		}
		else
		{
			System.out.println("Invaid State");
		}
	}
	
//City Selection -
	public void select_City(String student_City) throws InterruptedException
	{
		boolean s = false;
		city.click();
				
		for(int i =0; i<cityList.size();i++)
			{
				if(cityList.get(i).getText().equalsIgnoreCase(student_City))
					{
						cityList.get(i).click();
						System.out.println(cityList.get(i).getText());
						s = d.findElement(By.xpath("//div[@class =\" css-1uccc91-singleValue\"]")).isDisplayed();
					}
			}
		if(s)
		{
			System.out.println("City is selected");
		}
		else
		{
			System.out.println("Please enter the correct city");
		
		}
	}
//Return Successfull -
	
	public WebElement close_Button_AfterSubmitbmit()
	{
		return close_Button_AfterSubmitbmit;
	}
}
