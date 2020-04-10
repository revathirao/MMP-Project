package MMPProjectAssignment;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import MMPprojectAssignment.Data;
import iitp.mmp.patient.pages.LoginPage;
import iitp.mmp.patient.pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ProfileTest {
	
	WebDriver driver ;
	
	@Test
	public void profile() throws Exception{
	
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();

	 // Launch The URL
	driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");

	// Call the login page
	LoginPage lp =new LoginPage(driver);
	lp.login("summer","Test123@");
	Thread.sleep(5000);
	
	Data dt = new Data(driver);
	
	
	HashMap<String,WebElement> hMap = dt.profileEdit();
	
	
	Set<String> keySetValues = hMap.keySet();
	
	for(String key : keySetValues)
	{
		System.out.println("Key is ::"   + key);
		System.out.println("Value is ::" +hMap.get(key));
	}


	dt.save();
	dt.alertPopUp();
	
	


	//Verification of alert
	HashMap<String, String> hMap1 = dt.alertPopUp();
	
	String expectedMsg = "Your Profile has been updated.";
	String actualMsg = hMap1.get("message");
	Assert.assertEquals(actualMsg.trim(),expectedMsg.trim());

	
	
	}

}
