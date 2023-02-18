package org.Automation_Project.demoQA;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class demoQA_FormPage 
{
	WebDriver d;
	
	public demoQA_FormPage(WebDriver d)
	{
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
	
	@FindBy(xpath = "///div[@id='hobbiesWrapper']//div[@class='col-md-9 col-sm-12']")
	List <WebElement> hobbiesWrapper;
	
	@FindBy(id = "currentAddress")
	private WebElement currentAddress;
	
	@FindBy(xpath = "//div[contains(text(),'Select State')]")
	private WebElement state;
	
	@FindBy(xpath = "//div[@class=' css-1wa3eu0-placeholder']")
	private WebElement city;
	
	@FindBy(id = "submit")
	private WebElement submit;
	
	
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
	
	/*
	public List<WebElement> gender()
	{
		return gender;
	}
	
	
	public void genderSelection(String stud_gender)
	{
		String genderSelection = stud_gender;
		System.out.println(genderSelection);
		for(int i=0; i<=gender.size();i++)
		{
			System.out.println(gender.get(i).getText());
			if(genderSelection.equalsIgnoreCase(gender.get(i).getText()))
			{
				gender.get(i).click();
			}
			else 
			{
				System.out.println("Invalid Gender ");
			}
		}
				
	}
	*/
	
			
	public void fill_PraticeForm_Details()
	{
		openForms.click();
		practiceForm.click();
		firstName.sendKeys("Vijay");
		lastName.sendKeys("Verma");
		if(testUsingStrictRegex("ajay@gmail.com"))
				{
				userEmail.sendKeys("ajay@gmail.com");
				}
		else
		{
			System.out.println("Invalid data");
		}
		genderSelection("female");
	}
	
	public boolean testUsingStrictRegex(String email)
	{
	   String email1 = email;
	     String regexPattern1 =  "[a-zA-Z0-9\\-\\.\\_]+[@][a-z]+[\\.][a-z]{1,10}";
	     Pattern p = Pattern.compile(regexPattern1);
	     Matcher m = p.matcher(email1);
	     return m.matches();	    
	}
	
	
	
}
