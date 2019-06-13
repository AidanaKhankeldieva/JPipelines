package StepDefinitions;

import Pages.gitStableLoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilities.Configuration;
import utilities.Driver;

public class gitStableStepDefs {

    WebDriver driver= Driver.getDriver();
    gitStableLoginPage gitstableloginP=new gitStableLoginPage();

    @Given("^User is on gitstable website loginpage$")
    public void user_is_on_gitstable_website_loginpage() throws Throwable {
        driver.get(Configuration.getProperty("gitStableUrl"));
    }

    @Then("^User logs in with valid crendetials login \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_valid_crendetials_login_password(String login, String password) throws Throwable {
        gitstableloginP.userName.clear();
        gitstableloginP.userName.sendKeys(login);
        gitstableloginP.password.clear();
        gitstableloginP.password.sendKeys(password);
        gitstableloginP.submitButton.click();
    }

    @Then("^User verifies logged in to homepage$")
    public void user_verifies_logged_in_to_homepage() throws Throwable {
       String actualTitle= driver.getTitle();
        Assert.assertEquals("My home page",actualTitle);
        driver.quit();
    }

    @Then("^User verifies error \"([^\"]*)\" message$")
    public void user_verifies_error_message(String errorMessage) throws Throwable {
        String actualMessage=gitstableloginP.errorMessage.getText();
        Assert.assertEquals(errorMessage,actualMessage);
    }

}
