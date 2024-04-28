package dsalgo.stepdefs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dsalgo.pom.LoginPage;
import dsalgo.utilities.Constants;
import dsalgo.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDef {

	WebDriver driver = WebDriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	LoginPage loginPage = new LoginPage(driver, wait);

	@Given("The user should be open the browser")
	public void the_user_should_be_open_the_browser() {

	}

	@When("The user enter the DS_Algo Portal <URL>")
	public void the_user_enter_the_ds_algo_portal_url() {
		driver.get(Constants.DS_URL);
	}

	@Then("The user should landed on the DS_Algo Get Started page with message {string}")
	public void the_user_should_landed_on_the_ds_algo_get_started_page_with_message(String string)
			throws InterruptedException {
		Assert.assertEquals(loginPage.verifyTextPresent(string), true);
	}

	@Given("The user should open the DS Algo Portal URL in any supported browser")
	public void the_user_should_open_the_ds_algo_portal_url_in_any_supported_browser() {

	}

	@When("The user clicks the {string} button")
	public void the_user_clicks_the_button(String string) throws InterruptedException {
		driver.get(Constants.DS_URL);
		loginPage.clickGetStartButton();
	}

	@Then("The user should land in Data Structure Introduction Page with {string} and {string} links")
	public void the_user_should_land_in_data_structure_introduction_page_with_and_links(String string, String string2)
			throws InterruptedException {

		Assert.assertEquals(loginPage.checkRegister(), string);
		Assert.assertEquals(loginPage.checkSignIn(), string2);
	}

	@When("The user clicks the data structure\"dropdown  arrow\"")
	public void the_user_clicks_the_data_structure_dropdown_arrow() throws InterruptedException {
		loginPage.clickDataStructureDropDownInHomePage();

	}

	@Then("The user should able to see {int} options Arrays {string} in dropdown menu")
	public void the_user_should_able_to_see_options_arrays_in_dropdown_menu(Integer int1, String string)
			throws InterruptedException {
		
		List<WebElement> options = driver.findElements(By.cssSelector("a.dropdown-item"));

		Assert.assertEquals("Arrays", options.get(0).getText());
		Assert.assertEquals("Linked List", options.get(1).getText());
		Assert.assertEquals("Stack", options.get(2).getText());
		Assert.assertEquals("Queue", options.get(3).getText());
		Assert.assertEquals("Tree", options.get(4).getText());
		Assert.assertEquals("Graph", options.get(5).getText());

	}

	@Given("The user is on the DS Introduction page")
	public void the_user_is_on_the_ds_introduction_page() {

	}

	@When("The user selects any data structures item from the drop down without Sign in.")
	public void the_user_selects_any_data_structures_item_from_the_drop_down_without_sign_in() {
		loginPage.clickDataStructureDropDownInHomePage();
		loginPage.selectMenu("Arrays");
	}

	@Then("The user should able to see an warning message {string}")
	public void the_user_should_able_to_see_an_warning_message(String string) {
		Assert.assertTrue(loginPage.verifyTextPresent(string));
		//Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-primary")).getText(), "You are not logged in");
	}

	@When("The user clicks any {string} buttons of data structures  on the DS Introduction page")
	public void the_user_clicks_any_buttons_of_data_structures_on_the_ds_introduction_page(String string) {
		driver.get(Constants.DS_HOME_URL);
		loginPage.clickAnyButton(string);
	}

	@When("The user clicks {string} link on the DS Introduction page")
	public void the_user_clicks_link_on_the_ds_introduction_page(String string) {
		driver.get(Constants.DS_HOME_URL);
		loginPage.clickRegisterLink(string);
	}

	@Then("The user should be redirected to Register form")
	public void the_user_should_be_redirected_to_register_form() {
		ExpectedConditions.urlContains("register");
	}

	@Then("The user should able see message \"Login\"at the bottom of the page")
	public void the_user_should_able_see_message_login_at_the_bottom_of_the_page() {
		Assert.assertTrue(loginPage.verifyTextPresent("Login"));
	}

}
