package com.qa.hubspot.allMyTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.constance.constance;
import com.qa.hubspot.listeners.pdfListener;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
@Listeners(pdfListener.class)
public class HomePagetTest {
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	HomePage homepage;
	LoginPage loginpage;
	@BeforeMethod
	public void SetUp(){
		basepage=new BasePage();
		prop=basepage.init_proprities();
		driver=basepage.Inti_Driver(prop);
		loginpage=new LoginPage(driver);
		homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=1)
	public void HomePageTitle(){
		String title=homepage.getHomePageTitle();
		System.out.println("HomePage Title is: "+ title);
		Assert.assertEquals(title,constance.Home_page_title);
		
	}
	@Test(priority=2) 
	public void dashBoard(){
		Assert.assertTrue(homepage.verifyDashBoard());
		Assert.assertTrue(true, constance.DashBoard_title);
		
	}
	@Test(priority=3)
	public void AccounName(){
		Assert.assertTrue(homepage.verifyAccount());
		Assert.assertEquals(homepage.getAccountName(), constance.accountname);
	}
	@AfterMethod
	
	public void TearDown(){
		driver.quit();
	}
	
	
	

}
