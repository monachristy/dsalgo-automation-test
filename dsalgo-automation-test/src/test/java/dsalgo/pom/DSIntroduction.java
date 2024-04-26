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

public class DSIntroduction extends BaseClass {
	
	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement getStartedDSIntroWE;
	
	@FindBy(xpath = "//a[@href='array']")
	WebElement getStartedArrayWE;
	
	@FindBy(xpath = "//a[@href='linked-list']")
	WebElement getStartedLinkedListWE;
	
	@FindBy(xpath = "//a[@href='stack']")
	WebElement getStartedStackWE;
	
	@FindBy(xpath = "//a[@href='queue']")
	WebElement getStartedQueueWE;
	
	@FindBy(xpath = "//a[@href='tree']")
	WebElement getStartedTreeWE;
	
	WebDriver driver;
	WebDriverWait wait;
	
	public DSIntroduction(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}
	
	public void executeRunButton(String input) throws InterruptedException {
		driver.get("https://dsportalapp.herokuapp.com/tryEditor");
		
		WebElement element = driver.findElement(By.xpath("//form[@id='answer_form']/div/div/div/textarea")); 
		Actions actions = new Actions(driver); 
		actions.moveToElement(element).click().sendKeys(input).build().perform();
		new WebDriverWait(driver,  Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//button[@onclick=\"runit()\"]")));
		driver.findElement(By.xpath( "//button[@onclick=\"runit()\"]")).click();
	}
}

