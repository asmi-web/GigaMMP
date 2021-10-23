package org.iih;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScript {

	public static WebDriver driver;
	public static Properties prop; 
	
	public DriverScript() 
	{
		try{
			File file = new File("./iitconfig/mmp.properties");
			FileInputStream fis = new FileInputStream(file);
			 prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Unable to read the values from the properties file" +e.getMessage());
		}
		
	}
	
	@BeforeClass
	public void instantiateDriver() throws IOException
	{
		//WebDriverManager.chromedriver().setup();
		//driver= new ChromeDriver();
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			System.out.println("Inside if");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")){	
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	 
	}
}
