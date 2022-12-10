package com.hero.testkuapp.sample_Project;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@Test
public class ChromeInitiationTest extends ConfigFile {

	private WebDriver driver;
	private PageObjectModel pom;

	@BeforeTest
	public void initDriver() throws Exception {
		initializeWebDriver();
		driver = getInitializedDriver();
		driver.get("https://the-internet.herokuapp.com/");
		pom = new PageObjectModel(driver);
	}

	@Test(enabled = false)
	public void clickOnElement() {
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		pom.getButton().click();
		pom.getDeleteButton().click();
	}

	@Test(enabled = false)
	public void valiadteAuthentication(String admin) {
		String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
		driver.get(url);
		driver.switchTo().alert().accept();
	}

	@Test(enabled = true)
	public void findBrokenImages() {
		// getattribute("src') URl
		// url.oprnconnection()
		// setrequestmethod(get)
		// getresponsecode()

		driver.get("https://the-internet.herokuapp.com/broken_images");
		int invalidImageCount = 0;

		for (WebElement imgElement : pom.getImages()) {
			if (imgElement != null) {
				try {
					URL imageUrl = new URL(imgElement.getAttribute("src"));
					HttpURLConnection httpURLConnection = (HttpURLConnection) imageUrl.openConnection();
					httpURLConnection.setRequestMethod("GET");
					int responseCode = httpURLConnection.getResponseCode();
					if (responseCode != 200)
						invalidImageCount++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Total no. of invalid images are " + invalidImageCount);

	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
}
