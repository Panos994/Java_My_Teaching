package org.example.OOPChallenges.JDBCConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsertExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "sa";
        String password = "sapass";

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO employees (id, name,salary) VALUES (?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1,101);
            preparedStatement.setString(2,"John Doe");
            preparedStatement.setDouble(3, 50000.0);

            int rowsInserted = preparedStatement.executeUpdate();

            if(rowsInserted > 0){
                System.out.println("New record is added! ");
            }
        } catch(ClassNotFoundException e){
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println("Error during connection or Insertion!");
            e.printStackTrace();
        } finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                if(conn != null) conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
