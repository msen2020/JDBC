package jdbcTests;

import org.testng.annotations.Test;

import java.sql.*;

public class MetaData {

        String dbUrl = "jdbc:oracle:thin:@34.203.226.91:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

       @Test
       public void MetaDataExample() throws SQLException {

       //create connection
       Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
       //create statement object
       Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       //run query and get the result in resultset object
       ResultSet resultSet = statement.executeQuery("select * from employees");

    //get the database related data inside the dbMetadata object
    DatabaseMetaData dbMetadata = connection.getMetaData();

           System.out.println("User =" + dbMetadata.getUserName());
           System.out.println("Database Product Name =" + dbMetadata.getDatabaseProductName());
           System.out.println("Database Product Version =" + dbMetadata.getDatabaseProductVersion());
           System.out.println("Driver Name =" + dbMetadata.getDriverName());
           System.out.println("Driver Version =" + dbMetadata.getDriverVersion());

           //get the resultset object metadata
           ResultSetMetaData rsMetadata = resultSet.getMetaData();

           //how many columns we have ?
           int colCount = rsMetadata.getColumnCount();
           System.out.println(colCount);

           //Print all the column name dynamically
           for (int i = 1 ; i<= colCount; i++){
               System.out.println(rsMetadata.getColumnName(i));
           }

           //column names
//        System.out.println(rsMetadata.getColumnName(1));
//        System.out.println(rsMetadata.getColumnName(2));


       //close all connections
       resultSet.close();
       statement.close();
       connection.close();
    }

}
