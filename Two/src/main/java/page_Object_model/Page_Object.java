package page_Object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_Object  {
	
	public WebDriver driver;
	public Page_Object(WebDriver driver) {
		this.driver=driver;
	}

	private By username = By.xpath("");
	private By password = By.xpath("");

	public WebElement getUserName() {
		return driver.findElement(username);

	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
}
