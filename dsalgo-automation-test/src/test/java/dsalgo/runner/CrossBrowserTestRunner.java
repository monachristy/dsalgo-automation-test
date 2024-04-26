package dsalgo.runner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import dsalgo.hooks.Hooks;
import dsalgo.utilities.ConfigReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//plugin = { "pretty", "html:target/dsalgo.html" }, 
		//tags = "@signin-page ",//or @ds-introduction-page
		features = { "src/test/resources/features" }, 
		glue = { "dsalgo.hooks", "dsalgo.stepdefs"},
		plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
		monochrome = false) 

public class CrossBrowserTestRunner extends AbstractTestNGCucumberTests {
	
	private static final Logger logger = LogManager.getLogger(CrossBrowserTestRunner.class); 

	@BeforeTest
	@Parameters("browser")
	public void parameterTest(String browser) {
		logger.info("Browser value is : " + browser);
		ConfigReader.setBrowserType(browser);
	}

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}

}
