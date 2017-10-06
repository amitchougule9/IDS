package com.util;

import java.sql.DriverManager;

/*
The ConnectionConfiguration class creates a connection to the MySQL server and returns that connection.
 */
public class ConnectionConfiguration {
    public static java.sql.Connection GetConnection()
    {
        java.sql.Connection connection = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false", "root","Hotmail1");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return connection;
    }
}
