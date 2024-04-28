package dsalgo.stepdefs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	GraphPage graphPage=new GraphPage(driver, wait);


	@Given("User enters the Graph page by clicking get started")
	public void user_enters_the_graph_page_by_clicking_get_started() throws Exception {
		driver.findElement(By.xpath("//a[contains(@href,'graph')and contains(text(),'Get Started')]")).click();
		Thread.sleep(2000);
	}
	
	@When("User clicks the list of Graph links")
	public void user_clicks_the_list_of_graph_links() {
		driver.get(Constants.TREE_URL);
	}
	
	@Then("checking the try editor box")
	public void checking_the_try_editor_box() throws Exception {
		WebElement graph_element = driver.findElement(By.xpath("/html/body/div[2]"));
		List<WebElement> graph_list = graph_element.findElements(By.tagName("ul"));
		for (WebElement each_ele : graph_list) {
			each_ele.click();
			driver.findElement(By.xpath("//a[@class = 'btn btn-info']")).click();
			driver.get("https://dsportalapp.herokuapp.com/tryEditor");
			
			graphPage.executeRunButton("print(\"hello\");");
			
//			driver.findElement(By.xpath("//form[@id='answer_form']/div/div/div/textarea"))
//					.sendKeys("print(\"hello\");");
//			driver.findElement(By.xpath("//button[@onclick=\"runit()\"]")).click();

			Thread.sleep(1000);
			driver.navigate().back();
			driver.navigate().back();

			Thread.sleep(1000);

		}
	}
	
	@When("The user clicks the {string} button in Graph Panel")
	public void the_user_clicks_the_button_in_graph_panel(String string) {
		graphPage.clickHyperLink("graph");
	}

	@Then("The user should be redirected to Graph page")
	public void the_user_should_be_redirected_to_graph_page() {
		graphPage.verifyTextPresent("Graph");
	}

}