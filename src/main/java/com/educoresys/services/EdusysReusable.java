package com.educoresys.services;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdusysReusable {
	
	public static WebDriver launchBrowser() {
		
		String browserDriver = null;		
        String profile = null;
        WebDriver driver = null; 
        
        String sBrowser = ReadConfig.prop_Config.getProperty("browser");
        System.out.println(sBrowser);
        
		switch (sBrowser) {
		case "chrome" :
			browserDriver = ReadConfig.prop_Config.getProperty("ChromeDriver");
	        profile = ReadConfig.prop_Config.getProperty("ChromePath");

	        System.setProperty("webdriver.chrome.driver", browserDriver);
			
/*	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        ArrayList<String> switches = new ArrayList<String>();
	        switches.add("--user-data-dir=" + profile);
	        System.out.println(switches);
	        capabilities.setCapability("chrome.switches", switches);
	        driver = new ChromeDriver(capabilities);*/
	        driver = new ChromeDriver();
	        break;
	        
		case "firefox" :
			browserDriver = ReadConfig.prop_Config.getProperty("FirefoxDriver");
	        //profile = ReadConfig.prop_Config.getProperty("FirefoxPath");
	        System.setProperty("webdriver.gecko.driver", browserDriver);
	        
			driver = new FirefoxDriver();
	        break;
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	
}
