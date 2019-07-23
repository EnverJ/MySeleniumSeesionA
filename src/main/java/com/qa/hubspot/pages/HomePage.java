package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.utility.timeUtility;

public class HomePage extends BasePage {
	@FindBy(xpath = "//h1[@class='private-page__title']")
	WebElement DashBoard;
	@FindBy(xpath = "//span[@class='account-name ']")
	WebElement AccountName;
	@FindBy(id = "nav-primary-contacts-branch")
	WebElement parentContacsMenu;
	@FindBy(id = "nav-secondary-contacts")
	WebElement chiledContacsMenu;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getdashboard() {
		return DashBoard.getText();
	}

	public boolean verifyDashBoard() {
		return AccountName.isDisplayed();

	}

	public String getAccountName() {
		return AccountName.getText();
	}

	public boolean verifyAccount() {
		return AccountName.isDisplayed();
	}

	public void clikonContacts() {
		parentContacsMenu.click();
		timeUtility.shortWait();
		chiledContacsMenu.click();
	}

	public ContactsPage goToContactsPage() {
		clikonContacts();
		return new ContactsPage(driver);
	}

}
