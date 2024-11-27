package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();

	@Test(retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void VerifyAdminUserLogin() {
		/*
		 * excelreader.setExcelFile("LoginDetails", "LoginCredentials"); String
		 * readData1 = excelreader.getCellData(0, 1); String readData2 =
		 * excelreader.getCellData(1, 1); System.out.println(readData1);
		 * System.out.println(readData2);
		 */
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login("admin", "admin");
		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
		System.out.println(GeneralUtility.getRandomAddress());
		System.out.println(GeneralUtility.getRandomName());
	}

}
