package mMI_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import iitp.mmp.patient.pages.RegisterPatientPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPatient {
	
	WebDriver driver;
	
	@Test
	public void patientRegistrationForm() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		WebElement  registerButtonClick =  driver.findElement(By.xpath("//input[@type = 'button']"));
		registerButtonClick.click();

		//LoginPage lp =new LoginPage(driver);
		//lp.login("ria1","Ria12345");
		RegisterPatientPage rp = new RegisterPatientPage(driver);
		rp.Register("Test2","Roh12345");
		
	}

}
