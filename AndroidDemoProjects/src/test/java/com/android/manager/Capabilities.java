package com.android.manager;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.gson.JsonObject;

import io.appium.java_client.android.AndroidDriver;

public class Capabilities {

	public AndroidDriver driver;
	public Utils utils;

	@BeforeClass
	public void setCapabilities()  {

		utils = new Utils(driver);
		JsonObject obj = utils.getJsonObject("data.json").getAsJsonObject("Capabilities");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", utils.getJsonData(obj, "platformName"));
		capabilities.setCapability("appium:platformVersion", "14.0");
		capabilities.setCapability("appium:deviceName", obj.get("deviceName").getAsString());

		// Specify the app package and main activity (replace with your app's package
		// and activity)
		// Command for get in CMD --> adb shell dumpsys window displays | grep -e
		// 'mCurrentFocus'
		capabilities.setCapability("appium:appPackage", obj.get("appPackage").getAsString());
		capabilities.setCapability("appium:appActivity", obj.get("appActivity").getAsString());
		capabilities.setCapability("appium:automationName", obj.get("automationName").getAsString());

		
		
		/*
		 * // Optional: Keep app data between sessions
		 * capabilities.setCapability("noReset", true); // Optional: If you are using a
		 * physical device, provide the UDID capabilities.setCapability("udid",
		 * "emulator-5554"); // Emulator ID or physical device UDID // Specify the path
		 * to the APK you want to install and test capabilities.setCapability("app",
		 * "/path/to/your/app.apk"); // Path to APK file // Optional: Start app in
		 * landscape or portrait mode capabilities.setCapability("deviceOrientation",
		 * "PORTRAIT");
		 */
		// Step 2: Initialize the AndroidDriver
		// Replace the URL with your Appium server's URL (default is 127.0.0.1:4723)

		// Create the AndroidDriver instance to start interacting with the app
		URL appiumServerURL;
		try {
			
			appiumServerURL = URI.create("http://127.0.0.1:4723").toURL();
			driver = new AndroidDriver(appiumServerURL, capabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@AfterClass
	public void closeServer() {
		driver.quit();
	}

}
