package dsalgo.stepdefs;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dsalgo.pom.QueuePage;
import dsalgo.pom.StackPage;
import dsalgo.utilities.CommonUtils;
import dsalgo.utilities.Constants;
import dsalgo.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QueueStepDefinition {
	WebDriver driver = WebDriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	QueuePage queuePage = new QueuePage(driver, wait);
	
	@Given("The user is on Home page after logged in")
	public void the_user_is_on_home_page_after_logged_in() {
		queuePage.login();
		driver.get(Constants.DS_HOME_URL);
	}

	@When("The user clicks the Getting Started button in Queue page")
	public void the_user_clicks_the_getting_started_button_in_queue_page() {
		queuePage.clickHyperLink("queue");
	}

	@Then("The user should be directed to Queue page")
	public void the_user_should_be_directed_to_queue_page() {
		Assert.assertTrue(queuePage.verifyTextPresent("Queue"));
	}

	@Given("user is on Queue page")
	public void user_is_on_queue_page() {
		driver.get("https://dsportalapp.herokuapp.com/queue/");
	}

	@When("user clicks on Implementation of Queue in Python link")
	public void user_clicks_on_implementation_of_queue_in_python_link() {
		queuePage.clickHyperLink("implementation-lists");
	}

	@Then("user should navigate to Implimentaion of Queue in Python page")
	public void user_should_navigate_to_implimentaion_of_queue_in_python_page() {
		Assert.assertTrue(queuePage.verifyTextPresent("Implementation of Queue in Python"));
	}

	@Given("user is on Implementaion of Queue in Python page")
	public void user_is_on_implementaion_of_queue_in_python_page() {
	    driver.get(Constants.QUEUE_IMPL_LIST_URL);
	    
	}

	@When("user clicks on button Try here")
	public void user_clicks_on_button_try_here() {
		queuePage.clickTryButton();
	}

	@Then("user is navigated to a page having TryEditor with a Run button")
	public void user_is_navigated_to_a_page_having_try_editor_with_a_run_button() {
		Assert.assertTrue(queuePage.isNavigatedToAnswerForm());
	    
	}

	@When("The user is enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_is_enter_valid_python_code_in_try_editor_from_sheet_and(String string, Integer int1) throws IOException, InterruptedException {
		String input = CommonUtils.readExcelWithRow(string, int1, 0);

		queuePage.executeRunButton(input);
	}

	@Then("The user clicks on run button and should be presented with Run result")
	public void the_user_clicks_on_run_button_and_should_be_presented_with_run_result() {
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
	}

	@When("user clicks on Implementation using collections.deque link")
	public void user_clicks_on_implementation_using_collections_deque_link() {
		queuePage.clickHyperLink("implementation-collections");
	}

	@Then("user should navigate to Implementation using collections.deque page")
	public void user_should_navigate_to_implementation_using_collections_deque_page() {
	    Assert.assertTrue(queuePage.verifyTextPresent("Implementation using collections.deque"));
	}


	@Given("user clicks on Implementation using array link")
	public void user_clicks_on_implementation_using_array_link() {
	    queuePage.clickHyperLink("Implementation-array");
	    
	}

	@Then("user should navigate to Implementation using array page")
	public void user_should_navigate_to_implementation_using_array_page() {
	    queuePage.verifyTextPresent("Implementation using array");
	}

	@Given("user clicks on Queue Operations link")
	public void user_clicks_on_queue_operations_link() {
		queuePage.clickHyperLink("QueueOp");
	}

	@Then("user should navigate to Queue Operations page")
	public void user_should_navigate_to_queue_operations_page() {
		queuePage.verifyTextPresent("Queue Operations");
	}

	@Given("user is on Queue Operations page")
	public void user_is_on_queue_operations_page() {
	    driver.get(Constants.QUEUE_OP_URL);
	}

	@Given("user clicks on Practice Questions link")
	public void user_clicks_on_practice_questions_link() {
		queuePage.clickHyperLink("/queue/practice");
	}

	@Then("user should navigate to Practice Questions page")
	public void user_should_navigate_to_practice_questions_page() {
	    Assert.assertTrue(queuePage.verifyTextPresent("Practice Questions"));
	}
	
	@When("The user is enter python code with invalid syntax in tryEditor from sheet {string} and {int}")
	public void the_user_is_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and(String string, Integer int1) throws IOException, InterruptedException {
		//driver.get("https://dsportalapp.herokuapp.com/tryEditor");
		String input = CommonUtils.readExcelWithRow(string, int1, 0);
		
		queuePage.executeRunButton(input);
	}
	
	@Then("The user clicks on run button and should be presented with error result")
	public void the_user_clicks_on_run_button_and_should_be_presented_with_error_result() {
		String expectedAlertMessage="NameError: name 'helloworld' is not defined on line 1";
		String actualAlertMessage= queuePage.getAlertText();
		Assert.assertEquals(expectedAlertMessage,actualAlertMessage);
		driver.switchTo().alert().accept();
	}
	
	@Given("The user clicks {string} button on Implementation of Queue in Python page")
	public void the_user_clicks_button_on_implementation_of_queue_in_python_page(String string) {
	    driver.get("https://dsportalapp.herokuapp.com/queue/implementation-lists/");
	    queuePage.clickTryButton();
	}

	@Given("The user clicks {string} button on collections.deque page")
	public void the_user_clicks_button_on_collections_deque_page(String string) {
	    driver.get("https://dsportalapp.herokuapp.com/queue/implementation-collections/");
	    queuePage.clickTryButton();
	}

	@Given("The user clicks {string} button on Implementation using array page")
	public void the_user_clicks_button_on_implementation_using_array_page(String string) {
		driver.get("https://dsportalapp.herokuapp.com/queue/Implementation-array/");
		queuePage.clickTryButton();
	}

	@Given("The user clicks {string} button on Queue Operations page")
	public void the_user_clicks_button_on_queue_operations_page(String string) {
		driver.get("https://dsportalapp.herokuapp.com/queue/QueueOp/");
		queuePage.clickTryButton();
	}

	
}
