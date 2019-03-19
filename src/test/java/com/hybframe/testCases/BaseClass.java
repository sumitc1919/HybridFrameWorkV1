package com.hybframe.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.hybframe.utilities.ReadConfig;

public class BaseClass 
{
	ReadConfig readconfig=new ReadConfig();

	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("hybframe");
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("usr.dir")+ "//Drivers//chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\AM-N8\\eclipse-workspace\\HybridFrameWorkV1\\Drivers\\chromedriver.exe");
		if(br.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFireFoxPath());
			driver=new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	
		//Capture Screenshot Method
		public void captureScreen(WebDriver driver, String tname) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target=new File(System.getProperty("user.dir")+ "/Screenshot/"+tname+".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot Taken");
		}
		
		public String randomString()
		{
			//'RandomStringUtils'predefine Class in java & 
			//'randomAlphabetic(8)' method is used to generate random char w.r.t pass count char.
			String generatedString=RandomStringUtils.randomAlphabetic(8); 
			return(generatedString);
		}
		
		public String randomNum()
		{
			//'RandomStringUtils'predefine Class in java & 
			//'randomAlphanumeric(8)' method is used to generate random number w.r.t. pass count char.
			String generatedString2=RandomStringUtils.randomAlphanumeric(10); 
			return(generatedString2);
		}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
