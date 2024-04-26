package dsalgo.stepdefs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dsalgo.pom.LoginPage;
import dsalgo.utilities.Constants;
import dsalgo.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

	WebDriver driver = WebDriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	LoginPage signin=new LoginPage(driver, wait) ;
	
	@Given("The user is on the DS Algo Sign in Page")
	public void the_user_is_on_the_ds_algo_sign_in_page() throws InterruptedException {
		driver.get(Constants.DS_LOGIN_URL);
	}

	@When("The user clicks login button after leaving the {string} textbox and {string} textbox blank")
	public void the_user_clicks_login_button_after_leaving_the_textbox_and_textbox_blank(String string, String string2) {
		
	}

	@Then("The error message {string} appears below Username textbox")
	public void the_error_message_appears_below_username_textbox(String string) throws InterruptedException {
		signin.submitLogin();
		String messageStr = signin.getValidationMessage(driver.switchTo().activeElement());
		Assert.assertEquals(messageStr, string);
		
	}

	@When("The user clicks login button after entering the {string} and leaves {string} textbox blank")
	public void the_user_clicks_login_button_after_entering_the_and_leaves_textbox_blank(String string, String string2) throws InterruptedException {
		signin.enterUserId("invalid");
	}

	@Then("The error message {string} appears below Pwd textbox")
	public void the_error_message_appears_below_pwd_textbox(String string) {
		signin.submitLogin();
		String messageStr = signin.getValidationMessage(driver.switchTo().activeElement());
		Assert.assertEquals(messageStr, string);
	}

	@When("The user clicks login button after entering the {string} only")
	public void the_user_clicks_login_button_after_entering_the_only(String string) {
		signin.enterPassword("invalid");
	}

	@When("The user clicks login button after entering invalid username and invalid password")
	public void the_user_clicks_login_button_after_entering_invalid_username_and_invalid_password() {
		signin.enterUserId("invalid");
		signin.enterPassword("invalid");
	}

	@Then("The user should able to see an error message {string}.")
	public void the_user_should_able_to_see_an_error_message(String string) throws InterruptedException {
		signin.submitLogin();
		Assert.assertTrue(signin.verifyTextPresent(string));
	}

	@When("The user clicks login button after entering valid username and invalid password")
	public void the_user_clicks_login_button_after_entering_valid_username_and_invalid_password() {
		signin.enterUserId("dsalgomarch2024");
		signin.enterPassword("invalid");
	}

	@When("The user clicks login button after entering valid username and valid password")
	public void the_user_clicks_login_button_after_entering_valid_username_and_valid_password() {
		signin.enterUserId("dsalgomarch2024");
		signin.enterPassword("Numpy2024");
	}

	@Then("The user should land in Data Structure Home Page")
	public void the_user_should_land_in_data_structure_home_page() throws InterruptedException {
		signin.submitLogin();
		Assert.assertTrue(signin.verifyTextPresent("You are logged in"));
	}

}
