package StepDefinitions;

import Pages.EtsyHomePage;
import Pages.ResultPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Configuration;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class EtsyStepDefs {

    WebDriver driver = Driver.getDriver();
    EtsyHomePage etsyHP = new EtsyHomePage();
    ResultPage resultP = new ResultPage();

    @Given("^User is on etsy homepage$")
    public void user_is_on_etsy_homepage() throws Throwable {
        driver.get(Configuration.getProperty("etsyUrl"));
    }

    @Then("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String item) throws Throwable {
        etsyHP.searchForItem(item);
    }

    @Then("^User verifies the result is only for searched \"([^\"]*)\"$")
    public void user_verifies_the_result_is_only_for_searched(String item) throws Throwable {
        String actualMessage = resultP.searchMessage.getText();
        Assert.assertEquals(item, actualMessage);
    }

    @Then("^User choose under (\\d+) price range$")
    public void user_choose_under_price_range(int arg1) throws Throwable {
        resultP.under25PriceRange.click();
    }

    @Then("^User verifies the all result prices are under (\\d+)$")
    public void user_verifies_the_all_result_prices_are_under(int priceRange) throws Throwable {
        List<String> discountPrices = resultP.removeOriginalPrice(resultP.priceList, resultP.originalPrices);
        for (String price : discountPrices) {
            if (!price.isEmpty()) {
                Assert.assertTrue(Double.parseDouble(price) <= priceRange);
            }
        }
    }

    @When("^User click on \"([^\"]*)\"$")
    public void user_click_on(String section) throws Throwable {
        if(section.equalsIgnoreCase(etsyHP.Jewelry.getText())){
            etsyHP.Jewelry.click();
        }else if(section.equalsIgnoreCase(etsyHP.Clothing.getText())){
            etsyHP.Clothing.click();
        }else if(section.equalsIgnoreCase(etsyHP.Home.getText())){
            etsyHP.Home.click();
        }else if(section.equalsIgnoreCase(etsyHP.Wedding.getText())){
            etsyHP.Wedding.click();
        }else if(section.equalsIgnoreCase(etsyHP.Toys.getText())){
            etsyHP.Toys.click();
        }else{
            Assert.assertTrue(false);
        }

    }

    @Then("^User verifies \"([^\"]*)\"$")
    public void user_verifies(String title) throws Throwable {
        String actualTitle=driver.getTitle();
        Assert.assertEquals(title,actualTitle);
    }

}