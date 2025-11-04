package com.crm.generic.webdriverutility;

import java.util.Random;

public class JavaUtility {
	
	public int getRandomNum() {
		
		Random random = new Random();
		int num = random.nextInt();
		return num;
		
	}
}
