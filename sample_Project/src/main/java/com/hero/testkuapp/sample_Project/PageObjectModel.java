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
	private By checkBoxOne = By.xpath("(//input[@type='checkbox'])[1]");
	private By checkBoxTwo = By.xpath("(//input[@type='checkbox'])[2]");
	private By contextMenu = By.xpath("//div[@id='hot-spot']");
	private By source = By.xpath("//div[@id='column-a']");
	private By destination = By.xpath("//div[@id='column-b']");
	private By optionField = By.id("dropdown");
	private By closeAdd = By.xpath("//p[normalize-space()='Close']");
	private By files = By.tagName("a");
	
	public WebElement getButton() {
		return driver.findElement(addElementButtonRoot);
	}
	
	public WebElement getDeleteButton() {
		return driver.findElement(deleteButtonRoot);
	}
	
	public List<WebElement> getImages() {
		return driver.findElements(findImages);
	}
	
	public WebElement getCheckBoxOne() {
		return driver.findElement(checkBoxOne);
	}

	public WebElement getCheckBoxTwo() {
		return driver.findElement(checkBoxTwo);
	}
	
	public WebElement getContextMenu() {
		return driver.findElement(contextMenu);
	}
	
	public WebElement getSource() {
		return driver.findElement(source);
	}
	
	public WebElement getDestination() {
		return driver.findElement(destination);
	}
	
	public WebElement getoptionField() {
		return driver.findElement(optionField);
	}
	
	public WebElement getCloseEntryAdd() {
		return driver.findElement(closeAdd);
	}
	
	public List<WebElement> getFiles(){
		return driver.findElements(files);
	}
}
