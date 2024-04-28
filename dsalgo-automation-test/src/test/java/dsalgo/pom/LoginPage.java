package dsalgo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsalgo.utilities.Constants;

public class LoginPage extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(className = "btn")
	WebElement getStartButtonWE;

	@FindBy(linkText = "Register")
	WebElement registerLinkWE;
	
	@FindBy(linkText = "Sign in")
	WebElement signInLinkWE;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	public void clickGetStartButton() {
		getStartButtonWE.click();
	}

	public String checkRegister() {

		return registerLinkWE.getText();
	}

	public void selectMenu(String selectedItem) {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText(selectedItem))).click().perform();
	}

	public void clickAnyButton(String value) {

		driver.findElement(By.linkText(value)).click();
	}

	public void clickRegisterLink(String selectedItem) {

		registerLinkWE.click();
	}
	
	public String checkSignIn() {

		return signInLinkWE.getText();
	}
	
	public void clickDataStructureDropDownInHomePage() {
		driver.get(Constants.DS_HOME_URL);
		driver.findElements(By.linkText("Data Structures")).get(0).click();

	}
}
