package mMI_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sAppointment {
	
	 WebDriver driver;
	

public  sAppointment(WebDriver driver) {
	
	this.driver =  driver;
}
	 
public boolean validateScheduleAppointmentPage() {


	// Clicking the schedule appt linkl
	 driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
	 
	 System.out.println("Hello1");
	 
	// driver.findElement(By.xpath("//h3[@class='page-header']")).isDisplayed();	 
	 
	// System.out.println("Hello2");'
	 
	 //Clicking the create New appointment
	 driver.findElement(By.xpath("//input[@type ='submit']")).click();
	 
		/*
		 * driver.findElement(By.xpath( "//h4[contains(text(),'Dr.Beth')]//ancestor::ul/following-sibling::button")).click();
		 *  System.out.println(driver.getTitle());
		 * 
		 * 
		 */	return true;
	 
}	

	 
	

}
