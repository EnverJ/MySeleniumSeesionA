package com.qa.hubspot.allMyTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.pages.LoginPageNPF;

public class LoginPageTestNPF {
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPageNPF loginpageNPF;
	@BeforeMethod
	public void setup(){
		basepage=new BasePage();
	prop=basepage.init_proprities();
	driver=basepage.Inti_Driver(prop);
	loginpageNPF=new LoginPageNPF(driver);
	}
	@Test(priority=1)
	public void verifysignUpLinkTest(){
		
		Assert.assertTrue(loginpageNPF.verifySignuolinkisDispalyed());
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
