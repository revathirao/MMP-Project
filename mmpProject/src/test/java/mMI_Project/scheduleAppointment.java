package mMI_Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scheduleAppointment {
	
	WebDriver driver;
	
	@Test
	
	/*
	 * 1. Enter the url-http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php
	 * 2. Login ith the Credentials , ria1, Ria12345 
	 * 3. In the home page click Schedule appt
	 * 
	 * 
	 * 
	 * 
	 * 
	 */	
	
	public void validateTheResult(){
		
		
		SoftAssert sa = new SoftAssert();		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
	// Maximize the page
		driver.manage().window().maximize();		
		
	//Enter the url
		driver.get( "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php" );
				
	//Validate the Url
				
		String actualUrl = "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";
		String expectedUrl= driver.getCurrentUrl();			
		Assert.assertEquals(actualUrl, expectedUrl);
		System.out.println("Successfully launched the url");
		
		 
		
	//Instantiating the  uTility class
		uTility uTill = new uTility(driver);
		
	//Login and validate
		boolean result = uTill.login("ria1", "Ria12345");
        sa.assertTrue(result); 
        System.out.println("Login Successfull "+  result);
        
     // Validate the dashboard page after login
        boolean result1 = uTill.homePgeisDisplayed().isDisplayed();
        System.out.println( "Home page is displayed "+ result1);
        
     //Instantiating the sAppointment Class\
        sAppointment sappt = new sAppointment(driver);  
        sappt.validateScheduleAppointmentPage();
        
        
      //Validate the Page that is opened after clicking the Schedule appt
        boolean Result3 = sappt.validateScheduleAppointmentPage();
        sa.assertTrue(Result3, "Pass-- Validation of the Schedule aapt");
        
       // calling the providers hashMap
      //String providerName =  uTility.getProvider().get("Dr1");
      
      Select select = new Select( driver.findElement(By.xpath("//h4[contains(text(),'Dr.Beth')]//ancestor::ul/following-sibling::button")));
            select.selectByIndex(1);
      
      System.out.println( "Selection " + select);
     
      //.selectByVisibleText( uTility.getProvider().get("Dr1"));
      
      List <WebElement> li = select.getOptions();
      
      li.get(1).click();
      
      
      
      System.out.println("HAHAHA");
      
	}

}
