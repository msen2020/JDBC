import java.sql.*;

public class Main4 {

//"select * from departments"

        public static void main(String[] args) throws SQLException {
            String dbUrl = "jdbc:oracle:thin:@34.203.226.91:1521:xe";
            String dbUsername = "hr";
            String dbPassword = "hr";

            //create connection
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            //create statement object
            Statement statement = connection.createStatement();
            //run query and get the result in resultset object
            ResultSet resultSet = statement.executeQuery("select * from departments");

            while (resultSet.next()){
                System.out.println(resultSet.getString(1) +" - "
                        + resultSet.getString(2)
                        +" - "+resultSet.getString(3)
                        +" - "+resultSet.getString(4));
            }

            //close all connections
            resultSet.close();
            statement.close();
            connection.close();

        }
    }
