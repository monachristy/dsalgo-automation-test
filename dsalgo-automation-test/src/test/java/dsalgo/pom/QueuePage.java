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

public class QueuePage extends BaseClass{
	
	@FindBy(xpath = "//a[@href='implementation-lists']")
	WebElement implListsWE;
	
	@FindBy(xpath = "//a[@href='implementation-collections']")
	WebElement implCollectionsWE;

	@FindBy(xpath = "//a[@href='Implementation-array']")
	WebElement implArrayWE;
	
	@FindBy(xpath = "//a[@href='QueueOp']")
	WebElement queueOpWE;
	
	@FindBy(xpath = "//a[@href='/queue/practice']")
	WebElement queuePracticeWE;
	
	WebDriver driver;
	WebDriverWait wait;
	
	public QueuePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}
	
	public void clickImplLists() {
		implListsWE.click();
	}
	
	public void clickImplCollections() {
		implCollectionsWE.click();
	}
	
	public void clickImplArray() {
		implArrayWE.click();
	}
	
	public void clickQueueOperations() {
		queueOpWE.click();
	}
	
	public void clickPractice() {
		queuePracticeWE.click();
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
