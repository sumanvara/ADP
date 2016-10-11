package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class BaseUtility implements Utility {
	static WebDriver driver;
	private Properties prop;

	public WebDriver browserInitialze(String browser, String url) {
		// TODO Auto-generated method stub
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			InternetExplorerDriverManager.getInstance().setup();
			driver = new InternetExplorerDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();

		return driver;
	}

	public Properties LoadPropertyFile() {
		// TODO Auto-generated method stub
		prop = new Properties();

		try {
			InputStream fis = new FileInputStream(
					"C:\\Users\\varaganti\\workspace\\org.ADP.shoestore\\src\\main\\resources\\config.properties");

			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	public void VerifyShoe() {
		List<WebElement> shoes = driver.findElements(By.id("shoe_list"));
		System.out.println(shoes.size());
		for (WebElement shoe : shoes) {

			WebElement htmltable = driver.findElement(By.xpath("//*[@id='" + shoe + "']/table/tbody"));
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
			for (int rnum = 0; rnum < rows.size(); rnum++) {
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("th"));
				for (int cnum = 0; cnum < columns.size(); cnum++) {
					Assert.assertTrue(columns.get(cnum).getText().contains("value"));
				}
			}
		}
	}
}
