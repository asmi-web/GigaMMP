package org.iit.healthcare.Patientmodule;

import java.util.HashMap;

import org.iih.DriverScript;
import org.iit.healthcare.mmp.HelperClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends DriverScript{

	@Test
	public void validateEditProfile()
	{
	 
	 	 
	 	HelperClass helper = new HelperClass(driver);
	 	helper.launchApplicationURL(prop.getProperty("patienturl"));
		helper.login(prop.getProperty("patientUser"),prop.getProperty("patientPassword"));
		helper.navigateToAModule("Profile");
		
		ProfilePage pPage = new ProfilePage(driver);

		HashMap<String,String> expHMap = pPage.editProfile();
		HashMap<String,String> actualHMap =pPage.fetchUpadatedProfile();
		Assert.assertTrue(expHMap.equals(actualHMap));
		helper.closeDriver();
		}
	
}
