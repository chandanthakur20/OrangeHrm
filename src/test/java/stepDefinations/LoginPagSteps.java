package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import orangeHrmPages.orangeHrmLandingPage;
import orangeHrmPages.orangeHrmLoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//@RunWith(Cucumber.class)
public class LoginPagSteps {
	public orangeHrmLoginPage loginPage;
	public orangeHrmLandingPage landinPage;
	public WebDriver webDriver;
	public String orangeHrmurl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";


	@Given("^User is on the Login Page$")
	public void user_is_on_the_login_page() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		webDriver = new ChromeDriver(chromeOptions);
		webDriver.manage().window().maximize();
		webDriver.get(orangeHrmurl);
		loginPage = new orangeHrmLoginPage(webDriver);
		landinPage = new orangeHrmLandingPage(webDriver);
		loginPage.navigateToLoginPage();
	}

	@When("^User enters username \"([^\"]*)\"$")
	public void user_enters_username_something(String userName) {
		loginPage.setUserName(userName);
	}

	@Then("^User should landing to Dashboard Page$")
	public void user_should_landing_to_dashboard_page() {
		landinPage.verifyDashbordPage();
	}

	@Then("^Error message should appear \"([^\"]*)\"$")
	public void error_message_should_appear_something(String errorMessage)  {
		loginPage.errorMessageWillBeDisplayed(errorMessage);
	}

	@And("^User enters password \"([^\"]*)\"$")
	public void user_enters_password_something(String password)  {
		loginPage.setPassword(password);
	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button()  {
		loginPage.submitLogin();
	}

}
