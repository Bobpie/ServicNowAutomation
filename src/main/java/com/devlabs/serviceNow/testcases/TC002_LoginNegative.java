package com.devlabs.serviceNow.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.devlabs.serviceNow.pages.LoginPage;
import com.devlabs.testng.base.ProjectGenericWrappers;

public class TC002_LoginNegative extends ProjectGenericWrappers{	

	@BeforeTest
	public void setValues() {
		// Naming the main test
		testCaseName = "Login Negative";
		testDescription = "Login using invalid username and password";
		authors = "Devlabs";
		category = "Smoke";
		// Naming the sub test
		nodes = "Login";
		// Naming the test data source
		dataSheetName = "./data/TC002.xlsx";
	}

	@Test(dataProvider = "fetchData")
	public void loginPositive(String username, String password, String errorMsg) {
		new LoginPage(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin_Negative()
		.verifyErrorMessage(errorMsg);
	}


}





