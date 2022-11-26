
package restaurantmanagement;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RestaurantManagement {
    
    public Connection connection;
    Statement statement;       
    public void connectDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ProjectDB;selectMethod=cursor", "sa", "123456");

            System.out.println("DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());

            statement = connection.createStatement();
           ResultSet resultSet = statement
                    .executeQuery("SELECT Customer_Name FROM Customer");
            
            
            while (resultSet.next()) {
                
                System.out.println("Customer NAME:" + 
                        resultSet.getString("Customer_Name"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        RestaurantManagement cnObj = new RestaurantManagement();
        cnObj.connectDB();
    }
    
}