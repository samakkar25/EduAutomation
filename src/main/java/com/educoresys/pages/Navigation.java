package com.educoresys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigation extends AbstractBasePage {
	
	public Navigation(WebDriver driver) {
		super(driver);
	}
	
	public void navigateModule(String menu, String subMenu) throws InterruptedException {
		System.out.println(menu + "-->" + subMenu);
		
		menu = "//span[contains(text(),'" + menu + "')]";
		subMenu = "//a[contains(text(),'" + subMenu + "')]";
		
		if (isElementVisible(subMenu)) {
			driver.findElement(By.xpath(subMenu)).click();
		} else {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sSwitch_primary"))));
			wait = new WebDriverWait(driver, 10);
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menu)));			
			} catch(Exception e) {
				driver.findElement(By.id("sSwitch_primary")).click();
				Thread.sleep(1000);
			}
			
			clickElement(menu);
			Thread.sleep(1000);
			clickElement(subMenu);
			Thread.sleep(1000);
				
		}
		
	}
	
}
