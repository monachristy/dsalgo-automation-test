package dsalgo.hooks;


import java.io.ByteArrayInputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;  
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import dsalgo.webdriver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {

	private static final Logger logger = LogManager.getLogger(Hooks.class);  

	@Before(order = 0)
	public void beforeScenario() throws Throwable {
			WebDriverFactory.setDriver();
			logger.info("Thread Name: "+Thread.currentThread().getName()+" Thread ID: "+Thread.currentThread().getId());
	}

	
	@After(order = 0)
	public void after() throws Exception {
		WebDriverFactory.closeDriver();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario){
		if(WebDriverFactory.getDriver()!=null && scenario.isFailed()){
			logger.info("Capturing failed scenario screenshot...");
			byte[] screenshot = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Failed Scenario Screenshot", new ByteArrayInputStream(screenshot));
		if(WebDriverFactory.getDriver()!=null)
			WebDriverFactory.getDriver().quit();
		}
	}
}
