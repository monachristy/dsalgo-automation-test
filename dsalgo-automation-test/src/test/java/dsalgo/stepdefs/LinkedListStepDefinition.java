package dsalgo.stepdefs;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dsalgo.pom.DSIntroduction;
import dsalgo.pom.LinkedListPage;
import dsalgo.pom.StackPage;
import dsalgo.utilities.CommonUtils;
import dsalgo.utilities.Constants;
import dsalgo.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinkedListStepDefinition {

	WebDriver driver = WebDriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	LinkedListPage linkedListPage = new LinkedListPage(driver, wait);
	
	@When("The user clicks the {string} button in LinkedList Panel")
	public void the_user_clicks_the_button_in_linked_list_panel(String string) {
		linkedListPage.clickHyperLink("linked-list");
	    
	}

	@Then("The user should be redirected to LinkedList page")
	public void the_user_should_be_redirected_to_linked_list_page() {
		linkedListPage.verifyTextPresent("Linked List");
	    
	}

	@Given("User is on linked list page")
	public void user_is_on_linked_list_page() {
	    
	    
	}

	@When("User clicks on the Introduction link")
	public void user_clicks_on_the_introduction_link() {
		driver.get(Constants.LINKED_LIST_URL);
		linkedListPage.clickHyperLink("introduction");   
	    
	}

	@Then("User will see the Try here editor box")
	public void user_will_see_the_try_here_editor_box() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class = 'btn btn-info']")) . click();
		linkedListPage.executeRunButton("print(\"hello\");");
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
		
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
	    
	}

	@Given("User is now on linked list page")
	public void user_is_now_on_linked_list_page() {
	    
	    
	}

	@When("User clicks on the Creating Linked List")
	public void user_clicks_on_the_creating_linked_list() {
		driver.get(Constants.LINKED_LIST_URL);
		linkedListPage.clickHyperLink("creating-linked-list"); 
	}

	@Then("User will see the Try here editor box and click")
	public void user_will_see_the_try_here_editor_box_and_click() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class = 'btn btn-info']")) . click();
		linkedListPage.executeRunButton("print(\"hello\");");
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
		
	}

	@Given("User is on the linked list page")
	public void user_is_on_the_linked_list_page() {

	}

	@When("User clicks on the Types of Linked List")
	public void user_clicks_on_the_types_of_linked_list() {
		driver.get(Constants.LINKED_LIST_URL);
		linkedListPage.clickHyperLink("types-of-linked-list"); 
	}

	@Then("User will click on Try here editor box")
	public void user_will_click_on_try_here_editor_box() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class = 'btn btn-info']")) . click();
		linkedListPage.executeRunButton("print(\"hello\");");
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
	}

	@Given("User is on the home page")
	public void user_is_on_the_home_page() {

	}

	@When("User clicks on the Linked List in Python")
	public void user_clicks_on_the_linked_list_in_python() {
		driver.get(Constants.LINKED_LIST_URL);
		linkedListPage.clickHyperLink("implement-linked-list-in-python"); 
	}

	@Then("User clicks on Try here editor box")
	public void user_clicks_on_try_here_editor_box() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class = 'btn btn-info']")) . click();
		linkedListPage.executeRunButton("print(\"hello\");");
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
	}

	@Given("User is on home page Linked list")
	public void user_is_on_home_page_linked_list() {

	}

	@When("User clicks on the Traversal link")
	public void user_clicks_on_the_traversal_link() {
		driver.get(Constants.LINKED_LIST_URL);
		linkedListPage.clickHyperLink("traversal"); 
	}

	@Then("User will clicks on Try here editor box")
	public void user_will_clicks_on_try_here_editor_box() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class = 'btn btn-info']")) . click();
		linkedListPage.executeRunButton("print(\"hello\");");
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
	}

	@Given("User is on Data structure Home page")
	public void user_is_on_data_structure_home_page() {

	}

	@When("User clicks on the Insertion link")
	public void user_clicks_on_the_insertion_link() {
		driver.get(Constants.LINKED_LIST_URL);
		linkedListPage.clickHyperLink("insertion-in-linked-list"); 
	}

	@Then("User click on Try here editor box")
	public void user_click_on_try_here_editor_box() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class = 'btn btn-info']")) . click();
		linkedListPage.executeRunButton("print(\"hello\");");
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
	}

	@Given("User is on home page")
	public void user_is_on_home_page() {

	}

	@When("User clicks on the {string}")
	public void user_clicks_on_the(String string) {
		driver.get(Constants.LINKED_LIST_URL);
		linkedListPage.clickHyperLink("deletion-in-linked-list"); 
	}

	@Then("User click on Try here editor")
	public void user_click_on_try_here_editor() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class = 'btn btn-info']")) . click();
		linkedListPage.executeRunButton("print(\"hello\");");
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
	}

	@Given("User is on home page of linked list")
	public void user_is_on_home_page_of_linked_list() {

	}

	@When("User clicks on the Practice Questions")
	public void user_clicks_on_the_practice_questions() {
		driver.get(Constants.LINKED_LIST_URL);
		linkedListPage.clickHyperLink("deletion-in-linked-list");
	}

	@Then("User will see nothing on the page")
	public void user_will_see_nothing_on_the_page() {
		//Assert.assertEquals("practice page not found", driver.findElement(By.id("content")).getText());
	}

}
