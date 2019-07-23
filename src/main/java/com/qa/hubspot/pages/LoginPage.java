package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.utility.timeUtility;

public class LoginPage extends BasePage {
	// 1.Define page factory /page objects
	@FindBy(id = "username")
	WebElement emailId;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "loginBtn")
	WebElement loginButton;
	@FindBy(linkText = "Sign up")
	WebElement signUplink;

	// 2.create a constructor of login page and initialize page objects
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//3.Page Action/page lib
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean verifySinguolinkisDispalyed(){
		return signUplink.isDisplayed();
		
	}
	public HomePage doLogin(String username,String Pwd){
		System.out.println("credential "+username+" /"+Pwd);
		emailId.sendKeys(username);
		password.sendKeys(Pwd);
		loginButton.click();
		timeUtility.LongWait();
		return new HomePage(driver);
		
		
	}

}
