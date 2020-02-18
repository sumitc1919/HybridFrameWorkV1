package com.hybframe.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	//Elements
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement lnkAddNewCustomer;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement txtCustomerName;
	
	@FindBy(name="rad1")
	WebElement rdGender;
	
	@FindBy(id="dob")
	WebElement txtDob;
	
	@FindBy(name="addr")
	WebElement txtAddress;
	
	@FindBy(name="city")
	WebElement txtCity;
	
	@FindBy(name="state")
	WebElement txtState;
	
	@FindBy(name="pinno")
	WebElement txtPin;
	
	@FindBy(name="telephoneno")
	WebElement txtMobNo;
	
	@FindBy(name="emailid")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	@FindBy(name="res")
	WebElement btnReset;
	
	//Action Methods
	public void clickAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender)
	{
		rdGender.click();
	}
	
	public void custDob(String mm,String dd,String yy)
	{
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yy);
	}
	
	public void custAddress(String caddr)
	{
		txtAddress.sendKeys(caddr);
	}
	
	public void custCity(String ccity)
	{
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	
	public void custPin(int pincode) //If user pass int 
	{
		txtPin.sendKeys(String.valueOf(pincode)); //It will convert into String, cause sendkey not accpet int value
	}
	
	public void custMobNo(String mobno)
	{
		txtMobNo.sendKeys(mobno);
	}
	
	public void custEmailId(String cemailid)
	{
		txtEmail.sendKeys(cemailid);
	}
	
	public void custPassword(String cpass)
	{
		txtPassword.sendKeys(cpass);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
}
