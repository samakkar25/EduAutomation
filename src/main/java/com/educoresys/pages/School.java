package com.educoresys.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.educoresys.services.ReadConfig;

public class School {

	private WebDriver driver;
	public static Properties objRepo = new Properties();
	
	public School(WebDriver driver) throws FileNotFoundException, IOException {
		this.driver = driver;
		
		objRepo = new Properties();
		objRepo.load(new FileInputStream("src\\main\\java\\config\\school.properties"));
		
	}
	
	public void createSchool() throws InterruptedException, IOException {
		
//		String header = driver.findElement(By.xpath(objRepo.getProperty("pgSubjectHeader"))).getText();
//		System.out.println(header);
		
		driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("btnImgAdd"))).click();
		
		driver.findElement(By.xpath(objRepo.getProperty("textName"))).sendKeys("Little Angel School");
		driver.findElement(By.xpath(objRepo.getProperty("textPhone1"))).sendKeys("9871965151");
		driver.findElement(By.xpath(objRepo.getProperty("textAddress1"))).sendKeys("mashad mohalla");
		driver.findElement(By.xpath(objRepo.getProperty("textCity"))).sendKeys("snp");
		driver.findElement(By.xpath(objRepo.getProperty("textState"))).sendKeys("haryana");
		driver.findElement(By.xpath(objRepo.getProperty("textPincode"))).sendKeys("131001");
		driver.findElement(By.xpath(objRepo.getProperty("textSchoolAdminName"))).sendKeys("snpadmin");
		driver.findElement(By.xpath(objRepo.getProperty("textSchoolAdminMobile"))).sendKeys("9871965151");	
		driver.findElement(By.xpath(objRepo.getProperty("textSchoolAdminEmail"))).sendKeys("saurabh@gmail.com");
		
		driver.findElement(By.xpath(objRepo.getProperty("btnReset"))).click();
		
	}
}
