package jdbcTests;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@34.203.226.91:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        //create statement object
        Statement statement = connection.createStatement();
        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select * from regions");

        //move pointer to first row
        resultSet.next();// move your pointer to the nex row//Europe


        //getting information with column name
        System.out.println(resultSet.getString("region_name"));
        //getting information with column index (starts from 1)
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getInt(1) +" - " + resultSet.getString("region_name"));

        //move pointer to second row
        resultSet.next();// Americas

        //getting information with column name
        System.out.println(resultSet.getString("region_name"));
        //getting information with column index (starts from 1)
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getInt(1) +" - " + resultSet.getString("region_name"));

//move pointer to third row
        resultSet.next();//

        System.out.println(resultSet.getInt(1) +" - " + resultSet.getString("region_name"));
        //the output--> 3 - Asia

        //close all connections
        resultSet.close();
        statement.close();
        connection.close();

    }
}
