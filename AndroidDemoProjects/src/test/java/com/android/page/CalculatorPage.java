package com.android.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalculatorPage {
	
	 AndroidDriver driver;
	
	
	 public CalculatorPage(AndroidDriver driver) {
		 
		 this.driver=driver;
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	 }
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_1\"]")
	 private WebElement number1;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_2\"]")
	 private WebElement number2;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_3\"]")
	 private WebElement number3;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_4\"]")
	 private WebElement number4;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_5\"]")
	 private WebElement number5;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_6\"]")
	 private WebElement number6;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_7\"]")
	 private WebElement number7;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_8\"]")
	 private WebElement number8;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_9\"]")
	 private WebElement number9;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"=\"]")
	 private WebElement equals;
	 
	 @AndroidFindBy(id = "com.vivo.calculator:id/formula")
	 private WebElement result;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Plus\"]")
	 private WebElement plus;
	 
	 
	 public void addition() {
		 number1.click();
		 plus.click();
		 number2.click();
		 plus.click();
		 number3.click();
		 equals.click();
		 System.out.println("addition of all the number is : "+result.getText());
		 
		  
		 
	 }
	 
	 
			 

}
