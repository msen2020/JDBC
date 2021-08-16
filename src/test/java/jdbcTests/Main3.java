package jdbcTests;

import java.sql.*;

public class Main3 {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@34.203.226.91:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        //create statement object
        Statement statement = connection.createStatement();
        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select first_name,last_name,salary from employees");

        while (resultSet.next()){
        System.out.println(resultSet.getString(1) +" - "+ resultSet.getString(2)+" - "+resultSet.getString(3));
        }

        //close all connections
        resultSet.close();
        statement.close();
        connection.close();

    }
}