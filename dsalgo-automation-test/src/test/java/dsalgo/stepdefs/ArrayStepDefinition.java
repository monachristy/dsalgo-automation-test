package dsalgo.stepdefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dsalgo.pom.ArrayPage;
import dsalgo.pom.StackPage;
import dsalgo.utilities.Constants;
import dsalgo.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArrayStepDefinition {

	WebDriver driver = WebDriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	ArrayPage arrayPage = new ArrayPage(driver, wait);
	
	
	@When("The user clicks the {string} button in Array Panel")
	public void the_user_clicks_the_button_in_array_panel(String string) {
		arrayPage.clickHyperLink("array");
	}

	@Then("The user should be redirected to Array page")
	public void the_user_should_be_redirected_to_array_page() {
		arrayPage.verifyTextPresent("Array");
	}

	@Given("user is on the array page")
	public void user_is_on_the_array_page() {
		
	}

	@When("User clicks on the link Arrays in Python")
	public void user_clicks_on_the_link_arrays_in_python() {
		driver.get(Constants.ARRAY_URL);
		arrayPage.clickHyperLink("arrays-in-python");
	}

	@Then("user will see try here editor box")
	public void user_will_see_try_here_editor_box() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='btn btn-info']")).click();//run button

		arrayPage.executeRunButton("print(\"hello\");");
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
		
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(1000);
	}

	@Given("User should be on the array page")
	public void user_should_be_on_the_array_page() {

	}

	@When("User clicks on the link Arrays Using List")
	public void user_clicks_on_the_link_arrays_using_list() {
		driver.get(Constants.ARRAY_URL);
		arrayPage.clickHyperLink("arrays-using-list");
	}

	@Then("user will see try here editor box and click on it")
	public void user_will_see_try_here_editor_box_and_click_on_it() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class = 'btn btn-info']")) . click();
		arrayPage.executeRunButton("print(\"hello\");");
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
		
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(1000);
	}

	@Given("The array page on the app")
	public void the_array_page_on_the_app() {

	}

	@When("User clicks on the link Basic Operations in List")
	public void user_clicks_on_the_link_basic_operations_in_list() {
		driver.get(Constants.ARRAY_URL);
		arrayPage.clickHyperLink("basic-operations-in-lists");
	}

	@Then("User will click on try here box")
	public void user_will_click_on_try_here_box() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class = 'btn btn-info']")) . click();
		arrayPage.executeRunButton("print(\"hello\");");
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
		
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(1000);
	}

	@Given("User should be landing on array page")
	public void user_should_be_landing_on_array_page() {

	}

	@When("User clicks on the link Applications of Array")
	public void user_clicks_on_the_link_applications_of_array() {
		driver.get(Constants.ARRAY_URL);
		arrayPage.clickHyperLink("applications-of-array");
	}

	@Then("User will click on try here editor box")
	public void user_will_click_on_try_here_editor_box() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class = 'btn btn-info']")) . click();
		arrayPage.executeRunButton("print(\"hello\");");
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
		
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(1000);
	}

	@Given("User is at array page")
	public void user_is_at_array_page() {

	}

	@When("User clicks on the link Practice questions")
	public void user_clicks_on_the_link_practice_questions() throws InterruptedException {
		driver.get(Constants.ARRAY_URL);
		driver.findElement(By.xpath("//a[normalize-space()='Applications of Array']")).click();
		driver.findElement(By.xpath("//a[@class='list-group-item list-group-item-light text-info']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Search the array']")).click();
		arrayPage.executeRunButton("print(\"hello\");");
	}

	@Then("User click on try here editor box")
	public void user_click_on_try_here_editor_box() {
		//Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
	}


}
