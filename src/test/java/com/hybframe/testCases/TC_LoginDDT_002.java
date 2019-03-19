package com.hybframe.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybframe.pageObjects.LoginPage;
import com.hybframe.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(user);
		logger.info("Username Provided");
		
		lp.setPassword(pwd);
		logger.info("Password Provided");
		
		lp.clickSubmit();
		logger.info("Click on Submit");
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //Close Alert
			driver.switchTo().defaultContent();//Focus on main page
			captureScreen(driver,"TC_LoginDDT_002");
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			driver.switchTo().alert().accept(); //Close logout alert
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	public boolean isAlertPresent()  //User define Method create to check alert is present or not
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException ex)
		{
			return false;
		}
	
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/hybframe/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);
				
			}
		}
		return logindata; 
	}
	
	
}
