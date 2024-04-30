package dsalgo.stepdefs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsalgo.pom.GraphPage;
import dsalgo.pom.TreePage;
import dsalgo.utilities.Constants;
import dsalgo.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GraphStepDefinition {
	
	WebDriver driver = WebDriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	GraphPage graphPage=new GraphPage(driver, wait);


	@Given("User enters the Graph page by clicking get started")
	public void user_enters_the_graph_page_by_clicking_get_started() throws Exception {
		driver.get(Constants.DS_HOME_URL);
		driver.findElement(By.xpath("//a[contains(@href,'graph')and contains(text(),'Get Started')]")).click();
	}
	
	@When("User clicks the list of Graph links")
	public void user_clicks_the_list_of_graph_links() {
		driver.get(Constants.TREE_URL);
	}
	
	@Then("checking the try editor box")
	public void checking_the_try_editor_box() throws Exception {
		WebElement graph_element;
		List<WebElement> graph_list;
		try {
			Thread.sleep(2000);
			graph_element = driver.findElement(By.xpath("/html/body/div[2]"));
			graph_list = graph_element.findElements(By.tagName("ul"));
		} catch(StaleElementReferenceException e) { 
			driver.navigate().refresh(); 
			graph_element = driver.findElement(By.xpath("/html/body/div[2]"));
			graph_list = graph_element.findElements(By.tagName("ul"));
		}
		
		
		for (WebElement each_ele : graph_list) {
			Thread.sleep(1000);
			each_ele.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@class = 'btn btn-info']")).click();
			
			graphPage.executeRunButton("print(\"hello\");");
			
			driver.navigate().back();
			driver.navigate().back();


		}
	}
	
	@When("The user clicks the {string} button in Graph Panel")
	public void the_user_clicks_the_button_in_graph_panel(String string) {
		driver.get(Constants.DS_HOME_URL);
		graphPage.clickHyperLink("graph");
	}

	@Then("The user should be redirected to Graph page")
	public void the_user_should_be_redirected_to_graph_page() {
		graphPage.verifyTextPresent("Graph");
	}

}