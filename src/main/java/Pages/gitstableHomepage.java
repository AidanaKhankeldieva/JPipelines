package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class gitstableHomepage {

    WebDriver driver;

    public gitstableHomepage(){
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

}
