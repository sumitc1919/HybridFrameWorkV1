package com.hybframe.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybframe.pageObjects.LoginPage;

public class TC_LoginTest extends BaseClass 
{
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("URL is open");

		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info("Username Entered");
		
		lp.setPassword(password);
		logger.info("Password Entered");
		
		lp.clickSubmit();
		logger.info("Clicked on Login");
		
		
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else
		{
			captureScreen(driver,"TC_LoginTest_001");
			Assert.assertTrue(false);
			logger.info("Test Case Failed");
		}
	}
	
}
