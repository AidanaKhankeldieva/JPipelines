package Test;

import utilities.JdbcUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class jdbcTest {

    public static void main(String[] args) throws Exception {
        JdbcUtils.establishConnection();
        String salaryFirstEmployee=JdbcUtils.runSQLQuery("SeLeCt * from employees")
                .get(0).get("SALARY").toString();
        System.out.println(salaryFirstEmployee);

        String employeeFirstName=JdbcUtils.runSQLQuery("select first_name from employees")
                .get(0).get("FIRST_NAME").toString();
        System.out.println(employeeFirstName);

        System.out.println( JdbcUtils.rowCount("select * from jobs"));
        System.out.println("-------------");
        // Print all names from employees table
        List<Map<String,Object>> tableWithFirstNames=
                JdbcUtils.runSQLQuery("select * from employees");

        for(int i=0;i<tableWithFirstNames.size(); i++){
            System.out.print(tableWithFirstNames.get(i).get("FIRST_NAME"));
            System.out.println(" "+ tableWithFirstNames.get(i).get("LAST_NAME"));
        }
        JdbcUtils.closeConnections();
    }

}
