package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;

import java.time.Duration;

public class LoginDefinition {
	private WebDriver driver;
	private WebDriverWait wait;
	private LoginPage loginPage;
	//private HomePage homePage;
	
	public LoginDefinition() throws Exception {
		driver = Hooks.driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		loginPage = new LoginPage(driver, wait);
		//homePage = new HomePage(driver, wait);
	}

	@Given("User navigate to {string}")
	public void loginPage(String url) {
		loginPage.getUrl(url);
	}

	@And("validate page title {string}")
	public void submitEmailPassword(String expected) {
		Assert.assertEquals(loginPage.pageTile(),expected);
	}

	@Then("User give the column title {string}")
	public void userSetCoulmnTitle(String title) throws InterruptedException {
		loginPage.setTitle(title);
	}	
}
