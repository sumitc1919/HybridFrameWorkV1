package com.hybframe.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybframe.pageObjects.AddCustomerPage;
import com.hybframe.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		//Login Process
		LoginPage lp=new LoginPage(driver); //This driver comes from BaseClass
		lp.setUsername(username); //'username' Common parameter which set in BaseClass
		logger.info("Username Entered");
		lp.setPassword(password); // --||--
		logger.info("Password Entered");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		logger.info("Providing Customer Details-----!!");
		addcust.clickAddNewCustomer();
		Thread.sleep(3000);
		addcust.custName("Sumit");
		addcust.custGender("male");
		addcust.custDob("12","20","1992");
		Thread.sleep(3000);
		addcust.custAddress("Pimple Guraw");
		addcust.custCity("Pune");
		addcust.custState("Maharashtra");
		addcust.custPin(401161);
		addcust.custMobNo("9989856236");
		
		//Every Customer have unique email id so generate email id dynamically, 
		//follow next method 'randomString()' from BaseClass
		String email=randomString()+"@gmail.com";
		addcust.custEmailId(email);
		
		addcust.custPassword("abc@123");
		addcust.clickSubmit(); 
		
		Thread.sleep(3000);
		
		
		//Validation
		logger.info("Validation Started--------!!");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("TestCase Passed");
		}
		else
		{
			logger.info("TestCase Failed");
			captureScreen(driver,"TC_AddNewCustomerTest_003");
			Assert.assertTrue(false);
		}
		
		
	}
	
	
}
