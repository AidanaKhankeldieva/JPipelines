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

    @FindBy(id="catnav-primary-link-10855")
    public WebElement Jewelry;

    @FindBy(id="catnav-primary-link-10923")
    public WebElement Clothing;

    @FindBy(id = "catnav-primary-link-891")
    public WebElement Home;

    @FindBy(id="catnav-primary-link-10983")
    public WebElement Wedding;

    @FindBy(id="catnav-primary-link-11049")
    public WebElement Toys;

}
