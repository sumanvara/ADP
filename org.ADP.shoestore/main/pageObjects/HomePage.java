package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(how = How.ID, using = "remind_email_form")
	WebElement email;

	@FindBy(how = How.NAME, using = "email")
	WebElement email_inputBox;

	@FindBy(how = How.ID, using = "remind_email_submit")
	WebElement email_submitButton;

	@FindBy(how = How.ID, using = "flash")
	WebElement email_confirm;

	@FindBy(how = How.XPATH, using = ".//*[@id='header_nav']/nav/ul/li")
	WebElement month_list;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String email() {
		return email.getText();

	}

	public void enterEmailId(String emailId) {
		email_inputBox.sendKeys(emailId);
	}

	public void clickSubmitButton() {
		email_submitButton.click();
	}

	public String emailConfirmMessage() {
		return email_confirm.getText();
	}

	public void clickOnMonth(String month) {
		List<WebElement> element = driver.findElements(By.xpath(".//*[@id='header_nav']/nav/ul/li"));
		for (WebElement list : element) {
			if (list.getText().contains(month))
				list.click();
		}
	}
}
