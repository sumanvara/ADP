package util;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public interface Utility {

	public WebDriver browserInitialze(String browser, String url);
	public Properties LoadPropertyFile();
	
}
