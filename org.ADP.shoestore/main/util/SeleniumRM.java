package util;

import org.junit.Assert;

import pageObjects.HomePage;

public class SeleniumRM {
	
	HomePage homepage;
	boolean condition;
	
	public boolean AssertTrue(){
		Assert.assertFalse(condition);
		return true;
	}

}
