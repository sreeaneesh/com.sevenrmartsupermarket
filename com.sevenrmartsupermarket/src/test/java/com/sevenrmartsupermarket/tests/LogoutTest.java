package com.sevenrmartsupermarket.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LogoutTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader=new ExcelReader();
	@Test
	public void VerifyAdminUserLogin() {
		excelreader.setExcelFile("LoginDetails", "LoginCredentials");//Login details-Excel name, Login Credentials -sheet name
		String readData1=excelreader.getCellData(0, 1); //username admin 
		String readData2=excelreader.getCellData(1, 1);
		System.out.println(readData1);
		System.out.println(readData2);
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login("admin", "admin");
		
		}
}



