package org.iih;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Utility {
	
	static Random rand;
	public static String selectFutureDate(int nofDays)
	{
	      Calendar cal = Calendar.getInstance();
	      System.out.println(cal.getTime());
	      cal.add(Calendar.DAY_OF_MONTH, nofDays);
	      
	      SimpleDateFormat sdf = new SimpleDateFormat("d/MMMMM/YYYY");//10/October/2021
	      String date = sdf.format(cal.getTime());
	      System.out.println(date);
	      return date;
	}
	
	public static int randomInt(int digits){
		
	    int minimum = (int) Math.pow(10, digits - 1); // minimum value with 2 digits is 10 (10^1)
	    int maximum = (int) Math.pow(10, digits) - 1; // maximum value with 2 digits is 99 (10^2 - 1)
	    Random random = new Random();
	    return minimum + random.nextInt((maximum - minimum) + 1);
	}
	
	public static String getRandomState(){

		String state = "";

		String[] sArray = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
				"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine","Maryland", "Massachusetts", "Michigan",
				"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
				"North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
				"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };

		int num = rand.nextInt(49);
		state = sArray[num];
		System.out.println(state);		
		return state;
	}
	
	public static String getRandomString(int noOfChars){

		rand = new Random();
		String s = "";
		int bound = noOfChars;
		//char[] charArray = new char[bound];
		for(int i=0; i<bound; i++){
			char c = (char) ('a'+rand.nextInt(26));
			s = s+c;
		}
		System.out.println("getRandomString Method returning "+s);
		return s;
	}
}
