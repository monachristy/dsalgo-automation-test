package dsalgo.pom;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsalgo.utilities.Constants;
import dsalgo.webdriver.WebDriverFactory;

public class BaseClass {
	
	WebDriver driver = WebDriverFactory.getDriver();;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitLoginWE;
	
	@FindBy(linkText = "Try here>>>")
	WebElement tryButtonWE;
	
	@FindBy(id = "answer_form")
	WebElement editPageWE;
	
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
	WebElement editTextArea;
	
	@FindBy(xpath = "//button[@onclick=\"runit()\"]")
	WebElement runItButtonWE;
	
	@FindBy(name = "username")
	WebElement userNameWE;
	
	@FindBy(name = "password")
	WebElement passwordWE;
	
	private static final Logger logger = LogManager.getLogger(BaseClass.class);
	
	public BaseClass(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		logger.info("Creating Object " + this + "for the driver " + driver);
		this.driver = driver;
		this.wait = wait;
	}
	
	public void submitLogin() {
		submitLoginWE.click();
	}
	
	public String getValidationMessage(By by){
		return driver.findElement(by).getAttribute("valudationMessage");
	}
	
	public String getValidationMessage(WebElement we){
		return we.getAttribute("validationMessage");
	}
		
	public void navigateBack(){
		driver.navigate().back();
	}
	
	public String getJsAlertText()
	{
	Object txt = ((JavascriptExecutor)driver).executeScript("return window.alert.myAlertText;");
	return (String)txt;
	}
		
	public String getAlertText(){
		return driver.switchTo().alert().getText();
	}

	public void enterUserId(String username){
		userNameWE.sendKeys(username);
	}
	
	public void enterPassword(String password){
		passwordWE.sendKeys(password);
	}

	public boolean verifyTextPresent(String value) {
		return driver.getPageSource().contains(value);
	}
	
	public void clickDataStructureDropDown() {
		driver.findElements(By.linkText("Data Structures")).get(0).click();

	}
	
	public void selectMenu(String selectedItem) {

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.linkText(selectedItem))).click().perform();
	}

	public void clickHyperLink(String value) {
		WebElement link = driver.findElement(By.xpath("//a[@href=\""+value+"\"]"));
		link.click();
	}
	
	public void login() throws InterruptedException {
		driver.get(Constants.DS_LOGIN_URL);
		Thread.sleep(1000);
		Actions actions = new Actions(driver); 
		actions.moveToElement(driver.findElement(By.name("username"))).click().sendKeys("dsalgomarch2024").build().perform();
		actions.moveToElement(driver.findElement(By.name("password"))).click().sendKeys("Numpy2024").build().perform();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public void clickTryButton() {
		wait.until(ExpectedConditions.visibilityOf(tryButtonWE)).click();
	}
	
	public boolean isNavigatedToAnswerForm() {
		return editPageWE.isDisplayed();
	}
	
	public void waitForStaleElement(By by)
	{
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void executeRunButton(String input) throws InterruptedException {
		driver.get(Constants.DS_TRY_EDITOR);
		
		WebElement element = driver.findElement(By.xpath("//form[@id='answer_form']/div/div/div/textarea")); 
		Actions actions = new Actions(driver); 
		actions.moveToElement(element).click().sendKeys(input).build().perform();
		new WebDriverWait(driver,  Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//button[@onclick=\"runit()\"]")));
		driver.findElement(By.xpath( "//button[@onclick=\"runit()\"]")).click();
	}
	
	
}
