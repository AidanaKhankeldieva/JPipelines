package StepDefinitions;

import Pages.WebOrdersHomepage;
import Pages.WebOrdersLoginPage;
import Pages.WebOrdersOrdersPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilities.Configuration;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class WebOrdersStepDefs {

    WebDriver driver= Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage=new WebOrdersLoginPage();
    WebOrdersHomepage webOrdersHomepage=new WebOrdersHomepage();
    WebOrdersOrdersPage webOrdersOrdersPage=new WebOrdersOrdersPage();

    @Given("^User is loged in to WebOrders with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_is_loged_in_to_WebOrders_with_and(String username, String password) throws Throwable {
        driver.get(Configuration.getProperty("WebOrdersUrl"));
        webOrdersLoginPage.username.sendKeys(username);
        webOrdersLoginPage.password.sendKeys(password);
        webOrdersLoginPage.loginButton.click();
//        Thread.sleep(5000);
    }

    @Given("^User verifies he is on WebOrder Homepage$")
    public void user_verifies_he_is_on_WebOrder_Homepage() throws Throwable {
        String actualTitle=driver.getTitle();
        String expectedTitle="Web Orders";
        Assert.assertEquals("Actual Title didn't match with expected title: " +
                "\nActual: "+actualTitle+" \nExpected: "+expectedTitle,expectedTitle,actualTitle);
    }

    @Then("^User goes to Orders page$")
    public void user_goes_to_Orders_page() throws Throwable {
        webOrdersHomepage.orderButton.click();
        Thread.sleep(5000);
    }

    @Then("^User creates orders$")
    public void user_creates_orders(DataTable dataTable) throws Throwable {
        List<Map<String,Object>> listOfMaps=dataTable.asMaps(String.class,Object.class);
        System.out.println("Size of List of maps: "+listOfMaps.size());
        System.out.println("Size of map: "+listOfMaps.get(2).size());

        for(int i=0;i<listOfMaps.size();i++){
            webOrdersOrdersPage.quantityBox.clear();
            webOrdersOrdersPage.quantityBox.sendKeys(listOfMaps.get(i).get("Quantity").toString());
            webOrdersOrdersPage.customerName.sendKeys(listOfMaps.get(i).get("Customer name").toString());
            webOrdersOrdersPage.streetBox.sendKeys(listOfMaps.get(i).get("Street").toString());
            webOrdersOrdersPage.cityBox.sendKeys(listOfMaps.get(i).get("City").toString());
            webOrdersOrdersPage.zipBox.sendKeys(listOfMaps.get(i).get("Zip").toString());
            webOrdersOrdersPage.cardNrBox.sendKeys(listOfMaps.get(i).get("Card Nr").toString());
            webOrdersOrdersPage.expireDateBox.sendKeys(listOfMaps.get(i).get("Expire date").toString());
            webOrdersOrdersPage.visaPymtType.click();
            webOrdersOrdersPage.processButton.click();
        }
//        Thread.sleep(10000);
    }

    @Then("^User goes to View All Orders page$")
    public void user_goes_to_View_All_Orders_page() throws Throwable {

    }

    @Then("^User verifies that orders are created$")
    public void user_verifies_that_orders_are_created(DataTable dataTable) throws Throwable {

    }

}
