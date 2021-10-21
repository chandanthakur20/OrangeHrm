package orangeHrmPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orangeHrmLandingPage {

    public WebDriver webDriver;

    public orangeHrmLandingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //Locators
    @FindBy(id = "txtUsername")
    WebElement userNameLoginInput;
    @FindBy(xpath = "//div[@class='head']//h1")
    WebElement dashbordText;


    public void verifyDashbordPage(){
        String element = dashbordText.getText();
        //String elementText = webDriver.findElement(dashbordText).getText();
        Assert.assertEquals(element,"Dashboard");
    }
}
