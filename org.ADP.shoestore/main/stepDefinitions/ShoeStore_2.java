package stepDefinitions;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import util.BaseUtility;

public class ShoeStore_2 {
	private List<String> months;

	WebDriver driver;
	HomePage homepage;
	BaseUtility baseutility;
	Properties prep;
	String URL;
	
	@Before
	public void setUp() {
		baseutility = new BaseUtility();
		prep = baseutility.LoadPropertyFile();
		
	}
	
	@Given("^The User is on Home Page$")
	public void the_User_is_on_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		URL = prep.getProperty("Url");
		String Browser = prep.getProperty("Browser");
		driver = baseutility.browserInitialze(Browser, URL);
		Assert.assertEquals(driver.getCurrentUrl(), URL);
	}

	@When("^User clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String month) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		homepage = new HomePage(driver);
		homepage.clickOnMonth(month);
	}

	@Then("^User should be navigated to Monthly display page$")
	public void user_should_be_navigated_to_Monthly_display_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		URL = prep.getProperty("MonthlyPageUrl");
		Assert.assertTrue(driver.getCurrentUrl().contains(URL));
	}

	@Then("^Should display blurb of each shoe with price and image$")
	public void should_display_blurb_of_each_shoe_with_price_and_image() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		baseutility.VerifyShoe();
	}
	
	@After
	public void cleanUp() {
		driver.close();
	}
}

