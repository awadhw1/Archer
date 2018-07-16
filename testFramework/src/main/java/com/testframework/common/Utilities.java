package com.testframework.common;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class Utilities {
	public static String numberGenerate() {
		Random random = new Random();
		int randomInt = random.nextInt(9999999 - 100000);
		String orderNumber = String.valueOf(randomInt);
		return orderNumber;
	}

	public static String dateGenerate() {
		// Instantiate a Date object
		Date date = new Date();
		String date1 = date.toString();
		date1 = date1.replace(":", "");
		date1 = date1.replace(" ", "");
		return date1;
	}

	public static String randomtype() {
		Random random = new Random();
		int randomInt =1 + random.nextInt(3); 
		//With below code only Percent off is used for plan creation
		//int randomInt =1;
		String orderNumber = String.valueOf(randomInt);
		return orderNumber;
	}

	public static String randomstrategytype() {
		Random random = new Random();
		//		int randomInt =1 + random.nextInt(3);
		int randomInt =3;
		String orderNumber = String.valueOf(randomInt);
		return orderNumber;
	}

	public static int RandomNumber(int upperLimit){
		Random r = new Random();
		int Result = 1;
		int lowerLimit = 1;
		if(upperLimit > lowerLimit)
		{
		Result = r.nextInt(upperLimit-lowerLimit) + lowerLimit;
		}
		return Result;
	}
	public static void setAllureProps() {
		Properties properties = System.getProperties();
		properties.setProperty("allure.link.mylink.pattern", "https://tracker.wal-mart.com/browse/{}");
		properties.setProperty("allure.link.issue.pattern", "https://tracker.wal-mart.com/browse/{}");
		System.out.println(properties.getProperty("allure.link.mylink.pattern")); 
		System.out.println(properties.getProperty("allure.link.issue.pattern")); 
	}
}
