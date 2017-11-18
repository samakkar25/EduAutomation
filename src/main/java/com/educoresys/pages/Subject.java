package com.educoresys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.educoresys.services.ReadConfig;

public class Subject extends AbstractBasePage {
	
	public Subject(WebDriver driver) {
		super(driver);
	}
	
	public void createSubject(String strSubjectName, String strSubjectCode, boolean activity) throws InterruptedException {
		
		String header = driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("pgSubjectHeader"))).getText();
		System.out.println(header);
		Thread.sleep(1000);
		driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("btnImgAdd"))).click();
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//a[contains(text(),'Add')]/i")));
		driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("pgSubjectTxtName"))).sendKeys(strSubjectName);
		Thread.sleep(1000);
		driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("pgSubjectTxtCode"))).sendKeys(strSubjectCode);
		Thread.sleep(1000);
		if (activity) {
			driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("pgSubjectSwtchActivity"))).click();
			Thread.sleep(1000);	
		}
		
		driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("btnImgSave"))).click();
		
		String strResult = driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("ElementNotification"))).getText();	
		if (strResult.equals("Subject saved successfully.")) {
			System.out.println("Subject saved successfully");
		}
		else {
			System.out.println("Failed to saved subject");
		}
	}
	
}
