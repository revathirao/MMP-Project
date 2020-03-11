package mMI_Project;

///https://www.youtube.com/watch?v=dhFiU3vqenU
//https://www.youtube.com/watch?v=uzvQJrplZB8

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datePickervideo1 {

	WebDriver driver;

	String monthYear = "April 2020";
	String day = "20";

	@Test
	public void validateScheduleAppointment() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.visibilityOf(element));
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(

		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");

		// Login
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);

		// Clicking the schedule appt linkl
		driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click(); // .findElement(By.linkText("Schedule
																									// Appointment")).click();
		Thread.sleep(3000);

		//// Clicking the create New appointment
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);

		// Clicking both the dr and the Book appointment
		driver.findElement(By.xpath("//h4[text()='Dr.Beth']//ancestor::ul/following-sibling::button")).click();
		Thread.sleep(3000);

		// Switching the Frame
		driver.switchTo().frame("myframe");

		// Clicking the Date Text box
		driver.findElement((By.id("datepicker"))).click();
		// https://www.youtube.com/watch?v=uzvQJrplZB8
		Thread.sleep(5000);

		// String str =
		// driver.findElement(By.xpath("//*[@class='ui-datepicker-month']//following-sibling::span")).getText();

		// getting the year and month
		while (true) {

			String str = driver.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println("StringMonth and Year " + str);

			if (str.equals(monthYear)) {
				break;
			} else {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(2000);

			}
		}

		// getting the date
		// driver.findElement(By.xpath("//div//table//tbody//tr//td[contains(.,'10')]")).click();

		driver.findElement(By.xpath("//div//table//tbody//tr//td[contains(.," + day + ")]")).click();

	}

}
