package demo.appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetupInit {

	public WebDriver driver;

	@BeforeTest
	public void driverInit() {

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"//Driver//chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://quickfuseapps.com/");

	}


	@AfterTest
	public void closeDriver() {

		driver.quit();
	}

}
