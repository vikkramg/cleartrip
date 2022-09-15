package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryPage 
{
	WebDriver driver;
	public MercuryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(name="userName")
		WebElement UnameTxtField;
		
		public WebElement getUnameTxtField() {
			return UnameTxtField;
		}
		
		@FindBy(name="password")
		WebElement PwdTxtField;
		public WebElement getPwdTxtField() {
			return PwdTxtField;
		}
		@FindBy(name="submit")
	       WebElement buttonclick;
		public WebElement getSubmitBtn()
		{
			return buttonclick;
		}
}
