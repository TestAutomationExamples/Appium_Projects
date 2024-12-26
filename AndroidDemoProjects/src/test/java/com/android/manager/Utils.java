package com.android.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;

public class Utils {

	AndroidDriver driver;
	WebDriver driver1;

	public Utils() {
	}

	public Utils(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public Utils(WebDriver driver) {
		this.driver1= driver;
	}

	public JsonObject getJsonObject(String filename) {

		// Create a FileReader to read the JSON file
		String filePath = "D://Deepika//AndroidDemoProjects//src//test//java//resources//" + filename;
		FileReader reader = null;
		try {
			reader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonElement jsonObject = JsonParser.parseReader(reader);
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.getAsJsonObject();
//

	}

	public String getJsonData(JsonObject object, String key) {

		return object.get(key).getAsString();

	}

	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] captureScreenshot() {
		File screenshotFile = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		try {
			// Save the screenshot to a temporary location (optional)
			FileUtils.copyFile(screenshotFile, new File("screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Convert the screenshot file to byte array and return it to attach to Allure
		// report
		byte[] screenshotBytes = null;
		try {
			screenshotBytes = FileUtils.readFileToByteArray(screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return screenshotBytes;
	}

	
}
