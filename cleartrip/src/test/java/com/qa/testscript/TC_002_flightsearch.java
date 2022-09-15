package com.qa.testscript;

import org.testng.annotations.Test;
import com.qa.pages.flightpages;

public class TC_002_flightsearch extends TestBase
{
	@Test
	public void validateSearchTxtField() {
		
	
		boolean displayed = fpages.getSearchTxtField().isDisplayed();
		if(displayed) {
			System.out.println("Element is displayed");
			String text = fpages.getSearchTxtField().getText();
			if(text.isBlank()) {
				System.out.println("Text field is empty");
			}else {
				System.out.println("Text field is not empty");
			}
		}else {
			System.out.println("Element is not present on the page");
		}
		

	}
}
