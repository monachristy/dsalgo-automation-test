package dsalgo.stepdefs;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dsalgo.pom.DSIntroduction;
import dsalgo.pom.StackPage;
import dsalgo.utilities.CommonUtils;
import dsalgo.utilities.Constants;
import dsalgo.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StackStepDefinition {

	WebDriver driver = WebDriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	StackPage stackPage = new StackPage(driver, wait);
	
	
	@Given("The user is on home page")
	public void the_user_is_on_home_page() {

	}

	@When("The user clicks the {string} button in Stack Panel")
	public void the_user_clicks_the_button_in_stack_panel(String string) throws InterruptedException {
		stackPage.clickHyperLink("stack");
	}

	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page(String string) {
		stackPage.verifyTextPresent(string);
	}

	@Given("The user is on the {string} page after logged in")
	public void the_user_is_on_the_page_after_logged_in(String string) {

	}

	@When("The user clicks Operations in Stack link")
	public void the_user_clicks_operations_in_stack_link() throws InterruptedException {
		driver.get(Constants.STACK_URL);
		stackPage.clickHyperLink("operations-in-stack");
	}

	@When("The user clicks {string} button on {string} page")
	public void the_user_clicks_button_on_page(String string, String string2) {
		driver.get(Constants.STACK_URL+string2+"/");
		stackPage.clickTryButton();
	}

	@Then("The user should be redirected to {string} page having an tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_page_having_an_try_editor_with_a_run_button_to_test(String string) {
		Assert.assertTrue(stackPage.isNavigatedToAnswerForm());
	}

	@Given("The user is in a page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test() {
		driver.get("https://dsportalapp.herokuapp.com/tryEditor");
	}

	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String sheetName, Integer rowNumber) throws IOException, InterruptedException {
		String input = CommonUtils.readExcelWithRow(sheetName, rowNumber, 0);
		
		stackPage.executeRunButton(input);
		
	}

	@When("The user clicks on run button")
	public void the_user_clicks_on_run_button() {

	}

	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() {
		Assert.assertEquals("hello",driver.findElement(By.id("output")).getText());
	
	}

	@When("The user enter python code with invalid syntax in tryEditor from sheet {string} and {int}")
	public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and_row_number(String sheetName, Integer rowNumber) throws IOException, InterruptedException {
		String input = CommonUtils.readExcelWithRow(sheetName, rowNumber, 0);
		
		stackPage.executeRunButton(input);
	}
	

	@Then("The user should be presented with error message")
	public void the_user_should_be_presented_with_error_message() {
		String expectedAlertMessage="NameError: name 'helloworld' is not defined on line 1";
		String actualAlertMessage= stackPage.getAlertText();
		Assert.assertEquals(expectedAlertMessage,actualAlertMessage);
		driver.switchTo().alert().accept();
	}

	@Given("The user is on the {string} home page")
	public void the_user_is_on_the_home_page(String string) {
		
	}

	@When("The user select Stack from the dropdown menu")
	public void the_user_select_stack_from_the_dropdown_menu() {
		stackPage.clickDataStructureDropDown();
		stackPage.selectMenu("Stack");
	}

	@Then("The user be redirected to {string} Data Structure Page")
	public void the_user_be_redirected_to_data_structure_page(String string) {
		Assert.assertTrue(stackPage.verifyTextPresent("Stack"));
	}

	@When("The user clicks Implementation link")
	public void the_user_clicks_implementation_link() throws InterruptedException {
		driver.get(Constants.STACK_URL);
		stackPage.clickHyperLink("implementation");
	}

	@When("The user clicks Applications link")
	public void the_user_clicks_applications_link() {
		driver.get(Constants.STACK_URL);
		stackPage.clickHyperLink("stack-applications");
	}


}
