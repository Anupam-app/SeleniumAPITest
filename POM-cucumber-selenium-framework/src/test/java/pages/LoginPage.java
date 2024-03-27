package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseDriverClass;

import java.time.Duration;


public class LoginPage extends BaseDriverClass {

	String coulmnText = "//input[@id='%s']";

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//input[@id='login-button']")
	@CacheLookup
	private WebElement loginButton;


	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public String pageTile() {
		return driver.getTitle();
	}

	public void  getUrl(String url) {
		driver.get(url);
	}

	public void setTitle(String name) throws InterruptedException {
		js.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement columnTitle1 = driver.findElement(By.xpath(String.format(coulmnText, "input_name--0")));
		Wait wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(columnTitle1));
		columnTitle1.click();
		columnTitle1.clear();
		columnTitle1.sendKeys(name);
	}
}