package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.constance.constance;
import com.qa.hubspot.utility.ElementActions;

public class LoginPageNPF extends BasePage {
	ElementActions elementaction;
	//1.Define Locator:page objects
	By emailId=By.id("username");
	By password=By.id("password");
	By loginButtn=By.id("loginBtn");
	By signupLink=By.linkText("Sign up");
	public LoginPageNPF(WebDriver driver){
		this.driver=driver;
		 elementaction=new ElementActions(driver);
	} 
	
	//2.page actions
	public String getLoginPageTitle(){
		elementaction.WaitforTitletPrensent(constance.login_page_title);
		return elementaction.getTitle();
	}
	public boolean verifySignuolinkisDispalyed(){
		//return elementaction.getElement(signupLink).isDisplayed();
		return elementaction.elementIsDisplayed(signupLink);
		
	}
	public HomePage doLogin(String username, String pwd){
		System.out.println("Credentials "+username+"/"+pwd);
		elementaction.elementSendKeys(emailId, pwd);
		elementaction.elementClick(loginButtn);
		return new HomePage(driver);
		
	}
	

}
