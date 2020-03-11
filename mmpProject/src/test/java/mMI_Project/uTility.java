package mMI_Project;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class uTility {
	
	static Calendar cal = Calendar.getInstance();
	Date date = new Date();
	
	
	 WebDriver driver;
	// WebElement  userName;

	public uTility(WebDriver driver) {
		
		this.driver = driver;
	}

	//login
	public boolean  login(String userName, String password) {		
		
		driver.findElement(By.id("username")).sendKeys(userName);	
		
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.name("submit")).click();
		
		return false;
	}
	
	//homepage after logging
	
	public WebElement  homePgeisDisplayed() {
		
		return driver.findElement(By.xpath("//h3[@class='page-header']"));
		
	}
	
	//Hash Map for Providers
	// HashMap---https://www.google.com/search?q=How+to+write+Hashmap+in++selenium&rlz=1C1CAFA_enUS687US688&sxsrf=ALeKk028hBD983ymzrKO03QgFPMYiNz5Jw:1582566483143&source=lnms&sa=X&ved=0ahUKEwiAnL7I3-rnAhViU98KHUhfB3QQ_AUICSgA&biw=1455&bih=717&dpr=1.1#kpvalbx=_WgxUXpmvM-eD_Qa5jLiwBA32
	
	public static HashMap<Integer, String> getProvider() {
		
		HashMap <Integer,String> providerMAp = new HashMap<Integer,String>(); 
		
		providerMAp.put(1, "Beth");
		providerMAp.put(2, "Charlie");
		/*
		 * providerMAp.put("Dr3", "Smith"); providerMAp.put("Dr4", "Alexander");
		 * providerMAp.put("Dr5", "Becky"); providerMAp.put("Dr6", "Annabeth");
		 * providerMAp.put("Dr6", "molly"); providerMAp.put("Dr6", "subramanya");
		 */
		return providerMAp;
	}
	
	public static HashMap<String, String> dateMap() {
		
		String s = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		
		HashMap <String,String> providerMAp = new HashMap<String,String>(); 
		
		//providerMAp.put("day", cal.get(Calendar.DAY_OF_MONTH));
		
		providerMAp.put("day", s);
		//providerMAp.put("month", cal.get(Calendar.MONTH));		
		//.put("year", cal.get(Calendar.YEAR));
		
		System.out.println("HashMap (Date) = "+  providerMAp);
		
		return providerMAp;
		
			
	}
	//hashMap for Time
	public static  HashMap<Integer, String> timeMap() {
		// you can write in the above way bit in this project we r having only 3 values
		HashMap <Integer, String> timeMAp = new HashMap<Integer, String>();
		timeMAp.put(1, "10Am");
		timeMAp.put(1, "11Am");
		timeMAp.put(1, "12Pm");
		
		return timeMAp;
	}
	

}
