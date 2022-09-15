package com.qa.testscript;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.testscript.TestBase;
import com.qa.utility.ExcelUtility;
import com.qa.pages.*;
public class TC_001_flightsearch extends TestBase
{
	private int rowCount;
  @Test(dataProvider="getData")
 
  public void searchItem(String Totrip,String Fromtrip) throws InterruptedException,IOException 
  {
	  SoftAssert SAssert = new SoftAssert();
	   Actions builder=new Actions(driver);
	    fpages.getradiocheck();
	    fpages.setfromfield().clear();
		 fpages.setfromfield().sendKeys(Totrip);    
	 fpages.setTofield().sendKeys(Fromtrip);
	 boolean contains = driver.getTitle().contentEquals(Totrip);
	 if(contains) {
			SAssert.assertTrue(true);		
			Reporter.log("Title has the search term",true);
			List<WebElement> allItems = fpages.getAllItems();
			System.out.println("Total no. of items loaded are : " +  allItems.size());

			for(WebElement item:allItems) {
				
				Reporter.log(item.getText());
		}
	 
  }
  else 
  {
		captureScreenshot(driver,"searchItem");
		SAssert.assertTrue(false);
		Reporter.log("Incorrect title",true);
	}
	 SAssert.assertAll();
}
  @DataProvider
	public String[][] getData() throws IOException {
		
		String xFile="C:\\eclipse\\cleartrip\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String xSheet="Sheet1";
		
		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}
		return data;
		
}
}