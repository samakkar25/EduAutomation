package com.educoresys.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.educoresys.services.ReadConfig;

public abstract class AbstractBasePage implements BasePage{
	
	protected WebDriver driver;
	public AbstractBasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void readNotification() {
		try {
			String strAction = driver.findElement(By.xpath(ReadConfig.objRepo.getProperty("ElementNotification"))).getText();
			System.out.println("Login Failed: " + strAction);			
		} catch(NoSuchElementException e) {
			System.out.println("Login Passed");
		}
	}
	
	
	public void getColumnNames() {
		
		List<WebElement> colHeader = driver.findElements(By.xpath(ReadConfig.objRepo.getProperty("pgSubjectTblHeader")));
		
		ArrayList<String> colNames = new ArrayList<String>();
		for (WebElement e : colHeader) {
			//System.out.println(e.getText());
			colNames.add(e.getText());
		}
		System.out.println(colNames);
	}
	

	public int getColumnIndex(String strColumnName) {

		int i = -1;
		List<WebElement> colHeader = driver.findElements(By.xpath(ReadConfig.objRepo.getProperty("pgSubjectTblHeader")));
		for (i=0; i<=colHeader.size()-1; i++) {
			if(strColumnName.equals(colHeader.get(i).getText())) {
				return i;
			}
			
		}
		return i;
	}
	
	
	public String getTableCellData(int rowNum, String strColumnName) {
		
		int colIndex = getColumnIndex(strColumnName);
		if (colIndex!=-1) {
			colIndex = colIndex + 1;
		}
		else {
			System.out.println("Error while fetching column index");
		}
		
		String xPathTableData = "//*[@id='ManageSubjectTable']//tbody/tr["+ rowNum + "]/td[" + colIndex + "]";
		return driver.findElement(By.xpath(xPathTableData)).getText();
		
	}
	
	public boolean isElementVisible(String xpathExpression) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpathExpression))));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	
	public boolean isElementExist(String xpathExpression) {
		try {
			driver.findElement(By.xpath(xpathExpression));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void clickElement(String xpathExpression) {
		if(isElementExist(xpathExpression)) {
			driver.findElement(By.xpath(xpathExpression)).click();
		} else {
			System.out.println("Element Not visible");
		}
	}
	
}
