package com.devlabs.testng.base;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.devlabs.selenium.base.SeleniumWrappers;

import utils.DataLibrary;


public class ProjectGenericWrappers extends SeleniumWrappers {

	public String dataSheetName;		

	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}	

	@BeforeMethod
	public void beforeMethod() {
		driver = startApp("chrome", "https://dev59616.service-now.com/");
		// Creating sub test for the reporter
		node = test.createNode(testCaseName);
	}

	@AfterMethod
	public void afterMethod() {
		close();
	}













}
