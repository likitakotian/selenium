package com.hero.testkuapp.sample_Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectModel {

	 public WebDriver driver;

	 public PageObjectModel(WebDriver driver) {
		this.driver = driver;
	}

	private By addElementButtonRoot = By.xpath("//button[contains(.,'Add Element')]");
	private By deleteButtonRoot = By.xpath("//button[@class='added-manually']");
	private By findImages = By.tagName("img");

	public WebElement getButton() {
		return driver.findElement(addElementButtonRoot);
	}
	
	public WebElement getDeleteButton() {
		return driver.findElement(deleteButtonRoot);
	}
	
	public List<WebElement> getImages() {
		return driver.findElements(findImages);
	}

}
