package resources;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Config {

	public WebDriver driver;
	public Properties prop;

	public WebDriver init() throws Exception {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\likja\\eclipse-workspace\\Two\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\likja\\eclipse-workspace\\Two\\src\\main\\java\\resources\\chromedriver.exe");

		}
		WebElement test=driver.findElement(By.xpath(""));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(test));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}

	public void getScreenShot() throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyDirectory(src, new File(""));

	}
	
	
}
