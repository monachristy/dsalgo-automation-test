package dsalgo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import dsalgo.pom.LoginPage;
import dsalgo.webdriver.WebDriverFactory;

public class ConfigReader {

	static String browserType;
	static Properties properties;

	static String BASE_URL;
	static String USER_NAME;
	static String PASSWORD;

	public static String getBrowserType() throws Throwable {
		if (browserType != null)
			return browserType;
		else
			throw new RuntimeException("browser not specified in the testng.xml");
	}

	public static void setBrowserType(String browser) {
		browserType = browser;
	}

	public static void loadProperties() {
		properties = new Properties();
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream("Config/config.properties");

			properties.load(inputStream);

			BASE_URL = properties.getProperty("url");
			USER_NAME = properties.getProperty("username");
			PASSWORD = properties.getProperty("password");


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initElements() {
		PageFactory.initElements(WebDriverFactory.getDriver(), ConfigReader.class);
	}

}
