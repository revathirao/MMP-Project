package mMI_Project;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class datePickerSudhir {
	WebDriver driver;
	/*String dot="9/October/2020";
	String date,month,year;
	String caldt,calmonth,calyear;*/	
	
	@Test
	
		public void dateZPicker() throws InterruptedException 
		{
		
		
		String dot="9/October/2020";
		String date,month,year;
		String caldt,calmonth,calyear;		
		
			/*
			 * Split the String into String Array
			 */
			String dateArray[]= dot.split("/");
			date=dateArray[0];
			month=dateArray[1];
			year=dateArray[2];
			System.out.println( "Array month "+ month);
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

			
			driver.get("http://cleartrip.com");
			driver.findElement(By.id("DepartDate")).click();

			WebElement cal;
			cal=driver.findElement(By.className("calendar"));///what is this
			
			calyear=driver.findElement(By.className("ui-datepicker-year")).getText();
			System.out.println(calyear);
			/**
			 * Select the year
			 * 
			 */			
					
			while (!calyear.equals(year)) 
			{
				driver.findElement(By.className("nextMonth")).click();
				Thread.sleep(2000);
				calyear=driver.findElement(By.className("ui-datepicker-year")).getText();
				System.out.println("Displayed Year::" + calyear);				
			}			

			/**
			 * Select the Month
			*/ 			
			
			calmonth=driver.findElement(By.className("ui-datepicker-month")).getText();

			while (!calmonth.equalsIgnoreCase(month)) 
			{				
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();
				Thread.sleep(2000);
				calmonth=driver.findElement(By.className("ui-datepicker-month")).getText();
				System.out.println(calmonth);
				Thread.sleep(2000);	
			}
			
			cal=driver.findElement(By.className("calendar"));
			/**
			 * Select the Date
			 * The iteration will check in the outer for loop the rows like 1,2...
			 * Th inner loop checks the date in that rows
			 */
			
			List<WebElement> rows,cols;
			rows=cal.findElements(By.tagName("tr"));//rows store each row 
			System.out.println(rows);
			for (int i = 1; i < rows.size(); i++) 
			{
				cols=rows.get(i).findElements(By.tagName("td"));//all the dates in a particular rows will be stored in col
				for (int j = 0; j < cols.size(); j++) 
				{
					caldt=cols.get(j).getText();
					if (caldt.equals(date)) 
					{
						cols.get(j).click();
						break;
					}
				}
			}

		}

	}

