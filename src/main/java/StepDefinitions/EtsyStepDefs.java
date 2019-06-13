package StepDefinitions;

import Pages.EtsyHomePage;
import Pages.ResultPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Configuration;
import utilities.Driver;

import java.util.List;

public class EtsyStepDefs {

    WebDriver driver= Driver.getDriver();
    EtsyHomePage etsyHP=new EtsyHomePage();
    ResultPage resultP=new ResultPage();

    @Given("^User is on etsy homepage$")
    public void user_is_on_etsy_homepage() throws Throwable {
        driver.get(Configuration.getProperty("etsyUrl"));
    }

    @Then("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String item) throws Throwable {
        etsyHP.searchForItem(item);
    }

    @And("^User verifies the result is only for searched item$")
    public void user_verifies_the_result_is_only_for_searched_item() throws Throwable {
        String actualMessage=resultP.searchMessage.getText();
        Assert.assertEquals("phone wireless charger",actualMessage);
    }

    @Then("^User choose under (\\d+) price range$")
    public void user_choose_under_price_range(int arg1) throws Throwable {
        resultP.under25PriceRange.click();
    }

    @Then("^User verifies the all result prices are under (\\d+)$")
    public void user_verifies_the_all_result_prices_are_under(int priceRange) throws Throwable {
        List<String> discountPrices=resultP.removeOriginalPrice(resultP.priceList,resultP.originalPrices);
        for(String price: discountPrices){
            Assert.assertTrue(Double.parseDouble(price)<=priceRange);
        }
    }
}
