package jdbcTests;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List_Of_Map_Dynamic {

    String dbUrl = "jdbc:oracle:thin:@34.203.226.91:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void ListOfMap() throws SQLException {

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select first_name,last_name,salary,job_id from employees\n" +
                "where rownum <6");


        //get the resultset object metadata
        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        //List for keeping all rows a map
        List<Map<String,Object>> queryData = new ArrayList<>();

        //move to first row
        resultSet.next();
        Map<String,Object> row1 = new HashMap<>();
//-->Column name is always String, but the value is can be int or String or boolean

        row1.put(rsMetadata.getColumnName(1), resultSet.getString(1));
        row1.put(rsMetadata.getColumnName(2) ,resultSet.getString(2));
        row1.put(rsMetadata.getColumnName(3) ,resultSet.getString(3));
        row1.put(rsMetadata.getColumnName(4) ,resultSet.getString(4));

        System.out.println(row1.toString());

       //move to second row
        resultSet.next();
        Map<String,Object> row2 = new HashMap<>();

        row2.put(rsMetadata.getColumnName(1), resultSet.getString(1));
        row2.put(rsMetadata.getColumnName(2) ,resultSet.getString(2));
        row2.put(rsMetadata.getColumnName(3) ,resultSet.getString(3));
        row2.put(rsMetadata.getColumnName(4) ,resultSet.getString(4));

        System.out.println(row2.toString());
        System.out.println(row2.get("SALARY"));

        //adding rows to my list
        queryData.add(row1);
        queryData.add(row2);

        // get steven last name directly from the list
        System.out.println(queryData.get(0).get("LAST_NAME"));


        //close all connections
        resultSet.close();
        statement.close();
        connection.close();
    }
}
