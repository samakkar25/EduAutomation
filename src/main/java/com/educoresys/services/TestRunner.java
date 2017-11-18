package com.educoresys.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestRunner {

	public static void launchBrowser() throws FileNotFoundException, IOException {
		
        Properties prop = new Properties();
		prop.load(new FileInputStream(new File("D:\\Java\\Workspaces\\educoresys\\src\\main\\java\\config.properties")));
		
        String chromeDriver = prop.getProperty("ChromeDriver");
        String chromeProfile = prop.getProperty("ChromePath");
        System.setProperty("webdriver.chrome.driver", chromeDriver);
		
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ArrayList<String> switches = new ArrayList<String>();
        switches.add("--user-data-dir=" + chromeProfile);
        System.out.println(switches);
        capabilities.setCapability("chrome.switches", switches);
        
        WebDriver driver = new ChromeDriver(capabilities);
        //WebDriver driver = new ChromeDriver();
        
		/*
		System.setProperty("webdriver.chrome.driver", "exe//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		*/
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("appURL"));
		
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		
	}
	
	
}
