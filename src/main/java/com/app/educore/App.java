package com.app.educore;


import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.educoresys.pages.Login;
import com.educoresys.pages.Navigation;
import com.educoresys.pages.School;
import com.educoresys.pages.Subject;
import com.educoresys.services.EdusysReusable;
import com.educoresys.services.ReadConfig;

public class App {

	public static void main( String[] args) throws InterruptedException, FileNotFoundException, IOException {
	    
		System.out.println( "Starting!" );
		/*HashMap<Integer, Object> map = ExcelUtils.getExcelData("src\\main\\java\\testdata\\TestData.xlsx", "School", true);
		
		for (Map.Entry<Integer, Object> e: map.entrySet()) {
			System.out.println("key - " + e.getKey());
			System.out.println("value - " + e.getValue());
		}*/
		
		ReadConfig.readConfig();
		ReadConfig.loadElementsInfo();
		
		String appURL = ReadConfig.prop_Config.getProperty("appURL");
		String userName = ReadConfig.prop_Config.getProperty("username");
		String password = ReadConfig.prop_Config.getProperty("password");
		
		WebDriver driver = EdusysReusable.launchBrowser();
		
		Login login = new Login(driver);
		
		login.loginApp(appURL, userName, password);
		
		Navigation navigate = new Navigation(driver);
		
		navigate.navigateModule("School", "Section");

		driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("btnImgAdd"))).click();
		/*
		 * 
		 * 	       WebElement Image = driver.findElement(By.xpath("//div/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/input"));
	       //Used points class to get x and y coordinates of element.
	        org.openqa.selenium.Point classname = Image.getLocation();
	        int xcordi = classname.getX();
	        System.out.println("Element's Position from left side"+xcordi +" pixels.");
	        int ycordi = classname.getY();
	        System.out.println("Element's Position from top"+ycordi +" pixels.");*/
		WebElement elem = driver.findElement(By.xpath("//div/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/input"));
		
		int width = elem.getSize().getWidth();

	    Actions act = new Actions(driver);
	    act.moveToElement(elem).moveByOffset((width/2)-2, 0).click().perform();
	    
/*		navigate.navigateModule("School", "Subject");
		Subject subject = new Subject(driver);
		int i = subject.getColumnIndex("Action");
		System.out.println(i);
		System.out.println(subject.getTableCellData(2, "Type"));
		
		System.out.println(subject.getTableCellData(2, "Status"));
		
		String strSubjectName = "Maths";
		String strSubjectCode = "1";
		subject.createSubject(strSubjectName, strSubjectCode, false);
		
		navigate.navigateModule("School", "School");
		School school = new School(driver);
		school.createSchool();
		*/
		
		Thread.sleep(2000);
		driver.quit();
    }
}
