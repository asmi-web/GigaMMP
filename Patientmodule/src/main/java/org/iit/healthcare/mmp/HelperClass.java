package org.iit.healthcare.mmp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {
WebDriver driver;
	
	public HelperClass(WebDriver driver){
		this.driver = driver;
	}
	public  void launchApplicationURL(String url)	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void navigateToAModule(String mName)
	{
		driver.findElement(By.xpath("//span[normalize-space()='"+mName+"']")).click();
	}
	public String login(String uname,String pword)
	{
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
		String actual = driver.findElement(By.tagName("h3")).getText();
		return actual;
	}
	public void closeDriver() {
        driver.close();
}
		
	}
	


