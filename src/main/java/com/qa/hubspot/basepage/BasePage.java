package com.qa.hubspot.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.utility.timeUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public WebDriver driver;
	public Properties prop;
	/** this method is used to initiliaze browser;
	 * 
	 * 
	 * @param driver
	 * @return
	 */
	public WebDriver Inti_Driver(Properties prop){
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.equals("chrome")){
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "/Webdriver/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(BrowserName.equals("ff")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else{
			System.out.println("Browser is not mathch");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url"));
		timeUtility.LongWait();
		return driver;
		
	}
	/**
	 * this method is used initiliaze properties 
	 * @return
	 */
	public Properties init_proprities(){
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("/Users/enlem/workspace/MyPOMserious/src/main/java/com/qa/hubspot/configuration/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		}
	

}
