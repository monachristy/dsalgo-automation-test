package dsalgo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TreePage extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;

	public TreePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

}
