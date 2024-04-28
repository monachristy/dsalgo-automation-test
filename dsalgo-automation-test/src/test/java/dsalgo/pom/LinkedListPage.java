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

public class LinkedListPage  extends BaseClass {
	
	@FindBy(xpath = "//a[@href='stack']")
	WebElement stackGetStarted;
	
	@FindBy(xpath = "//a[@href='operations-in-stack']")
	WebElement operationsInStack;
	
	@FindBy(xpath = "//a[@href='implementation']")
	WebElement implementation;
	
	@FindBy(xpath = "//a[@href='stack-applications']")
	WebElement stackApplications;
	
	 
	WebDriver driver;
	WebDriverWait wait;
	

	public LinkedListPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	public void clickStackGetStarted() {
		stackGetStarted.click();
	}
	
	public void clickOperationsInStack() {
		operationsInStack.click();
	}

	public void clickStackImplementation() {
		implementation.click();
	}

	public void clickStackApplications() {
		stackApplications.click();
	}

}
