package org.iit.healthcare.Patientmodule;

import java.util.HashMap;

import org.iih.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	WebDriver driver;
	
	
	public ProfilePage(WebDriver driver){
		this.driver = driver;
	}
	
	


	public HashMap<String, String> editProfile() {
		
		HashMap<String,String> profHMap = new HashMap<String,String>();
		driver.findElement(By.id("Ebtn")).click();
		
		WebElement firstName=driver.findElement(By.id("fname"));
		firstName.clear();
		firstName.sendKeys("kumar");
		System.out.println(firstName.getAttribute("value"));
		profHMap.put("fname",firstName.getAttribute("value"));
		
		WebElement lastName=driver.findElement(By.id("lname"));
		lastName.clear();
		lastName.sendKeys("Josh");
		profHMap.put("lname",lastName.getAttribute("value"));
		System.out.println(lastName.getAttribute("value"));
		
		WebElement licenseNumber=driver.findElement(By.id("licn"));
		licenseNumber.clear();
		int  licnNumber=Utility.randomInt(7);
		licenseNumber.sendKeys("1"+ licnNumber);
		System.out.println(licenseNumber.getAttribute("value"));
		profHMap.put("licnumber",licenseNumber.getAttribute("value"));
		
		WebElement ssnNumber=driver.findElement(By.id("ssn"));
		ssnNumber.clear();
		int  ssNumber=Utility.randomInt(9);
		ssnNumber.sendKeys(String.valueOf(ssNumber));
		profHMap.put("ssnumber",ssnNumber.getAttribute("value"));
		
		WebElement address=driver.findElement(By.id("addr"));
		address.clear();
		int  addrNum=Utility.randomInt(4);
		String stName=Utility.getRandomString(7);
		address.sendKeys(addrNum +" "+ stName + " st" );
		profHMap.put("address",address.getAttribute("value"));
		
		
		
		WebElement age=driver.findElement(By.id("age"));
		age.clear();
		age.sendKeys("20");
		profHMap.put("age",age.getAttribute("value"));
		
		
		
		WebElement weight = driver.findElement(By.id("weight"));
		weight.clear();
		weight.sendKeys("75");
		profHMap.put("weight",weight.getAttribute("value"));
		
		
		
		WebElement height=driver.findElement(By.id("height"));
		height.clear();
		height.sendKeys("158");
		profHMap.put("height",height.getAttribute("value"));
		
		
		WebElement city= driver.findElement(By.id("city"));
		city.clear();
		String cityName=Utility.getRandomString(7);
		city.sendKeys(cityName);
		profHMap.put("city",city.getAttribute("value"));
		
		
		WebElement state=driver.findElement(By.id("state"));
		state.clear();
		String stateName=Utility.getRandomState();
		state.sendKeys(stateName);
		profHMap.put("state",state.getAttribute("value"));
		
		
		WebElement  zipCode = driver.findElement(By.id("zip"));
		zipCode.clear();
		int  zipValue=Utility.randomInt(5);
		zipCode.sendKeys(String.valueOf(zipValue));
		profHMap.put("zip",zipCode.getAttribute("value"));
		
		
		
		
		
		driver.findElement(By.id("Sbtn")).click();
		
		alertMessage();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		return profHMap;
		}
	public boolean alertMessage(){
		Alert alert = driver.switchTo().alert();
		String alertMessage=alert.getText();
		assertTrue(alertMessage.contains("Your Profile has been updated."));
		
		return true;
		
	}
	
	
	private void assertTrue(boolean contains) {
		// TODO Auto-generated method stub
		
	}




	public HashMap<String, String> fetchUpadatedProfile()
	{
		System.out.println("comaparing values");
		HashMap<String,String> updatedHMap = new HashMap<String,String>();
		updatedHMap.put("fname",driver.findElement(By.id("fname")).getAttribute("value"));
		updatedHMap.put("lname", driver.findElement(By.id("lname")).getAttribute("value") );
		updatedHMap.put("licnumber", driver.findElement(By.id("licn")).getAttribute("value"));
		updatedHMap.put("ssnumber",driver.findElement(By.id("ssn")).getAttribute("value"));
		updatedHMap.put("address",driver.findElement(By.id("addr")).getAttribute("value"));
		updatedHMap.put("age", driver.findElement(By.id("age")).getAttribute("value") );
		updatedHMap.put("weight", driver.findElement(By.id("weight")).getAttribute("value"));
		updatedHMap.put("height",driver.findElement(By.id("height")).getAttribute("value"));
		updatedHMap.put("city",driver.findElement(By.id("city")).getAttribute("value"));
		updatedHMap.put("state", driver.findElement(By.id("state")).getAttribute("value") );
		updatedHMap.put("zip", driver.findElement(By.id("zip")).getAttribute("value"));
		
		return updatedHMap;
	}

	
}
