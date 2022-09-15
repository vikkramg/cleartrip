package com.qa.testscript;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_001_MercuryloginPage extends TestBase
{
	@Test
	public void Login() throws InterruptedException 
	{
		NewToursOR.getUnameTxtField().sendKeys(prop.getProperty("UserName"));
		Thread.sleep(2000);
		NewToursOR.getPwdTxtField().sendKeys(prop.getProperty("Password"));
		Thread.sleep(2000);
		NewToursOR.getSubmitBtn().click();
		
		String title = driver.getTitle();
		if(title.contains("Login")) 
		{
			Reporter.log("Login is successful",true);
		}else 
		{
			Reporter.log("Incorrect credentials",true);
		}
}
}
