package StepDefinitions;

import Pages.MyApplicationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilities.Configuration;
import utilities.Driver;
import utilities.JdbcUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbStepDefs {

    WebDriver driver = Driver.getDriver();
    List<Map<String,Object>> listOfUIDatas;

    @Given("^User goes to MyApplication homepage$")
    public void user_goes_to_MyApplication_homepage() throws Throwable {
        driver.get(Configuration.getProperty("MyApplicationUrl"));
        Thread.sleep(5000);
    }

    @Then("^User gets data from UI table$")
    public void user_gets_data_from_UI_table() throws Throwable {
        listOfUIDatas=new ArrayList<>();
        MyApplicationPage myApplicationPage=new MyApplicationPage();

        Map<String, Object> rowMap=new HashMap<>();
        rowMap.put("name", myApplicationPage.firstRowElements.get(0).getText());
        rowMap.put("lastName",myApplicationPage.firstRowElements.get(1).getText());
        rowMap.put("employeeID", myApplicationPage.firstRowElements.get(2).getText());
        rowMap.put("jobTitle",myApplicationPage.firstRowElements.get(3).getText());
        listOfUIDatas.add(rowMap);
        Map<String, Object> rowMap1=new HashMap<>();
        rowMap.put("name", myApplicationPage.secondRowElements.get(0).getText());
        rowMap.put("lastName",myApplicationPage.secondRowElements.get(1).getText());
        rowMap.put("employeeID", myApplicationPage.secondRowElements.get(2).getText());
        rowMap.put("jobTitle",myApplicationPage.secondRowElements.get(3).getText());
        listOfUIDatas.add(rowMap1);
    }

    @And("^Verify that data is matched with DB$")
    public void verify_that_data_is_matched_with_DB() throws Throwable {
        JdbcUtils.establishConnection();
        List<Map<String, Object>> dbListOfMaps=JdbcUtils.runSQLQuery("select e.first_name, e.last_name, e.employee_id, \n" +
                "j.job_title \n" +
                "from employees e join jobs j \n" +
                "using(job_id)\n" +
                "where e.first_name='"+listOfUIDatas.get(0).get("name")+"' " +
                "and e.last_name='"+listOfUIDatas.get(0).get("lastName")+"'");

        System.out.println("dsdsd"+dbListOfMaps.size());
        System.out.println(listOfUIDatas.get(0).get("jobTitle"));

        Assert.assertEquals(dbListOfMaps.get(0).get("FIRST_NAME").toString(),
                listOfUIDatas.get(0).get("name"));
        Assert.assertEquals(dbListOfMaps.get(0).get("LAST_NAME").toString(),
                listOfUIDatas.get(0).get("lastName"));
        Assert.assertEquals(dbListOfMaps.get(0).get("EMPLOYEE_ID").toString(),
                listOfUIDatas.get(0).get("employeeID"));
        Assert.assertEquals(dbListOfMaps.get(0).get("JOB_TITLE").toString(),
                listOfUIDatas.get(0).get("jobTitle"));
    }
}
