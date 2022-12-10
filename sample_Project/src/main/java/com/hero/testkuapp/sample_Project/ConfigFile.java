package com.hero.testkuapp.sample_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConfigFile {

	public WebDriver driver;
	public TakesScreenshot takescScreenshot;

	public void initializeWebDriver() throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/resources/data.properties");
		properties.load(fis);

		String browserName = properties.getProperty("browser");
		System.out.println("browserName: "+browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/sagarliki/Downloads/chromedriver");
			
			if (browserName.contains("headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
			}
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
		} else if (browserName.contains("IE")) {
			System.setProperty("webdriver.ie.driver", "");
		}

	}

	public WebDriver getInitializedDriver() throws NullPointerException {
		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			return driver;
		} else
			throw new NullPointerException("Driver is not initialized");
	}

	public String takeFullScreenShot(String testcase) throws Exception {
		takescScreenshot = (TakesScreenshot) driver;
		File src = takescScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/resources/" + testcase + ".png";
		FileUtils.copyFile(src, new File(destination));
		return destination;
	}

	public String takePartialScreenShot(WebElement fail, String testcase) throws Exception {
		takescScreenshot = (TakesScreenshot) driver;
		File src = fail.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/resources/" + testcase + ".png";
		FileUtils.copyFile(src, new File(destination));
		return destination;

	}
}
