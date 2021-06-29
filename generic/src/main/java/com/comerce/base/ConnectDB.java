package com.comerce.base;

import org.testng.annotations.AfterSuite;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ConnectDB {

    public static Connection connection = null;
    public static Statement statement = null;

    static {
        try {
            connection = getConnection("root", "root1234", "peoplentcdb");
            System.out.println("bata base is conected");
            statement = connection.createStatement();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static Connection getConnection(String username, String password, String databaseName) throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("data");
        String url = rb.getString("dburl") + databaseName + "?serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }


    public static ArrayList connectToDbAndGetDtata(String query, String colomn) {
        ArrayList dataList = new ArrayList();
        try {
            ResultSet table = statement.executeQuery(query);
            String data = "";
            while (table.next()) {

                data = table.getString(colomn);
                dataList.add(data);
            }
        } catch (SQLException throwables) {
            System.out.println("The Exception catched");
        }

        return dataList;
    }

    public static ArrayList connectToDbAndGetDtata(String query, String colomn1, String colomn2) {
        ArrayList user = new ArrayList();
        try {
            ResultSet table = statement.executeQuery(query);

            while (table.next()) {
                user.add(table.getString(colomn1));
                user.add(table.getString(colomn2));
            }

        } catch (SQLException throwables) {
            System.out.println("The Exception catched");

        }

        return user;

    }

    public static ArrayList connectToDbAndGetDtata(String query) {
        ArrayList user = new ArrayList();
        try {
            ResultSet table = statement.executeQuery(query);

            while (table.next()) {
                user.add(table.getString("name"));
                user.add(table.getString("email"));
                user.add(table.getString("password"));
            }

        } catch (SQLException throwables) {
            System.out.println("The Exception catched");

        }

        return user;

    }

    @AfterSuite
    public static void cleanUpDatabase(Statement statement, Connection connection) {
        try {
            statement.close();
            connection.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}