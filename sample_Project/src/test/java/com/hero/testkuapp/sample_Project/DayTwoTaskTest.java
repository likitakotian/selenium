package com.hero.testkuapp.sample_Project;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DayTwoTaskTest extends ConfigFile {

	private WebDriver driver;
	private PageObjectModel pageObjectModel;

	@BeforeTest
	public void initDriver() throws IOException {
		initializeWebDriver();
		driver = getInitializedDriver();
		pageObjectModel = new PageObjectModel(driver);
		
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

	@Test(enabled = false)
	public void validateCheckBox() {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		if (pageObjectModel.getCheckBoxOne().isSelected()) {
			pageObjectModel.getCheckBoxOne().click();
		} else {
			pageObjectModel.getCheckBoxTwo().click();
		}
		assertTrue(pageObjectModel.getCheckBoxOne().isEnabled());
		System.out.println("Checkbox one is selected");
	}

	@Test(enabled = false)
	public void getJavaScriptAlert() {
		driver.get("https://the-internet.herokuapp.com/context_menu");
		Actions actions = new Actions(driver);
		actions.moveToElement(pageObjectModel.getContextMenu()).contextClick().build().perform();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test(enabled = false)
	public void validateDragAndDrop() {
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		Actions actions = new Actions(driver);
		actions.dragAndDrop(pageObjectModel.getSource(), pageObjectModel.getDestination());
		assertTrue(true);
		System.out.println("Sucessfully validated Drag and Drop");
		
	}
	
	@Test(enabled = false)
	public void selectValidOption() {
		driver.get("https://the-internet.herokuapp.com/dropdown");
		pageObjectModel.getoptionField().click();
		Select select = new Select(pageObjectModel.getoptionField());
		select.selectByIndex(2);
		System.out.println("Option 2 is selected");
	}
	
	@Test(enabled = false)
	public void closeEntryAdd() {
		driver.get("https://the-internet.herokuapp.com/entry_ad");
		pageObjectModel.getCloseEntryAdd().click();
		assertTrue(true);
		System.out.println("Entry add is succesfully closed!");
	}
	
	@Test(enabled = true)
	public void downloadTheFile() {
		driver.get("https://the-internet.herokuapp.com/download");
		for(int i=0;i<pageObjectModel.getFiles().size();i++) {
			String download = "test.txt";
			if(pageObjectModel.getFiles().get(i).getText().equalsIgnoreCase(download)) {
				pageObjectModel.getFiles().get(i).click();
			}
		}
	}
}
