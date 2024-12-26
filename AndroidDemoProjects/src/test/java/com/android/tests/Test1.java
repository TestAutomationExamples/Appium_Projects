package com.android.tests;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Test1 {
	
	@Test
	public void downloadApkFile() throws MalformedURLException, InterruptedException, FileNotFoundException {
		UiAutomator2Options option=new UiAutomator2Options();
		option.setDeviceName("MediumEmulator");
		option.setApp("D://Deepika//AndroidDemoProjects//src//test//java//resources//General-Store.apk");
Thread.sleep(2000);
		AndroidDriver driver=new AndroidDriver(URI.create("http://127.0.0.1:4723").toURL(),option); 
		Thread.sleep(5000);
		
		driver.quit();
		
		

	}

}
