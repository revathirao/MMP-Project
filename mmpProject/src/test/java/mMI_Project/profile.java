package mMI_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import iitp.mmp.patient.pages.LoginPage;
import iitp.mmp.patient.pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class profile {
	
	WebDriver driver;
	@Test
	
	public void profile() throws InterruptedException{
	
	WebDriverManager.chromedriver().setup();		
	driver = new ChromeDriver();
	
	driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	
	LoginPage lp =new LoginPage(driver);
	lp.login("ria1","Ria12345");
	
	
	ProfilePage pp = new ProfilePage(driver);
	pp.profile();
	}
}
