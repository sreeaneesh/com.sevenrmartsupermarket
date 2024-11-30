package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class HomeTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	AdminUserPage adminuserpage;
	ScreenshotCapture screenshotcapture = new ScreenshotCapture();

	@Test(groups = { "smoke", "regression" }) 
	public void VerifyAdminUserLogin()

	{
		screenshotcapture.takeScreenshot(driver, "Aneesh");//screenshot taken
	}
	
	@Test
	public void VerifyAdminMoreInfoClick() {
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");
		adminuserpage=homepage.clickAdminMoreInfo();
		
	}
}
