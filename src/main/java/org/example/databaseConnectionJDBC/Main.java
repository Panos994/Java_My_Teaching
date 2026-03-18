package org.example.databaseConnectionJDBC;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // JDBC URL, username και password της βάσης
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";
        Connection connection = null;
        try {
            // Φόρτωση του driver (δεν είναι πάντα απαραίτητο στις νεότερες εκδόσεις)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Δημιουργία σύνδεσης
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to the database successfully!");
            // Εδώ μπορείς να εκτελέσεις queries...
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM employees");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        } finally {
            // Κλείσιμο σύνδεσης
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
