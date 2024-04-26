package dsalgo.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dsalgo.utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void setDriver() throws Throwable {
		String browser = ConfigReader.getBrowserType();
		System.out.println("browser:::::1" + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void closeDriver() {
		if (WebDriverFactory.getDriver() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

}
