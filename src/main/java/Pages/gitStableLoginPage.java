package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class gitStableLoginPage {

    WebDriver driver;

    public gitStableLoginPage(){
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="username")
    public WebElement userName;

    @FindBy(id = "password")
    public  WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='alert alert-warning']")
    public WebElement errorMessage;


}
