package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties properties = new Properties();

	public Base() {
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Initialize browser **/
	public void initialize(String browser, String url) {
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		driver.manage().deleteAllCookies();
	}

	@Parameters("browser") // from crossbrowser.xml

	@BeforeMethod(enabled = false) // true or false set any one while running test suite method in crossbrowsers
	public void launchBrowser(String browser) {
		// String browser=properties.getProperty("browser");
		String url = properties.getProperty("url");
		initialize(browser, url);

	}

	@BeforeMethod(enabled = true, alwaysRun = true) // true or false set any one while running test suite method in
													// crossbrowsers
	public void launchBrowser() {
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		initialize(browser, url);

	}

}
