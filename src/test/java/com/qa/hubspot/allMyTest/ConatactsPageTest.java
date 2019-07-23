package com.qa.hubspot.allMyTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.listeners.pdfListener;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utility.xlsutil;
@Listeners(pdfListener.class)
public class ConatactsPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	@BeforeMethod
	public void setup(){
		basepage=new BasePage();
	prop=basepage.init_proprities();
	driver=basepage.Inti_Driver(prop);
	loginpage=new LoginPage(driver);
	homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	homepage.goToContactsPage();
	}
	@DataProvider(name="getcontactsData")
	public Object[][] getContactsTestData(){
		Object contactsData[][]=xlsutil.getTestData("contacts");
		return contactsData; 
	}
	@Test(dataProvider="getcontactsData")
	public void createcontactTest(String email,String firstName,String lastName,String jobTitle){
		//contactspage.createNewContact(email, firstName, lastName, jobTitle);
		contactspage.createNewContact(email, firstName, lastName, jobTitle);
	}

@AfterMethod
	
	public void TearDown(){
		driver.quit();
	}
}
