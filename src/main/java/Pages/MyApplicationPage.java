package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MyApplicationPage {

    WebDriver driver;

    public MyApplicationPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tr[1]//td")
    public List<WebElement> firstRowElements;

    @FindBy(xpath = "//tr[2]//td")
    public List<WebElement> secondRowElements;

    @FindBy(xpath = "//tr[3]//td")
    public List<WebElement> thirdRowElements;

    @FindBy(xpath = "//tr[4]//td")
    public List<WebElement> fourthRowElements;


}
