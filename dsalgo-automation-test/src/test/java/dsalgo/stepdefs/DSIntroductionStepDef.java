package dsalgo.stepdefs;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dsalgo.pom.DSIntroduction;
import dsalgo.utilities.Constants;
import dsalgo.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSIntroductionStepDef {

	WebDriver driver = WebDriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	DSIntroduction dsIntroduction = new DSIntroduction(driver, wait);

	@Given("The user is on the DS Algo Home Page")
	public void the_user_is_on_the_ds_algo_home_page() throws InterruptedException {
		driver.get(Constants.DS_HOME_URL);
	}

	@When("The user clicks  Get Started button below the Data structures-Introduction")
	public void the_user_clicks_get_started_button_below_the_data_structures_introduction()
			throws InterruptedException {
		dsIntroduction.clickHyperLink("data-structures-introduction");
	}

	@Then("The user should land in {string} page")
	public void the_user_should_land_in_page(String string) throws InterruptedException {
		dsIntroduction.verifyTextPresent(string);
	}

	@Given("The user is on the Data Structure Introduction Page")
	public void the_user_is_on_the_data_structure_introduction_page() throws InterruptedException {
		dsIntroduction.verifyTextPresent("Time Complexity");
	}

	@When("The user clicks Time Complexity link")
	public void the_user_clicks_time_complexity_link() throws InterruptedException {
		driver.get(Constants.DS_INTRO_URL);
		dsIntroduction.clickHyperLink("time-complexity");
		//WebElement link = driver.findElement(By.xpath("//a[@href=\"time-complexity\"]"));
		//link.click();
	}

	@Then("The user should be redirected to \"Time Complexity\"TC page")
	public void the_user_should_be_redirected_to_time_complexity_tc_page() throws InterruptedException {
		Assert.assertTrue(dsIntroduction.verifyTextPresent("Time Complexity"));
	}

	@Given("The user is on the Time Complexity Page")
	public void the_user_is_on_the_time_complexity_page() {

	}

	@When("The user clicks Try Here  button of Time Complexity page")
	public void the_user_clicks_try_here_button_of_time_complexity_page() {
		driver.get(Constants.DS_INTRO_TIMECOMPLEX);
		driver.findElement(By.linkText("Try here>>>")).click();
	}

	@Then("The user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String string)
			throws InterruptedException {
		Assert.assertTrue(dsIntroduction.isNavigatedToAnswerForm());
	}

	@Given("The user is on the Python Editor")
	public void the_user_is_on_the_python_editor() throws InterruptedException {

	}

	@When("The user clicks the Run Button without entring the code in the Editor")
	public void the_user_clicks_the_run_button_without_entring_the_code_in_the_editor() throws InterruptedException {
		driver.get(Constants.DS_TRY_EDITOR);
		driver.findElement(By.xpath("//button[@onclick=\"runit()\"]")).click();
	}

	@Then("Nothing happens to the page and no error message is displayed")
	public void nothing_happens_to_the_page_and_no_error_message_is_displayed() {
		//To-do:
	}

	@When("The user write the invalid code in Editor and Click the Run Button")
	public void the_user_write_the_invalid_code_in_editor_and_click_the_run_button() throws InterruptedException {
		driver.get(Constants.DS_TRY_EDITOR);
		dsIntroduction.executeRunButton("hello");
	}

	@Then("The user should able to see an error message in alert window")
	public void the_user_should_able_to_see_an_error_message_in_alert_window() {
		String expectedAlertMessage = "NameError: name 'hello' is not defined on line 1";
		String actualAlertMessage = dsIntroduction.getAlertText();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
		driver.switchTo().alert().accept();
	}

	@When("The user write the valid code in Editor and Click the Run Button")
	public void the_user_write_the_valid_code_in_editor_and_click_the_run_button() throws InterruptedException {
		dsIntroduction.executeRunButton("print(\"hello\");");
	}

	@Then("The user should able to see output in the console")
	public void the_user_should_able_to_see_output_in_the_console() {
		Assert.assertEquals("hello", driver.findElement(By.id("output")).getText());
	}

	@When("The user clicks Practice Questions link")
	public void the_user_clicks_practice_questions_link() throws InterruptedException {
		driver.get(Constants.DS_INTRO_TIMECOMPLEX);
		//driver.findElement(By.xpath("//a[@href=\"/data-structures-introduction/practice\"]")).click();
		dsIntroduction.clickHyperLink("/data-structures-introduction/practice");
	}

	@Then("The user doesn't find any practice problems and the page is blank")
	public void the_user_doesn_t_find_any_practice_problems_and_the_page_is_blank() {
		//Assert.assertEquals("practice page not found", driver.findElement(By.id("content")).getText());
	}

}