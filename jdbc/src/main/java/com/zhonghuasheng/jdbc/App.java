package com.zhonghuasheng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost/jsp";
    private static final String user = "postgres";
    private static final String password = "postgres";
    private static Connection conn = null;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

    public static void main( String[] args ) throws SQLException
    {
        Connection con = getConnection();
        Statement statement = con.createStatement();
        String sql = "SELECT * FROM company";
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
            System.out.println(rs.getInt("id"));
        }

        if (rs != null) {
            rs.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (conn != null) {
            conn.close();
        }
    }
}
