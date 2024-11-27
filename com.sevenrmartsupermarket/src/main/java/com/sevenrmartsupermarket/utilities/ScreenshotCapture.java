package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.Constants;

public class ScreenshotCapture {
	TakesScreenshot takescreenshot;

	public void takeScreenshot(WebDriver driver, String imageName) {
		takescreenshot = (TakesScreenshot) driver;// Interface =driver, Explicit
		try {
			File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE);// this is a file format
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// getting time stamp for
																								// screenshot capture
			String path = Constants.SCREENSHOT_FILE_PATH + imageName + "_" + timeStamp + ".png";// which path we need to
																								// save and which image
			File destination = new File(path);
			// FileHandler.copy(a, b);
			FileHandler.copy(screenshot, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
