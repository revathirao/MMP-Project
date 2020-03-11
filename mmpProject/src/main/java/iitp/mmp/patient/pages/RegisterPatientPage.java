package iitp.mmp.patient.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatientPage {
	
	private static WebDriver driver;
	
	public RegisterPatientPage(WebDriver driver){		
		
		this.driver= driver;		
	}	
	
	public HashMap<String, String> Register(String userName,String password) throws InterruptedException {
		
		Random rd = new Random();
		HashMap <String, String> hMap = new HashMap<String, String>();
		
		// firstname
        WebElement firstNameTxtField = driver.findElement(By.id("firstname"));
        firstNameTxtField.sendKeys("FirstName" + (char)(65 + rd.nextInt(26)));
        hMap.put("firstname", firstNameTxtField.getAttribute(("value")));
                
        //Last NAme
        WebElement lastNameTxtField = driver.findElement(By.id("lastname"));
        lastNameTxtField.sendKeys("LastNAme"+ (char)(65 + rd.nextInt(26)));
        hMap.put("lastname", lastNameTxtField.getAttribute(("value")));
		
		/*//license
		WebElement licenseTextField = driver.findElement(By.id("license")); 
		int licencevaluetoEnter = rd.nextInt(999999999);
		licenseTextField.sendKeys("" + licencevaluetoEnter);
		hMap.put("License", licenseTextField.getAttribute("Values"));
		
		//SSn
		WebElement ssnTextField = driver.findElement(By.id("ssn")); 
		int ssnvaluetoEnter = rd.nextInt(999999999);
		ssnTextField.sendKeys("" + ssnvaluetoEnter);
		hMap.put("SSN", ssnTextField.getAttribute("Values"));*/
		
		//Zipcode
		WebElement zipcodeTxtField  = driver.findElement(By.id("zipcode")); 
		long  zipValuetoEnter = rd.nextInt(99999);
		zipcodeTxtField .sendKeys("" + zipValuetoEnter);
		hMap.put("Zipcode", zipcodeTxtField.getAttribute("Values"));

		//Age
		WebElement ageTxtField = driver.findElement(By.id("age")); 
		long  ageValueToEnter = rd.nextInt(99);
		ageTxtField.sendKeys("" + ageValueToEnter);
		hMap.put("Age", ageTxtField  .getAttribute("Values"));
		
		//height
		WebElement heightTxtField= driver.findElement(By.id("height")); 
		long  heightToEnter = rd.nextInt(99);
		heightTxtField.sendKeys("" + heightToEnter);
		hMap.put("Height", heightTxtField.getAttribute("Values"));

		//weight
		WebElement weightTxtField= driver.findElement(By.id("weight")); 
		long WeightToEnter = rd.nextInt(99);
		weightTxtField.sendKeys("" + ageValueToEnter);
		hMap.put("Weight", weightTxtField.getAttribute("Values"));
		
		//Stete
		WebElement stateTxtField= driver.findElement(By.id("state")); 
		stateTxtField.sendKeys("New Jersy");
		hMap.put("State", stateTxtField.getAttribute("Values"));

		//city
		WebElement cityTxtField= driver.findElement(By.id("city")); 
		cityTxtField.sendKeys("Edison");
		hMap.put("License", cityTxtField.getAttribute("Values"));

		//Address
		WebElement addressTxtField= driver.findElement(By.id("address")); 
		addressTxtField.sendKeys("New York");
		hMap.put("Address", addressTxtField.getAttribute("Values"));
		
		//DtaePicker
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		WebElement DtaePickerTextField = driver.findElement(By.id("datepicker"));
		DtaePickerTextField.sendKeys(sdf.format(new Date()));
		
		 //Email
		WebElement emailTxtField = driver.findElement(By.id("email"));
        emailTxtField.sendKeys("testEmail"+((char)(65+rd.nextInt(26))+""+
                (char)(65+rd.nextInt(26)))+"@gmail.com");
        hMap.put("email", emailTxtField.getAttribute(("value")));		
		
		
		//UserNAme
        WebElement usernameTxtField = driver.findElement(By.id("username"));
        usernameTxtField.sendKeys(userName);
        hMap.put("username", usernameTxtField.getAttribute(("value")));
         
        //Password
        WebElement passwordTxtField = driver.findElement(By.id("password"));
        passwordTxtField.sendKeys(password);
        hMap.put("password", passwordTxtField.getAttribute(("value")));
        
        //Confirm Psw  
        WebElement confirmpasswordTxtField = driver.findElement(By.id("confirmpassword"));
        confirmpasswordTxtField.sendKeys(password);
        hMap.put("confirmpassword", confirmpasswordTxtField.getAttribute(("value")));
        
        //security
        new Select(driver.findElement(By.id("security"))).selectByVisibleText("what is your best friend name");         
          
        //AnswerField 
        WebElement answerTxtField = driver.findElement(By.id("answer"));
        answerTxtField.sendKeys(userName);
        hMap.put("answer", answerTxtField.getAttribute(("value")));
        Thread.sleep(20000);
        
        
        //Licence
        WebElement licenseTxtField = driver.findElement(By.id("license")); 
		Long licenseValue = new Long(10000000 + rd.nextInt(90000000));
    	System.out.println("License::" + licenseValue + "--" + licenseValue.toString().length());
		licenseTxtField.click();
		licenseTxtField.sendKeys(licenseValue.toString().trim());
		hMap.put("license", licenseTxtField.getAttribute(("value")));
		licenseTxtField.click();
		
		Thread.sleep(3000);
		
		//ssn
		WebElement ssnTxtField = driver.findElement(By.id("ssn")); 
		long ssnValue = rd.nextInt(999999999);
		ssnTxtField.sendKeys(""+ssnValue);
		hMap.put("ssn", ssnTxtField.getAttribute(("value")));
		ssnTxtField.click();
         
        //submit
        driver.findElement(By.name("register")).click();
		
		//popup
       Thread.sleep(2000);
       Alert regAlert = driver.switchTo().alert();
		String successMsg = regAlert.getText();
		regAlert.accept();
		
	    hMap.put("message", successMsg);
	    
		return hMap;  
     
       //taskkill /F /IM chromedriver.exe

		
	}

}
