package dsalgo.stepdefs;

import java.time.Duration;
import java.util.List;

import javax.annotation.concurrent.ThreadSafe;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsalgo.pom.TreePage;
import dsalgo.utilities.Constants;
import dsalgo.webdriver.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TreeStepDefinition{

	WebDriver driver = WebDriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	TreePage treePage=new TreePage(driver, wait);
	
	@When("The user clicks the {string} button in Tree Panel")
	public void the_user_clicks_the_button_in_tree_panel(String string) {
		treePage.clickHyperLink("tree");
	}
	
	@Then("The user should be redirected to Tree page")
	public void the_user_should_be_redirected_to_tree_page() {
		treePage.verifyTextPresent("Tree");
	}
	
	@Given("The user is on tree page")
	public void the_user_is_on_tree_page() {

	}

	@When("User clicks the list of Tree links")
	public void user_clicks_list_of_Tree_links() throws Exception {
		driver.get(Constants.TREE_URL);

	}

	@And("enters the list of Tree links and checking try editor box")
	public void enters_the_list_of_Tree_links_and_checking_try_editor_box() throws Exception {

		WebElement tree_element;
		List<WebElement> tree_list;
		try {
			Thread.sleep(2000);
			tree_element = driver.findElement(By.xpath("/html/body/div[2]"));
			tree_list = tree_element.findElements(By.tagName("ul"));
		} catch(StaleElementReferenceException e) { 
			driver.navigate().refresh(); 
			tree_element = driver.findElement(By.xpath("/html/body/div[2]"));
			tree_list = tree_element.findElements(By.tagName("ul"));
		}
		
		
		for (WebElement each_ele : tree_list) {
			Thread.sleep(2000);
			each_ele.click();
			driver.findElement(By.xpath("//a[@class = 'btn btn-info']")).click();
			driver.get("https://dsportalapp.herokuapp.com/tryEditor");
			
			treePage.executeRunButton("print(\"hello\");");

			driver.navigate().back();
			driver.navigate().back();

		}
	}


}
