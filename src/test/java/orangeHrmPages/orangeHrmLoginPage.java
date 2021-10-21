package orangeHrmPages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orangeHrmLoginPage {
    public WebDriver webDriver;


    public orangeHrmLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //locators
    @FindBy(id = "txtUsername")
    WebElement userNameLoginInput;

    @FindBy(id = "txtPassword")
    WebElement userPasswordLoginInput;

    @FindBy(id = "btnLogin")
    WebElement loginSubmitBtn;

    @FindBy(css = "#spanMessage")
    WebElement loginErrorMessage;
    //WebElement userNameLoginInput = webDriver.findElement(By.id("txtUsername"));
    //WebElement userPasswordLoginInput = webDriver.findElement(By.id("txtPassword"));
    //WebElement loginSubmitBtn = webDriver.findElement(By.id("btnLogin"));
    //WebElement loginErrorMessage = webDriver.findElement(By.xpath("//div[@id='divLoginButton']//span[@id='spanMessage']"));


    //methods
    public void setUserName(String userName) {
        userNameLoginInput.sendKeys(userName);
    }

    public void setPassword(String pswd) {
        userPasswordLoginInput.sendKeys(pswd);
    }

    public void submitLogin() {
        loginSubmitBtn.click();
    }

    public void navigateToLoginPage(){
        String webpageTitle = webDriver.getTitle();
        Assert.assertEquals(webpageTitle,"OrangeHRM");
    }

    public void errorMessageWillBeDisplayed(String errorMessage) {
        String element = loginErrorMessage.getText();
        switch (errorMessage) {
            case "Invalid credentials":
                Assert.assertEquals(element,"Invalid credentials");
                break;
            case "Username cannot be empty":
                Assert.assertEquals(element,"Username cannot be empty");
                break;
        }
    }
}
