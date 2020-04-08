package MMPprojectAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Code by Revathi
public class Data {

	static WebDriver driver;
	static HashMap<String, String> PersonalDetailsMap;
	HashMap<String, String> PersonalDetailsMap1;
	HashMap<String, WebElement> PersonalDetailsMap2;

	public Data(WebDriver driver) {

		this.driver = driver;
	}

	public void profileEdit() throws Exception {

		// click the profile menu
		WebElement profile = driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
		profile.click();
		Thread.sleep(3000);

		// Creating an ArrayList of values
		ArrayList<WebElement> listOfValues = new ArrayList<WebElement>(profileMap().values());
		System.out.println("contents of the list holding values of the map ::" + listOfValues);

		for (int i = 0; i < listOfValues.size(); i++) {
			if (!listOfValues.isEmpty()) {
				if (i == 0) {
					WebElement edit = driver.findElement(By.id("Ebtn"));
					edit.click();
					Thread.sleep(3000);

				} else {
					WebElement save = driver.findElement(By.id("Sbtn"));
					save.click();
					Thread.sleep(3000);
				}
				listOfValues.get(i).clear();

			}
		}
		profileMap();

		alertPopUp();

	}

	public static HashMap<String, String> dataMap() {

		// Creating a HashMap object
		PersonalDetailsMap = new HashMap<String, String>();

		// Adding elements to HashMap
		PersonalDetailsMap.put("Address", "5234,Main Street");
		PersonalDetailsMap.put("state", "Indiana");
		PersonalDetailsMap.put("City", "IndianaPolis");
		PersonalDetailsMap.put("ZipCode", "45112");

		return PersonalDetailsMap;
	}

	public HashMap<String, WebElement> profileMap() throws Exception {

		// Creating a HashMap object
		PersonalDetailsMap2 = new HashMap<String, WebElement>();

		// Adding Webelements to HashMap

		// Address
		String strAddress = Data.dataMap().get("Address");
		WebElement address = driver.findElement(By.id("addr"));
		address.sendKeys(strAddress);
		PersonalDetailsMap2.put("Address", address);

		// zipcode
		String strZip = Data.dataMap().get("ZipCode");
		WebElement zipcode = driver.findElement(By.id("zip"));
		zipcode.sendKeys(strZip);
		PersonalDetailsMap2.put("ZipCode", zipcode);

		// State
		String strState = Data.dataMap().get("state");
		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys(strState);
		PersonalDetailsMap2.put("State", state);

		// City
		String strCity = Data.dataMap().get("City");
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys(strCity);
		PersonalDetailsMap2.put("City", city);

		// save
		WebElement save = driver.findElement(By.id("Sbtn"));
		save.click();
		Thread.sleep(3000);

		return PersonalDetailsMap2;
	}

	public HashMap<String, String> alertPopUp() {
		HashMap<String, String> alert = new HashMap<String, String>();
		Alert alt = driver.switchTo().alert();
		String successMsg = alt.getText();
		alt.accept();
		alert.put("message", successMsg);
		return alert;

	}

}
