package com.android.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.android.manager.Utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

public class AllureReportDemo {
	@Feature("Allure-Report")
	@Story("This is the Story of the Test: Verify the Allure report")
	@Description("its give the description of the tesrt")
	@Test
	public void demoTest() {
		System.out.println("Hiii");
		Allure.step("this is the step information");
		WebDriver driver=new ChromeDriver();
		Utils utils = new Utils(driver);
		utils.captureScreenshot();
	}

}
