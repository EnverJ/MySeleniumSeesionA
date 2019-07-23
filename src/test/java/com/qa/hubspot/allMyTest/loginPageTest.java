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
import com.qa.hubspot.pages.LoginPage;
@Listeners(pdfListener.class)
public class loginPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	@BeforeMethod
	public void setup(){
		basepage=new BasePage();
	prop=basepage.init_proprities();
	driver=basepage.Inti_Driver(prop);
	loginpage=new LoginPage(driver);
		
	}
	@Test(priority=1 )
	public void verifyLoginPageTitle(){
		String title=loginpage.getLoginPageTitle();
		System.out.println("login page title is "+title);
		Assert.assertEquals(title, constance.login_page_title);
	}
	@Test(priority=2,enabled=false)
	public void verifysignUpLinkTest(){
		Assert.assertTrue(loginpage.verifySinguolinkisDispalyed());
		
	}
	@Test(priority=3,enabled=false)
	public void loginWithCorrectCredentialTest(){
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=4,enabled=false)
	public void loginWithInCorrectCredentialTest(){
		loginpage.doLogin("naveeen@gmail.com","hsajkdkj");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
 