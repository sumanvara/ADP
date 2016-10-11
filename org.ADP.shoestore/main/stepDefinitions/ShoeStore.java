package stepDefinitions;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import util.BaseUtility;
import util.SeleniumRM;

public class ShoeStore extends SeleniumRM {

	WebDriver driver;
	HomePage homepage;
	BaseUtility baseutility;
	Properties prep;
	
	@Before
	public void setUp() {
		baseutility = new BaseUtility();
		prep = baseutility.LoadPropertyFile();
		
	}

	@Given("^The User is on the Home Page of the application$")
	public void the_User_is_on_the_Home_Page_of_the_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String URL = prep.getProperty("Url");
		String Browser = prep.getProperty("Browser");
		driver = baseutility.browserInitialze(Browser, URL);
		Assert.assertEquals(driver.getCurrentUrl(), URL);
	}

	@Given("^There should be an area to submit email address$")
	public void there_should_be_an_area_to_submit_email_address() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homepage = new HomePage(driver);
		
		Assert.assertTrue(homepage.email().contains(prep.getProperty("EmailLabel")));
	}

	@When("^The user enters the email address$")
	public void the_user_enters_the_email_address(DataTable email) throws Throwable {
		List<List<String>> data = email.raw();
		homepage.enterEmailId(data.get(0).get(0));

	}

	@When("^clicks on submit button$")
	public void clicks_on_submit_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homepage.clickSubmitButton();
	}

	@Then("^The user is displayed with a confirmation message\\.$")
	public void the_user_is_displayed_with_a_confirmation_message() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(homepage.emailConfirmMessage().contains(prep.getProperty("EmailConfirmation")));
	}

	@After
	public void cleanUp() {
		driver.close();
	}

}
