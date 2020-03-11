package iitp.mmp.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
*Log in Page
*
*/
public class LoginPage {
	
	WebDriver driver;
		
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
	}
	
	public void login(String userName, String password) {
		
			driver.findElement(By.id("username")).sendKeys(userName);	
			
			driver.findElement(By.id("password")).sendKeys(password);
			
			driver.findElement(By.name("submit")).click();
			
		}
		
	}


