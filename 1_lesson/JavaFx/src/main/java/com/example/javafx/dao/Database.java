package com.example.javafx.dao;

import com.example.javafx.HelloApplication;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static String dbURL = "jdbc:sqlite:test.db";


    public static void createNewDatabase() {


        try (Connection conn = DriverManager.getConnection(dbURL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable() {
        // SQLite connection string


        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	Login text NOT NULL,\n"
                + "	Password text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(dbURL);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createDefaultUsers() {
        // SQLite connection string


        // SQL statement for creating a new table
        String sql = "INSERT INTO  Users (Login,Password) VALUES('user1','password1');";

        try (Connection conn = DriverManager.getConnection(dbURL);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean cheakCredential(String login, String password) {
        String sql = "SELECT Login, Password FROM Users WHERE Login=? AND Password=?;";
        boolean isTrue = false;
        try (Connection conn = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1,login);
                pstmt.setString(2,password);
            // create a new table
                ResultSet rs = pstmt.executeQuery();

            //while (rs.next()) {
              //  System.out.println(rs.getString("login") + "\t" +
                //        rs.getString("password"));
           // }
            if (rs.next()) {
                isTrue = true;
            }
            System.out.println(isTrue);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isTrue;
    }


}
