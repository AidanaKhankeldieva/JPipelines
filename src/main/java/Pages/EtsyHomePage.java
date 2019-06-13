package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EtsyHomePage {

    WebDriver driver;

    public EtsyHomePage(){
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="search-query")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchButton;

    public void searchForItem(String item){
        searchBox.sendKeys(item);
        searchButton.click();
    }

}
