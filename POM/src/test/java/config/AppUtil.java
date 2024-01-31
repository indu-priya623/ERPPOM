package config;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import application_layer.LogOutPage;
import application_layer.LoginPage;

public class AppUtil {
	public static WebDriver driver;
	public static Properties conpro;

	@BeforeTest
	public static void setUp() throws Throwable {
		conpro = new Properties();
		conpro.load(new FileInputStream("./PropertyFile/Environment.properties"));
		if (conpro.getProperty("Browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(conpro.getProperty("Url"));
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			login.login("admin", "master");
		} else if (conpro.getProperty("Browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(conpro.getProperty("Url"));
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			login.login("admin", "master");

		} else {
			Reporter.log("Browser is not matching", true);
		}

	}

	@AfterTest
	public static void tearDown() {
		LogOutPage logout = PageFactory.initElements(driver, LogOutPage.class);
		logout.logout();
		driver.quit();
	}

}
