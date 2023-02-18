package org.Automation_Project.demoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class demoQA_MainPage {
 
	WebDriver d;
	
	public demoQA_MainPage(WebDriver d)
	{
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//h5[contains(text(),'Elements')]")
	private WebElement Elements;
		
	@FindBy(xpath = "//h5[contains(text(),'Forms')]")
	private WebElement Forms;
	
	@FindBy(xpath = "//h5[contains(text(),'Alerts, Frame & Windows')]")
	private WebElement Alerts_Frame_Windows;

	@FindBy(xpath = "//h5[contains(text(),'Widgets')]")
	private WebElement Widgets;
	
	@FindBy(xpath = "//h5[contains(text(),'Interactions')]")
	private WebElement Interactions;

	public void Elements()
	{
		Elements.click();
	}
	
	public demoQA_FormPage Forms()
	{
		Forms.click();
		demoQA_FormPage FP = new demoQA_FormPage(d);
		return FP;
	}
	
	public void Alerts_Frame_Windows()
	{
		Alerts_Frame_Windows.click();
	}
	
	public void Widgets()
	{
		Widgets.click();
	}
	
	public void Interactions()
	{
		Interactions.click();
	}
	
	
}
