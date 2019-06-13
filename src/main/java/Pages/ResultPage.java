package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class ResultPage {

    WebDriver driver;

    public ResultPage(){
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[@class='display-inline text-smaller']")
    public WebElement searchMessage;

    @FindBy(xpath = "//a[@data-path='Under $25']//span[@class='wt-radio__label']")
    public WebElement under25PriceRange;

    @FindBy(xpath = "//span[@class='currency-value']")
    public List<WebElement> priceList;

        @FindBy(xpath = "//span[@aria-hidden='true']//span[@class='currency-value']")
    public List<WebElement> originalPrices;

    public List<String> removeOriginalPrice(List<WebElement> priceList, List<WebElement> originalPrices){
        List<String> prices=new ArrayList<>();
        begin: for(WebElement price:priceList){
        for(WebElement originalP: originalPrices){
            if(price.getText().equals(originalP.getText())){
                continue begin;
            }
        }
        prices.add(price.getText());
        }
        return prices;
    }


}
