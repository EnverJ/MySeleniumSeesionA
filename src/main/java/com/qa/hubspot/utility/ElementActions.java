package com.qa.hubspot.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.basepage.BasePage;

public class ElementActions extends BasePage {
	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method used to create webelement on the bases of given By Locator
	 * 
	 * @param Locator
	 * @return WebElement
	 */

	public WebElement getElement(By Locator) {
		WebElement element = null;

		try {

			element = driver.findElement(Locator);

		} catch (Exception e) {
			System.out.println("some exception occured while creating webelement " + Locator);
		}
		return element;

	}

	public void WaitforElementPrensent(By Locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(Locator));

	}
	public void WaitforTitletPrensent( String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));

	}
	public boolean elementIsDisplayed(By Locator) {

		WaitforElementPrensent(Locator);
		return getElement(Locator).isDisplayed();

	}

	public void elementClick(By Locator) {
		getElement(Locator).click();
	}

	public void elementSendKeys(By Locator, String value) {
		getElement(Locator).sendKeys(value);

	}
	public String getTitle(){
		String title = null;
		try{
		title=driver.getTitle();
	
	}catch(Exception e){
		System.out.println("some exception occured while getting title"+title);
		}

		return title;
		
	}
}