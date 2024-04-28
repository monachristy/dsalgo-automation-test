package dsalgo.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsalgo.utilities.Constants;

public class ArrayPage  extends BaseClass {
	
	@FindBy(xpath = "//a[@href='array']")
	WebElement arrayGetStarted;
	
	@FindBy(xpath = "//a[@href='arrays-in-python']")
	WebElement arraysInPython;
	
	@FindBy(xpath = "//a[@href='arrays-using-list']")
	WebElement arraysUsingList;
	
	@FindBy(xpath = "//a[@href='basic-operations-in-lists']")
	WebElement operationsInLists;
	
	@FindBy(xpath = "//a[@href='applications-of-array']")
	WebElement applicationsOfArray;
	
	 
	WebDriver driver;
	WebDriverWait wait;
	

	public ArrayPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}


}
