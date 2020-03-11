package mMI_Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datePicker2 {
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

		driver.get("http://cleartrip.com");

		// click the text
		driver.findElement(By.id("DepartDate")).click();

		// month and year
		while (true) {

			// String str = driver.findElement((By.className("title"))).getText();

			String str = driver.findElement((By.xpath("//div[@class = 'title']"))).getText();

			System.out.println(str);
			Thread.sleep(3000);

			if (str.equals(monthYear)) {
				break;
			} else {
				driver.findElement(By.className("nextMonth")).click();
				Thread.sleep(3000);
			}
		}

		// List<WebElement> allDates =
		// driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody"));
		//date
		List<WebElement> allDates = driver
				.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr/td/a"));

		for (WebElement ele : allDates) {
			// System.out.println("hello");
			// System.out.println(ele.getText());

			String date = ele.getText();

			if (date.equals(day)) {

				ele.click();
				break;

			}
		}

	}
}
