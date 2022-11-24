package selenium.test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_Object_model.Page_Object;
import resources.Config;

public class Selenium_Test extends Config {
	public WebDriver driver;
	public Page_Object pop;

	@BeforeTest
	public void initDriver() throws Exception {
		driver = init();
		driver.get(prop.getProperty("URL"));
	}

	@Test
	public void loginTest() {
		pop = new Page_Object(driver);
		pop.getUserName().sendKeys("");
		pop.getPassword().sendKeys("");

	}

	@Test
	public void getStaticDropDown() {
		WebElement opt = driver.findElement(By.id(""));
		Select option = new Select(opt);
		option.selectByIndex(2);
		option.selectByValue("india");
		option.selectByVisibleText("");
	}

	@Test
	public void getDynamicDRopDown() {
		WebElement search = driver.findElement(By.xpath(""));
		search.sendKeys("Ind");
		List<WebElement> options = driver.findElements(By.className(""));
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equalsIgnoreCase("India")) {
				options.get(i).click();
			}
		}

	}

	@Test
	public void getRadioCheck() {
		WebElement check = driver.findElement(By.tagName(""));
		boolean t = check.isSelected();
		if (t) {
			check.click();
		}
	}

	@Test
	public void windowalert() {
		driver.switchTo().alert().accept();
	}

	@Test
	public void add_items_to_cart_in_webpage() {
		int j = 0;
		String[] want = { "A", "B", "C", "D", "E", "F" };

		List<WebElement> items = driver.findElements(By.className(""));
		for (int i = 0; i < items.size(); i++) {
			List<String> item = Arrays.asList(want);
			if (items.contains(item)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == items.size()) {
					break;
				}
			}
		}

	}
	
	@Test
	public void addWindowAction() {
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.tagName("a"))).contextClick();
		
	}
	
	
}
