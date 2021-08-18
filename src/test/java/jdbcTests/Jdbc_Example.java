package jdbcTests;

import org.testng.annotations.Test;

import java.sql.*;

public class Jdbc_Example {

    String dbUrl = "jdbc:oracle:thin:@34.203.226.91:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        //create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select * from departments");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }
//========================================
        resultSet = statement.executeQuery("select * from regions");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }
        //close all connections
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void CountNavigate() throws SQLException {

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        //create statement object

        //-->>>>Statement statement = connection.createStatement(); //it only moves forward

        //in order to use ResultSet methods add Type_Scroll_insensitive
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select * from departments");

/*    RESULT SET METHODS
NEXT()--> moves to the next row
PREVIOUS()--> Moves to the previous row
beforeFirst()--> goes before the first row
afterLast()--> goes after last row
getRow()--> gets the current row number
last()--> moves to the last row
absolute()(--> goes to specific row
 */
        //how to find how many rows we have for the query
        //go to last row
        resultSet.last();
        //get the row count
        int rowCount = resultSet.getRow();
        System.out.println(rowCount);
        //we need move before first row to get full list since we are at the last row right now.
        resultSet.beforeFirst();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));

        }
            //close all connections
            resultSet.close();
            statement.close();
            connection.close();


        }
    }

