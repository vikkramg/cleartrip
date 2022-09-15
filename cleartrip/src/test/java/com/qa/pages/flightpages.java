package com.qa.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.qa.testscript.TestBase;
public class flightpages 
{
	WebDriver driver;
	public flightpages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/label[1]/div[1]")
	WebElement radiocheck;
	
	public WebElement getradiocheck()
	{
		return radiocheck;
	}
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
     WebElement Fromfield;	
	public WebElement setfromfield()
	{
		return Fromfield;
	}
	//dropdown
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/p[1]")
	WebElement todropdown;
	public WebElement gettodropdown()
	{
		return todropdown;
	}
	//to dropdown
	@FindBy(xpath="//p[normalize-space()='Chennai, IN - Chennai Airport (MAA)']")
	WebElement fromdropdown;
	public WebElement getfromdropdown()
	{
		return fromdropdown;
	}
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[5]/div[1]/div[1]/div[1]/input[1]")
	WebElement Tofield;
	public WebElement setTofield()
	{
		return Tofield;
	}
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[4]/div[5]/div[1]/div[1]")
	WebElement Departure;
	public WebElement setDeparture()
	{
		return Departure;
	}
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/select[1]")
	WebElement Adults;
	public WebElement setAdults()
	{
		return Adults;
	}
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/select[1]")
	WebElement child;
	public WebElement setChild()
	{
		return child;
	}
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[2]/button[1]")
	WebElement SearchFlight;
	public WebElement SearchFlight()
	{
		return SearchFlight;
	}
	@FindAll(@FindBy(xpath="//body/div[@id='root']/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[7]/div[1]/div[1]/div[1]"))
	List<WebElement> AllItems;	

	public List<WebElement> getAllItems(){
		return AllItems;
	}
	@FindBy(id="//body/div[@id='root']/div[1]/main[1]/div[1]/div[1]/div[2]")
	WebElement SearchTxtField;

	public WebElement getSearchTxtField() {
		return SearchTxtField;
	}
		

}

