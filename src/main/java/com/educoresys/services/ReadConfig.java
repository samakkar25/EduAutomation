package com.educoresys.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public static Properties prop_Config = new Properties();

	public static Properties objRepo;
	
	public static void readConfig() throws FileNotFoundException, IOException {
		prop_Config = new Properties();
		prop_Config.load(new FileInputStream(new File("src\\main\\java\\config\\config.properties")));	
	}
	
	public static void loadElementsInfo() throws FileNotFoundException, IOException {
		objRepo = new Properties();
		objRepo.load(new FileInputStream("src\\main\\java\\config\\objectrepo.properties"));
	}
		
}
