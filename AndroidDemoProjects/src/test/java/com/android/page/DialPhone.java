package com.android.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.android.manager.Utils;
import com.google.gson.JsonObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DialPhone {

	AndroidDriver driver;
	Utils utils;

	public DialPhone(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.android.dialer:id/dialpad_fragment")
	private WebElement dialFab;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"8\"]")
	private WebElement number8;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Dial']")
	private WebElement DialLogo;
	
	
	

	public void enterPhoneNumber() {

		utils = new Utils(driver);
		JsonObject obj = utils.getJsonObject("data.json");
		System.out.println(obj);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dialFab));

		if (dialFab.isDisplayed()) {
			String phoneNumver = utils.getJsonData(obj,"PhoneNumber");
			System.out.println(phoneNumver);
			for(int i=0;i<phoneNumver.length();i++) {
				driver.findElement(By.xpath("//android.widget.TextView[@text=\""+phoneNumver.charAt(i)+"\"]")).click();
			}
			
			DialLogo.click();
			
			

		} else {
			System.out.println("DialTab is not present");
		}
	}

}
