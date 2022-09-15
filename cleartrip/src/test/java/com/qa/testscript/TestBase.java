package com.qa.testscript;
import java.io.File;
import com.qa.pages.MercuryPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.qa.pages.flightpages;

public class TestBase 
{
 WebDriver driver;
 flightpages fpages;
 FileInputStream fileLoc;
 MercuryPage NewToursOR;
	Properties prop;
 @Parameters({"Browser", "Url"})
 
	@BeforeClass
	public void setUp(String Browser,String Url)throws IOException
	{
	  fileLoc=new FileInputStream("C:\\eclipse\\cleartrip\\src\\test\\java\\com\\qa\\testdata\\credentials.properties");
	  prop=new Properties();
	  prop.load(fileLoc);
	  if(Browser.equalsIgnoreCase("Chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe" );
		  driver=new ChromeDriver();
	  }
	  else if(Browser.equalsIgnoreCase("Edge"))
	  {
		System.setProperty("webdriver.edge.driver", "C:\\webdriver\\msedgedriver.exe");
		driver=new EdgeDriver();
	  }
	  driver.get(Url);
	  driver.manage().window().maximize();
	  fpages=new flightpages(driver); 
	  NewToursOR=new MercuryPage(driver);
	  //Actions builder=new Actions(driver);
	  
	}
 @AfterClass
 public void tearDown() throws IOException
 {
	 driver.close();
 }
 public void captureScreenshot(WebDriver driver, String tName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");		
		FileUtils.copyFile(source, target);
		
	}
}
 

