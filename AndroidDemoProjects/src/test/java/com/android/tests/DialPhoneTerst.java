package com.android.tests;

import org.testng.annotations.Test;

import com.android.manager.Capabilities;
import com.android.page.DialPhone;

public class DialPhoneTerst extends Capabilities{
	
	@Test
	public void validateDialPhone() {
		DialPhone dial=new DialPhone(driver);
		dial.enterPhoneNumber();
		
	}
	
	
	
	
	
	

}
