package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    
    private static final String SERVER_URL =
            "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    
    private static final String DB_NAME = "student_db";

    
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/" + DB_NAME
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static Connection getConnection() {

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection serverConnection =
                    DriverManager.getConnection(
                            SERVER_URL,
                            USER,
                            PASSWORD
                    );

          
            Statement statement = serverConnection.createStatement();

            statement.executeUpdate(
                    "CREATE DATABASE IF NOT EXISTS " + DB_NAME
            );

            statement.close();
            serverConnection.close();

            
            Connection connection =
                    DriverManager.getConnection(
                            DB_URL,
                            USER,
                            PASSWORD
                    );

            
            Statement tableStatement = connection.createStatement();

            String createTable =
                    "CREATE TABLE IF NOT EXISTS students (" +
                    "student_id VARCHAR(50) PRIMARY KEY, " +
                    "student_name VARCHAR(100) NOT NULL, " +
                    "email VARCHAR(150) NOT NULL, " +
                    "password VARCHAR(100) NOT NULL" +
                    ")";

            tableStatement.executeUpdate(createTable);
            tableStatement.close();

            System.out.println("MySQL Connection Successful!");
            System.out.println("Database: " + DB_NAME);
            System.out.println("Table: students");

            return connection;

        } catch (ClassNotFoundException e) {

            System.out.println("MySQL Driver not found!");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("MySQL Connection Failed!");
            e.printStackTrace();
        }

        return null;
    }
}