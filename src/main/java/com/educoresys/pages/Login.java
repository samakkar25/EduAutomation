package com.educoresys.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.educoresys.services.ReadConfig;

public class Login extends AbstractBasePage {
	
	public Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public void loginApp(String appURL, String userName, String password) throws InterruptedException, FileNotFoundException, IOException {
		
		driver.get(appURL);
		
		driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("loginTextUserName"))).sendKeys(userName);
		Thread.sleep(500);
		driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("loginTextPassword"))).sendKeys(password);
		Thread.sleep(500);
		driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("loginButtonSignIn"))).click();
		Thread.sleep(500);
		
		
	}
	
}
