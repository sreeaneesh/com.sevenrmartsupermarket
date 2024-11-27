package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class HomeTest extends Base {
	HomePage homepage;
	ScreenshotCapture screenshotcapture = new ScreenshotCapture();

	@Test(groups = { "smoke", "regression" }) 
	public void VerifyAdminUserLogin()

	{
		screenshotcapture.takeScreenshot(driver, "Aneesh");
	}
}
