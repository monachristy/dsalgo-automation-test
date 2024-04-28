package dsalgo.runner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dsalgo.utilities.ConfigReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//plugin = { "pretty", "html:target/dsalgo.html" }, 
		//tags = "@Array or @LinkedList or @home-page",//or @ds-introduction-page
		features = { "src/test/resources/features" }, 
		glue = { "dsalgo.hooks", "dsalgo.stepdefs"},
		plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "html:target/dsalgo.html" },
		monochrome = false) 

public class MultithreadTestRunner extends AbstractTestNGCucumberTests {

	private static final Logger logger = LogManager.getLogger(MultithreadTestRunner.class);
	
	@BeforeTest
	@Parameters("browser")
	public void parameterTest(String browser) {
		logger.info("Browser value is : " + browser);
		ConfigReader.setBrowserType(browser);
	}

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {

		return super.scenarios();
	}

}
