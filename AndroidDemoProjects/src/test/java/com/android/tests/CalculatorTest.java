package com.android.tests;

import org.testng.annotations.Test;

import com.android.manager.Capabilities;
import com.android.page.CalculatorPage;

public class CalculatorTest extends Capabilities {
	
	
	
	@Test
	public void ValidateAdditionFunctionality() {
		
		CalculatorPage page=new CalculatorPage(driver);
		page.addition();
		
	}

}
