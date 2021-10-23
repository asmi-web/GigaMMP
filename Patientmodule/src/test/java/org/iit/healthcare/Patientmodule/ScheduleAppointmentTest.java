package org.iit.healthcare.Patientmodule;

import java.util.HashMap;

import org.iih.DriverScript;
import org.iit.healthcare.mmp.HelperClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleAppointmentTest extends DriverScript {

	@Test
	public void validateScheduleAppointment()
	{
	 
	 	 
	 	HelperClass helper = new HelperClass(driver);
	 	helper.launchApplicationURL(prop.getProperty("patienturl"));
		helper.login(prop.getProperty("patientUser"),prop.getProperty("patientPassword"));
		helper.navigateToAModule("Schedule Appointment");
		ScheduleAppointment sPage = new ScheduleAppointment(driver);
		HashMap<String,String> expHMap = sPage.bookAppointment("Smith","Fever");
		HashMap<String,String> actualHMap =sPage.fetchPatientPortalData();
		Assert.assertTrue(expHMap.equals(actualHMap));
		helper.closeDriver();
	}
 
}
